package com.ztesoft.zsmart.nros.sbc.user.service.impl;

import com.ztesoft.zsmart.nros.base.util.ConvertUtil;
import com.ztesoft.zsmart.nros.sbc.user.domain.organization.SubsidiaryDomain;
import com.ztesoft.zsmart.nros.sbc.user.client.api.SubsidiaryService;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.SubsidiaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bin.yu
 * @create 2019-04-24 17:15
 **/
@Service
public class SubsidiaryServiceImpl implements SubsidiaryService {

    @Autowired
    private SubsidiaryDomain subsidiaryDomain;

    @Override
    public SubsidiaryDTO findById(Long id) {
        return ConvertUtil.beanCopy(subsidiaryDomain.findById(id),SubsidiaryDTO.class);
    }

    @Override
    public SubsidiaryDTO findSubsidiaryByOrgId(Long orgId) {
        return ConvertUtil.beanCopy(subsidiaryDomain.findSubsidiaryByOrgId(orgId), SubsidiaryDTO.class);
    }
}
