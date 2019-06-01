package com.ztesoft.zsmart.nros.sbc.user.client.api;

import com.github.pagehelper.PageInfo;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.StaffDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.UserDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.StaffQuery;

/**
 * @author bin.yu
 * @create 2019-04-23 10:33
 **/
public interface UserService {

    UserDTO findById(Long id);

    PageInfo listStaffInfo(StaffQuery staffQuery);

    PageInfo listStaffDetailInfo(StaffQuery staffQuery);

    StaffDTO findStaffDetailById(Long id);
}
