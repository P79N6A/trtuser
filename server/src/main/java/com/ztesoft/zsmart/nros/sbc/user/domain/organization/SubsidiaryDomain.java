package com.ztesoft.zsmart.nros.sbc.user.domain.organization;

import com.ztesoft.zsmart.nros.base.util.ConvertUtil;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.SubsidiaryMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.generator.SubsidiaryDOMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.OrgDetail;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.SubsidiaryDO;
import com.ztesoft.zsmart.nros.sbc.user.common.enums.DataStateEnum;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.OrgDetailDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.SubsidiaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 子公司domain
 *
 * @author bin.yu
 * @create 2019-04-24 16:56
 **/
@Component("E")
public class SubsidiaryDomain extends AbstractOrgDomain<OrgDetailDTO> {

    @Autowired
    private SubsidiaryMapper subsidiaryMapper;

    @Autowired
    private SubsidiaryDOMapper subsidiaryDOMapper;


    @Override
    public void addOrg(OrgDetailDTO org) {
        SubsidiaryDO subsidiaryDO=detailDTO2DetailDO(org.getSubsidiaryDTO());
        subsidiaryDO.setOrgId(org.getOrgId());
        subsidiaryDO.setName(org.getOrgName());
        subsidiaryMapper.insert(subsidiaryDO);
    }

    @Override
    public void updateOrg(OrgDetailDTO org) {
        SubsidiaryDO subsidiaryDO=detailDTO2DetailDO(org.getSubsidiaryDTO());
        subsidiaryDO.setName(org.getOrgName());
        subsidiaryMapper.updateByOrgIdSelective(subsidiaryDO);
    }

    @Override
    public void deleted(Long orgId) {
        SubsidiaryDO subsidiaryDO = new SubsidiaryDO();
        subsidiaryDO.setState(DataStateEnum.X.getCode());
        subsidiaryDO.setOrgId(orgId);
        subsidiaryMapper.updateByOrgIdSelective(subsidiaryDO);
    }

    @Override
    public OrgDetail findByOrgId(Long orgId) {
        OrgDetail orgDetail = new OrgDetail();
        SubsidiaryDO subsidiaryDO = subsidiaryMapper.selectByOrgId(orgId);
        orgDetail.setSubsidiaryDO(subsidiaryDO);
        return orgDetail;
    }

    public SubsidiaryDO findById(Long id) {
        return subsidiaryDOMapper.selectByPrimaryKey(id);
    }


    public SubsidiaryDO findSubsidiaryByOrgId(Long orgId) {
        return subsidiaryMapper.selectByOrgId(orgId);
    }

    private SubsidiaryDO detailDTO2DetailDO(SubsidiaryDTO subsidiaryDTO) {
        return ConvertUtil.beanCopy(subsidiaryDTO, SubsidiaryDO.class);
    }


}
