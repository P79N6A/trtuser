package com.ztesoft.zsmart.nros.sbc.user.service.impl;

import com.ztesoft.zsmart.nros.base.exception.ExceptionHandler;
import com.ztesoft.zsmart.nros.base.util.ConvertUtil;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.OrgDetail;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.StaffOrg;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.OrgDO;
import com.ztesoft.zsmart.nros.sbc.user.domain.organization.AbstractOrgDomain;
import com.ztesoft.zsmart.nros.sbc.user.domain.organization.OrgDomain;
import com.ztesoft.zsmart.nros.sbc.user.common.enums.ExceptionCodeEnum;
import com.ztesoft.zsmart.nros.sbc.user.client.api.OrgService;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.ChannelDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.OrgDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.OrgDetailDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.StaffOrgDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.StoreDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.WarehouseDTO;
import jodd.bean.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author bin.yu
 * @create 2019-04-22 14:14
 **/
@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private OrgDomain orgDomain;

    @Autowired
    private Map<String, AbstractOrgDomain> orgServiceMap;

    @Override
    public List<OrgDTO> queryOwnedOrgListByStaffId(Long staffId) {
        List<OrgDO> orgDOS = orgDomain.queryOwnedOrgListByStaffId(staffId);
        return ConvertUtil.listEntity2DTO(orgDOS, OrgDTO.class);
    }

    @Override
    public List<OrgDTO> queryOrgListByParentId(Long orgId) {
        List<OrgDO> orgDOS = orgDomain.queryOrgListByParentId(orgId);
        return ConvertUtil.listEntity2DTO(orgDOS,OrgDTO.class);
    }

    @Override
    public OrgDetailDTO findOrgByOrgId(Long orgId) {
        OrgDO orgDO = orgDomain.findOrgByOrgId(orgId);
        if (orgDO == null) {
            ExceptionHandler.publish(ExceptionCodeEnum.USER_ORG_UN_EXISTED.getCode());
        }
        AbstractOrgDomain baseOrgDomain=orgServiceMap.get(orgDO.getOrgType());
        OrgDetail orgDetail = baseOrgDomain.findByOrgId(orgId);
        BeanCopy.beans(orgDO, orgDetail).copy();
        return detailDO2DetailDTO(orgDetail);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addOrg(OrgDetailDTO orgDetail) {
        orgDomain.addOrg(orgDetail);
        AbstractOrgDomain baseOrgDomain=orgServiceMap.get(orgDetail.getOrgType());
        baseOrgDomain.addOrg(orgDetail);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modOrg(OrgDetailDTO orgDetail) {
        orgDomain.modOrg(orgDetail);
        AbstractOrgDomain baseOrgDomain=orgServiceMap.get(orgDetail.getOrgType());
        baseOrgDomain.updateOrg(orgDetail);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delOrg(Long orgId) {
        OrgDO orgDO = orgDomain.findOrgByOrgId(orgId);
        if (orgDO == null) {
            ExceptionHandler.publish(ExceptionCodeEnum.USER_ORG_UN_EXISTED.getCode());
        }
        AbstractOrgDomain baseOrgDomain=orgServiceMap.get(orgDO.getOrgType());
        baseOrgDomain.deleted(orgId);
    }

    @Override
    public List<StaffOrgDTO> selectStaffOrg(Long staffId, String orgType) {
        List<StaffOrg> staffOrgs = orgDomain.selectStaffOrg(staffId, orgType);
        return ConvertUtil.listEntity2DTO(staffOrgs,StaffOrgDTO.class);
    }

    /**
     * DO 转 DTO
     *
     * @param orgDetail
     * @return
     */
    private OrgDetailDTO detailDO2DetailDTO(OrgDetail orgDetail) {
        //转公共属性
        OrgDetailDTO orgDetailDTO = ConvertUtil.beanCopy(orgDetail, OrgDetailDTO.class);
        if (orgDetail.getChannelDO() != null) {
            ChannelDTO channelDTO = ConvertUtil.beanCopy(orgDetail.getChannelDO(), ChannelDTO.class);
            orgDetailDTO.setChannelDTO(channelDTO);
        } else if (orgDetail.getStoreDO() != null) {
            StoreDTO storeDTO = ConvertUtil.beanCopy(orgDetail.getStoreDO(), StoreDTO.class);
            orgDetailDTO.setStoreDTO(storeDTO);
        } else if (orgDetail.getWarehouseDO() != null) {
            WarehouseDTO warehouseDTO = ConvertUtil.beanCopy(orgDetail.getWarehouseDO(), WarehouseDTO.class);
            orgDetailDTO.setWarehouseDTO(warehouseDTO);
        }
        return orgDetailDTO;
    }

}
