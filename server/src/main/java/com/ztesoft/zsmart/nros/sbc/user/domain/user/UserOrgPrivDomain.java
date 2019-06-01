package com.ztesoft.zsmart.nros.sbc.user.domain.user;

import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.UserOrgPrivMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.generator.UserOrgPrivDOMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.UserOrgPriv;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.UserOrgPrivDO;
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
public class UserOrgPrivDomain {

    @Autowired
    private UserOrgPrivMapper userOrgPrivMapper;

    @Autowired
    private UserOrgPrivDOMapper userOrgPrivDOMapper;

    public List<UserOrgPriv> selectByUserId(Long userId) {
        return userOrgPrivMapper.selectByUserId(userId);
    }

    public void insertByBatch(List<Long> userIds, List<Long> orgIds, String creator) {
        List<UserOrgPrivDO> userPrivs = new ArrayList<>();
        Date now = new Date();
        for (Long userId : userIds) {
            for (Long orgId : orgIds) {
                UserOrgPrivDO userOrgPrivDO = new UserOrgPrivDO();
                userOrgPrivDO.setUserId(userId);
                userOrgPrivDO.setOrgId(orgId);
                userOrgPrivDO.setCreator(creator);
                userOrgPrivDO.setGmtCreate(now);
                userPrivs.add(userOrgPrivDO);
            }
        }
        userOrgPrivMapper.insertByBatch(userPrivs);
    }

    public int deleteByUserIdAndOrgId(Long userId, Long orgId){
       return userOrgPrivMapper.deleteByUserIdAndOrgId(userId, orgId);
    }

    public int deleteByUserIdAndOrgIds(Long userId, List<Long> orgIds){
       return userOrgPrivMapper.deleteByUserIdAndOrgIds(userId, orgIds);
    }
}
