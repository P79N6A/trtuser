package com.ztesoft.zsmart.nros.sbc.user.server.domain.user;

import com.github.pagehelper.PageInfo;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.StaffDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.UserDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.StaffQuery;
import com.ztesoft.zsmart.nros.sbc.user.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author bin.yu
 * @create 2019-04-23 10:29
 **/
@Component
public class UserDomain {

    @Autowired
    private UserRepository userRepository;


    public UserDTO findById(Long id) {
        return userRepository.findUserDOById(id);
    }

    public PageInfo<StaffDTO> queryStaffDOList(StaffQuery staffQuery) {
        return userRepository.queryStaffDOListByPage(staffQuery);
    }

    public PageInfo<StaffDTO> queryStaffDetailList(StaffQuery staffQuery) {
        return userRepository.queryStaffDetailListByPage(staffQuery);
    }

    public StaffDTO queryStaffDetail(Long id) {
        return userRepository.queryStaffDetailById(id);
    }

}
