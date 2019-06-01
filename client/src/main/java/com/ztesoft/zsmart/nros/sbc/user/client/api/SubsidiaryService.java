package com.ztesoft.zsmart.nros.sbc.user.client.api;

import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.SubsidiaryDTO;

/**
 * @author bin.yu
 * @create 2019-04-24 17:10
 **/
public interface SubsidiaryService {

    SubsidiaryDTO findById(Long id);

    SubsidiaryDTO findSubsidiaryByOrgId(Long orgId);
}
