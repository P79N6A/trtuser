package com.ztesoft.zsmart.nros.sbc.user.service.impl;

import com.ztesoft.zsmart.nros.base.util.ConvertUtil;
import com.ztesoft.zsmart.nros.sbc.user.domain.organization.MerchantDomain;
import com.ztesoft.zsmart.nros.sbc.user.client.api.MerchantService;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.MerchantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bin.yu
 * @create 2019-04-24 17:11
 **/
@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantDomain merchantDomain;

    @Override
    public MerchantDTO findById(Long id) {
        return ConvertUtil.beanCopy(merchantDomain.findById(id), MerchantDTO.class);
    }


    @Override
    public MerchantDTO findMerchantByOrgId(Long orgId) {
        return ConvertUtil.beanCopy(merchantDomain.findSubsidiaryByOrgId(orgId), MerchantDTO.class);
    }
}
