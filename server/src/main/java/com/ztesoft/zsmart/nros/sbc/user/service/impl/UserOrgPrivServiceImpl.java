package com.ztesoft.zsmart.nros.sbc.user.service.impl;

import com.ztesoft.zsmart.nros.base.util.ConvertUtil;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.UserOrgPriv;
import com.ztesoft.zsmart.nros.sbc.user.domain.user.UserOrgPrivDomain;
import com.ztesoft.zsmart.nros.sbc.user.client.api.UserOrgPrivService;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.UserOrgPrivDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bin.yu
 * @create 2019-05-07 14:18
 **/
@Service
public class UserOrgPrivServiceImpl implements UserOrgPrivService {

    @Autowired
    private UserOrgPrivDomain userOrgPrivDomain;

    @Override
    public List<UserOrgPrivDTO> selectByUserId(Long userId) {
        List<UserOrgPriv> userOrgPrivs = userOrgPrivDomain.selectByUserId(userId);
        return ConvertUtil.listEntity2DTO(userOrgPrivs, UserOrgPrivDTO.class);
    }

    @Override
    public void insertByBatch(List<Long> userIds, List<Long> orgIds, String creator) {
        userOrgPrivDomain.insertByBatch(userIds, orgIds, creator);
    }

    @Override
    public void deleteByUserIdAndOrgId(Long userId, Long orgId) {
        userOrgPrivDomain.deleteByUserIdAndOrgId(userId, orgId);
    }

    @Override
    public void deleteByUserIdAndOrgIds(Long userId, List<Long> orgIds) {
        userOrgPrivDomain.deleteByUserIdAndOrgIds(userId, orgIds);
    }
}
