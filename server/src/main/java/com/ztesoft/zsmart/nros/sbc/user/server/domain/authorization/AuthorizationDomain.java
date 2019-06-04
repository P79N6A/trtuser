package com.ztesoft.zsmart.nros.sbc.user.server.domain.authorization;

import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.UserOrgPrivDTO;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.mapper.UserOrgPrivMapper;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.mapper.generator.UserOrgPrivDOMapper;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.UserOrgPriv;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.UserOrgPrivDO;
import com.ztesoft.zsmart.nros.sbc.user.server.domain.authorization.model.AuthorizationBO;
import com.ztesoft.zsmart.nros.sbc.user.server.repository.UserOrgPrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户数据权限
 *
 * @author bin.yu
 * @create 2019-05-07 13:47
 **/
@Component
public class AuthorizationDomain {

    @Autowired
    private UserOrgPrivilegeRepository userOrgPrivilegeRepository;

    public List<UserOrgPrivDTO> selectByUserId(Long userId) {
        return userOrgPrivilegeRepository.selectByUserId(userId);
    }

    public int insertByBatch(List<AuthorizationBO> authorizationBOList){
        return userOrgPrivilegeRepository.insertByBatch(authorizationBOList);
    }

    public int deleteByUserIdAndOrgId(Long userId, Long orgId){
       return userOrgPrivilegeRepository.deleteByUserIdAndOrgId(userId, orgId);
    }

    public int deleteByUserIdAndOrgIds(Long userId, List<Long> orgIds){
       return userOrgPrivilegeRepository.deleteByUserIdAndOrgIds(userId, orgIds);
    }
}
