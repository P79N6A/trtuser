package com.ztesoft.zsmart.nros.sbc.user.client.api;

import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.UserOrgPrivDTO;

import java.util.List;

/**
 * @author bin.yu
 * @create 2019-05-07 14:07
 **/
public interface UserOrgPrivService {

    List<UserOrgPrivDTO> selectByUserId(Long userId);

    int insertByBatch(List<Long> userIds, List<Long> orgIds, String creator);

    int deleteByUserIdAndOrgId(Long userId, Long orgId);

    int deleteByUserIdAndOrgIds(Long userId, List<Long> orgIds);
}
