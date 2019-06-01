package com.ztesoft.zsmart.nros.sbc.user.domain.organization;

import com.ztesoft.zsmart.nros.base.util.ConvertUtil;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.MerchantMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.generator.MerchantDOMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.OrgDetail;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.MerchantDO;
import com.ztesoft.zsmart.nros.sbc.user.common.enums.DataStateEnum;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.MerchantDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.OrgDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 商家domain
 *
 * @author bin.yu
 * @create 2019-04-24 16:55
 **/
@Component("D")
public class MerchantDomain extends AbstractOrgDomain<OrgDetailDTO> {

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private MerchantDOMapper merchantDOMapper;

    @Override
    public void addOrg(OrgDetailDTO org) {
        MerchantDO merchantDO = detailDTO2DetailDO(org.getMerchantDTO());
        merchantDO.setOrgId(org.getOrgId());
        merchantDO.setName(org.getOrgName());
        merchantMapper.insert(merchantDO);

    }

    @Override
    public void updateOrg(OrgDetailDTO org) {
        MerchantDO merchantDO = detailDTO2DetailDO(org.getMerchantDTO());
        merchantDO.setName(org.getOrgName());
        merchantMapper.updateByOrgIdSelective(merchantDO);
    }

    @Override
    public void deleted(Long orgId) {
        MerchantDO merchantDO = new MerchantDO();
        merchantDO.setOrgId(orgId);
        merchantDO.setState(DataStateEnum.X.getCode());
        merchantMapper.updateByOrgIdSelective(merchantDO);
    }

    @Override
    public OrgDetail findByOrgId(Long orgId) {
        OrgDetail orgDetail = new OrgDetail();
        MerchantDO merchantDO = merchantMapper.selectByOrgId(orgId);
        orgDetail.setMerchantDO(merchantDO);
        return orgDetail;        }

    public MerchantDO findById(Long id) {
        return merchantDOMapper.selectByPrimaryKey(id);
    }

    public MerchantDO findSubsidiaryByOrgId(Long orgId) {
        return merchantMapper.selectByOrgId(orgId);
    }


    private MerchantDO detailDTO2DetailDO(MerchantDTO merchantDTO) {
        return ConvertUtil.beanCopy(merchantDTO, MerchantDO.class);
    }
}
