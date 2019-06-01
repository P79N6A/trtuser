package com.ztesoft.zsmart.nros.sbc.user.domain.organization;

import com.ztesoft.zsmart.nros.base.exception.ExceptionHandler;
import com.ztesoft.zsmart.nros.base.util.ConvertUtil;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.ChannelMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.MerchantMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.OrgMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.StoreMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.SubsidiaryMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.WarehouseMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.generator.*;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.OrgDetail;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.StaffOrg;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.OrgDO;
import com.ztesoft.zsmart.nros.sbc.user.common.enums.DataStateEnum;
import com.ztesoft.zsmart.nros.sbc.user.common.enums.ExceptionCodeEnum;
import com.ztesoft.zsmart.nros.sbc.user.client.api.OrgService;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.OrgDetailDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author bin.yu
 * @create 2019-04-22 13:37
 **/
@Component
public class OrgDomain {

    @Autowired
    private OrgDOMapper orgDOMapper;

    @Autowired
    private OrgMapper orgMapper;

    @Autowired
    private ChannelDOMapper channelDOMapper;

    @Autowired
    private ChannelMapper channelMapper;

    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private StoreDOMapper storeDOMapper;

    @Autowired
    private WarehouseDOMapper warehouseDOMapper;

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Autowired
    private MerchantDOMapper merchantDOMapper;

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private SubsidiaryDOMapper subsidiaryDOMapper;

    @Autowired
    private SubsidiaryMapper subsidiaryMapper;

    @Autowired
    private Map<String, OrgService> orgServiceMap;

    /**
     * Description: 通过员工Id查询所有顶级组织列表<br>
     *
     * @return List<OrgDO> 组织Dto列表 <br>
     */
    public List<OrgDO> queryOwnedOrgListByStaffId(Long staffId) {
        List<OrgDO> allList = orgMapper.selectAllOrgList(DataStateEnum.A.getCode(), null, null);
        List<OrgDO> srcList = orgMapper.selectStaffOrgList(staffId, null, null, null, null, null,
                DataStateEnum.A.getCode(), null);
        if (!srcList.isEmpty()) {
            List<String> resultList;
            if (srcList.size() > 1) {
                int maxId = orgMapper.getMaxOrgId();
                OrgDO[] orgs = new OrgDO[maxId + 1];
                for (OrgDO dto : allList) {
                    orgs[dto.getOrgId().intValue()] = dto;
                }
                // 取父节点
                List<OrgDO> parent = getParent(srcList, orgs);
                resultList = getIdList(parent);
            } else {
                resultList = getIdList(srcList);
            }
            List<Long> list = new ArrayList<>();
            for (String string : resultList) {
                list.add(Long.parseLong(string));
            }
            return orgMapper.selectOrgListByIds(list, null, DataStateEnum.A.getCode(), null, null);
        }
        else {
            return new ArrayList<>();
        }
    }

    /**
     * 获取直属下级机构
     * @param orgId
     * @return
     */
    public List<OrgDO> queryOrgListByParentId(Long orgId) {
        return orgMapper.selectOrgListByParentId(orgId);
    }

    /**
     * 新增机构详情
     * @param orgDetailDTO
     * @return
     */
    public OrgDetail addOrg(OrgDetailDTO orgDetailDTO){
        boolean exist = checkRootOrgTypeExist(orgDetailDTO.getParentOrgId(), orgDetailDTO.getOrgType());
        if (exist) {
            // TODO: 2019/4/24 异常抛出方式待处理
            ExceptionHandler.publish(ExceptionCodeEnum.USER_ORG_EXISTED.getCode());

        }
        OrgDetail orgDetail = detailDTO2DetailDO(orgDetailDTO);
        orgDetail.setSpId(0);
        orgDetail.setState(DataStateEnum.A.getCode());
        Date now = new Date();
        orgDetail.setStateDate(now);
        orgDOMapper.insert(orgDetail);
        return orgDetail;
    }


    /**
     * 修改机构详情
     * @param orgDetailDTO
     * @return
     */
    public OrgDetail modOrg(OrgDetailDTO orgDetailDTO){
        OrgDetail orgDetail = detailDTO2DetailDO(orgDetailDTO);
        orgDOMapper.updateByPrimaryKeySelective(orgDetail);
        return orgDetail;
    }

    /**
     * 删除机构详情
     * @param orgId
     * @return
     */
    public void delOrg(Long orgId){
        List<OrgDO> subOrgDOs = orgMapper.selectOrgListByParentId(orgId);
        if (CollectionUtils.isNotEmpty(subOrgDOs)) {
            ExceptionHandler.publish(ExceptionCodeEnum.USER_ORG_EXIST_CHILD_NODE.getCode());
        }
        OrgDO orgDO = orgDOMapper.selectByPrimaryKey(orgId);
        orgDO.setState(DataStateEnum.X.getCode());
        orgDOMapper.updateByPrimaryKeySelective(orgDO);
     }

    /**
     * 查询机构详情信息
     * @param orgId
     * @return
     */
    public OrgDO findOrgByOrgId(Long orgId) {
         OrgDO orgDO = orgDOMapper.selectByPrimaryKey(orgId);
         return orgDO;
    }

    /**
     * 查询员工相关的机构信息
     * @param staffId
     * @param orgType
     * @return
     */
    public List<StaffOrg> selectStaffOrg(Long staffId, String orgType) {
        return orgMapper.selectStaffOrg(staffId, orgType);
    }

    private List<OrgDO> getParent(List<OrgDO> srcList, OrgDO[] orgs) {
        List<OrgDO> rtnValue = new ArrayList<>();
        for (OrgDO org : srcList) {
            if (judgeParent(org, srcList, orgs)) {
                rtnValue.add(org);
            }
        }
        return rtnValue;
    }

    private boolean judgeParent(OrgDO org, List<OrgDO> srcList, OrgDO[] orgs) {
        while (org.getParentOrgId() != null) {
            for (OrgDO dto : srcList) {
                if (dto.getOrgId().equals(org.getParentOrgId())) {
                    return false;
                }
            }
            org = orgs[org.getParentOrgId().intValue()];
        }
        return true;
    }



    /**
     * 获取指定数据内的ID集合 Description: <br>
     *
     * @param finalDirList
     * @return
     * @author ARC2<br>
     * @taskId <br>
     */
    private List<String> getIdList(List<OrgDO> finalDirList) {
        ArrayList<String> partyIdList = new ArrayList<String>();
        for (int i = 0; i < finalDirList.size(); i++) {
            partyIdList.add(String.valueOf(finalDirList.get(i).getOrgId()));
        }
        return partyIdList;
    }

    private List<Long> getIdLongList(List<OrgDO> finalDirList) {
        List<Long> partyIdList = new ArrayList<>();
        for (int i = 0; i < finalDirList.size(); i++) {
            partyIdList.add(finalDirList.get(i).getOrgId());
        }
        return partyIdList;
    }
    /**
     * 校验顶级节点下的直属节点类型是否已存在
     * @param parentOrgId 父级节点
     * @param orgType 节点类型
     * @return false-不存在，true-已存在
     */
    private boolean checkRootOrgTypeExist(Long parentOrgId, String orgType) {
        boolean flag = false;
        OrgDO rootOrgDo = orgDOMapper.selectByPrimaryKey(parentOrgId);
        // 判断上级是否是顶级节点，上级非顶级节点不做判断，
        if ( rootOrgDo != null && rootOrgDo.getParentOrgId() == null) {
            List<OrgDO> orgDOS = orgMapper.selectOrgListByParentId(parentOrgId);
            if (CollectionUtils.isNotEmpty(orgDOS)) {
                Optional<OrgDO> optional = orgDOS.stream().filter(o -> orgType.equals(o.getOrgType())).findAny();
                if (optional.isPresent()) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    /**
     * DTO 转 DO
     *
     * @param orgDetailDTO
     * @return
     */
    private OrgDetail detailDTO2DetailDO(OrgDetailDTO orgDetailDTO) {
        //转公共属性
        OrgDetail orgDetail = ConvertUtil.beanCopy(orgDetailDTO, OrgDetail.class);
//
//        if (orgDetailDTO.getChannelDTO() != null) {
//            ChannelDO channelDO = ConvertUtil.beanCopy(orgDetailDTO.getChannelDTO(), ChannelDO.class);
//            orgDetail.setChannelDO(channelDO);
//        }
//        if (orgDetailDTO.getStoreDTO() != null) {
//            StoreDO storeDO = ConvertUtil.beanCopy(orgDetailDTO.getStoreDTO(), StoreDO.class);
//            orgDetail.setStoreDO(storeDO);
//        }
//        if (orgDetailDTO.getWarehouseDTO() != null) {
//            WarehouseDO warehouseDO = ConvertUtil.beanCopy(orgDetailDTO.getWarehouseDTO(), WarehouseDO.class);
//            orgDetail.setWarehouseDO(warehouseDO);
//        }
//        if (orgDetailDTO.getMerchantDTO() != null) {
//            MerchantDO merchantDO = ConvertUtil.beanCopy(orgDetailDTO.getMerchantDTO(), MerchantDO.class);
//            orgDetail.setMerchantDO(merchantDO);
//        }
//        if (orgDetailDTO.getSubsidiaryDTO() != null) {
//            SubsidiaryDO subsidiaryDO = ConvertUtil.beanCopy(orgDetailDTO.getSubsidiaryDTO(), SubsidiaryDO.class);
//            orgDetail.setSubsidiaryDO(subsidiaryDO);
//        }
        return orgDetail;
    }


}
