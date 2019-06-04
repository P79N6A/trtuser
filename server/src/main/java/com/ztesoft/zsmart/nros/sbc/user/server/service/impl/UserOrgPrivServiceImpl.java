package com.ztesoft.zsmart.nros.sbc.user.server.service.impl;

import com.ztesoft.zsmart.nros.base.util.ConvertUtil;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.UserOrgPriv;
import com.ztesoft.zsmart.nros.sbc.user.server.domain.authorization.AuthorizationDomain;
import com.ztesoft.zsmart.nros.sbc.user.client.api.UserOrgPrivService;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.UserOrgPrivDTO;
import com.ztesoft.zsmart.nros.sbc.user.server.domain.authorization.model.AuthorizationBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bin.yu
 * @create 2019-05-07 14:18
 **/
@Service
public class UserOrgPrivServiceImpl implements UserOrgPrivService {

    @Autowired
    private AuthorizationDomain userOrgPrivDomain;

    @Override
    public List<UserOrgPrivDTO> selectByUserId(Long userId) {
        return userOrgPrivDomain.selectByUserId(userId);
    }

    @Override
    public int insertByBatch(List<Long> userIds, List<Long> orgIds, String creator) {
        List<AuthorizationBO> userPrivBO = new ArrayList<>();
        for (Long userId : userIds) {
            for (Long orgId : orgIds) {
                AuthorizationBO authorizationBO = new AuthorizationBO();
                authorizationBO.setUserId(userId);
                authorizationBO.setOrgId(orgId);
                userPrivBO.add(authorizationBO);
            }
        }
        return userOrgPrivDomain.insertByBatch(userPrivBO);
    }

    @Override
    public int deleteByUserIdAndOrgId(Long userId, Long orgId) {
        return userOrgPrivDomain.deleteByUserIdAndOrgId(userId, orgId);
    }

    @Override
    public int deleteByUserIdAndOrgIds(Long userId, List<Long> orgIds) {
        return userOrgPrivDomain.deleteByUserIdAndOrgIds(userId, orgIds);
    }
}
