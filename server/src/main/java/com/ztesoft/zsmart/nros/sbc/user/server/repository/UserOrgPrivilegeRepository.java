package com.ztesoft.zsmart.nros.sbc.user.server.repository;

import com.ztesoft.zsmart.nros.core.repository.BaseRepository;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.UserOrgPrivDTO;
import com.ztesoft.zsmart.nros.sbc.user.server.common.convertor.UserOrgPrivConvertor;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.UserOrgPriv;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.UserOrgPrivDO;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.mapper.UserOrgPrivMapper;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.mapper.generator.UserOrgPrivDOMapper;
import com.ztesoft.zsmart.nros.sbc.user.server.domain.authorization.model.AuthorizationBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 机构权限repository
 * User: yaodingw
 * Date: 2019-06-03
 * Time: 15:43
 */
@Repository
public class UserOrgPrivilegeRepository implements BaseRepository {

    @Autowired
    private UserOrgPrivDOMapper userOrgPrivDOMapper;

    @Autowired
    private UserOrgPrivMapper userOrgPrivMapper;

    @Autowired
    private UserOrgPrivConvertor userOrgPrivConvertor;


    /**
     * 根据用户ID查找用户的机构权限列表
     * @param userId
     * @return
     */
    public List<UserOrgPrivDTO> selectByUserId(Long userId) {
        List<UserOrgPriv> userOrgPrivList = userOrgPrivMapper.selectByUserId(userId);
        List<UserOrgPrivDTO> userOrgPrivDTOList = userOrgPrivConvertor.userOrgPrivListToUserOrgPrivDto(userOrgPrivList);
        return userOrgPrivDTOList;
    }


    public int insertByBatch(List<AuthorizationBO> authorizationBOList){
        List<UserOrgPrivDO> userOrgPrivDOList = userOrgPrivConvertor.authorizationBOListToUserOrgPrivDoList(authorizationBOList);
        return userOrgPrivMapper.insertByBatch(userOrgPrivDOList);

    }


    public int deleteByUserIdAndOrgId(Long userId, Long orgId) {
        return userOrgPrivMapper.deleteByUserIdAndOrgId(userId, orgId);
    }

    public int deleteByUserIdAndOrgIds(Long userId, List<Long> orgIds) {
        return userOrgPrivMapper.deleteByUserIdAndOrgIds(userId, orgIds);
    }
}
