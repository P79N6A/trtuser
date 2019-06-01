package com.ztesoft.zsmart.nros.sbc.user.dao.mapper;

import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.UserOrgPriv;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.UserOrgPrivDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author bin.yu
 * @create 2019-05-07 11:13
 **/
public interface UserOrgPrivMapper {

    List<UserOrgPriv> selectByUserId(@Param("userId") Long userId);

    int insertByBatch(@Param("userPrivs") List<UserOrgPrivDO> userOrgPrivDOS);

    int deleteByUserIdAndOrgId(@Param("userId") Long userId, @Param("orgId") Long orgId);

    int deleteByUserIdAndOrgIds(@Param("userId") Long userId, @Param("orgIds") List<Long> orgIds);
}
