package com.ztesoft.zsmart.nros.sbc.user.server.domain.user;

import com.ztesoft.zsmart.nros.sbc.user.client.model.query.StaffQuery;
import com.ztesoft.zsmart.nros.sbc.user.server.common.enums.DataStateEnum;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.StaffDetail;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.StaffDO;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.UserDO;
import com.ztesoft.zsmart.nros.sbc.user.server.repository.UserRepository;
import jodd.bean.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author bin.yu
 * @create 2019-04-23 10:29
 **/
@Component
public class UserDomain {

    @Autowired
    private UserRepository userRepository;


    public UserDO findById(Long id) {
        //return userDoMapper.selectByPrimaryKey(id);
        return null;
    }

    public List<StaffDO> queryStaffDOList(StaffQuery staffQuery) {
        StaffDetail staffDetail = query2StaffDetail(staffQuery);
        //return staffMapper.selectStaffList(staffDetail);
        return null;
    }

    public List<StaffDetail> queryStaffDetailList(StaffQuery staffQuery) {
        StaffDO staffDO = query2StaffDO(staffQuery);
        //List<StaffDetail> staffDetails = staffMapper.selectStaffDetailList(staffDO);
        return null;
    }

    public StaffDetail queryStaffDetail(Long id) {
        //return staffMapper.selectStaffDetail(id);
        return null;
    }


    private StaffDO query2StaffDO(StaffQuery staffQuery) {
        StaffDO staffDO = new StaffDO();
        //如果query的state值是空的,表示查有效的
        if(staffQuery == null ){
            staffQuery.setState(DataStateEnum.A.getCode());
        } else  {
            staffQuery.setState(DataStateEnum.getDataState(staffQuery.getState()));
        }
        BeanCopy.beans(staffQuery, staffDO).copy();
        return staffDO;
    }


    private StaffDetail query2StaffDetail(StaffQuery staffQuery) {
        StaffDetail staffDetail = new StaffDetail();
        //如果query的state值是空的,表示查有效的
        if(staffQuery == null ){
            staffQuery.setState(DataStateEnum.A.getCode());
        } else  {
            staffQuery.setState(DataStateEnum.getDataState(staffQuery.getState()));
        }
        BeanCopy.beans(staffQuery, staffDetail).copy();
        return staffDetail;
    }




}
