package com.ztesoft.zsmart.nros.sbc.user.server.service.impl;

import com.github.pagehelper.PageInfo;
import com.ztesoft.zsmart.nros.sbc.user.client.api.UserService;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.StaffDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.UserDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.StaffQuery;
import com.ztesoft.zsmart.nros.sbc.user.server.domain.user.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bin.yu
 * @create 2019-04-23 10:33
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDomain userDomain;

    @Override
    public UserDTO findById(Long id) {
        return userDomain.findById(id);
    }

    @Override
    public StaffDTO findStaffDetailById(Long id) {
        return userDomain.queryStaffDetail(id);
    }

    @Override
    public PageInfo listStaffInfo(StaffQuery staffQuery) {
        return userDomain.queryStaffDOList(staffQuery);
    }

    @Override
    public PageInfo listStaffDetailInfo(StaffQuery staffQuery) {
        return userDomain.queryStaffDetailList(staffQuery);
    }


}
