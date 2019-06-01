package com.ztesoft.zsmart.nros.sbc.user.client.api;

import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.MerchantDTO;

/**
 * @author bin.yu
 * @create 2019-04-24 17:10
 **/
public interface MerchantService {

    MerchantDTO findById(Long id);


    MerchantDTO findMerchantByOrgId(Long orgId);
}
