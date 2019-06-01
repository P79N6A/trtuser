package com.ztesoft.zsmart.nros.sbc.user.domain.user;

import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.StaffMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.mapper.generator.UserDOMapper;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.StaffDetail;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.StaffDO;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.UserDO;
import com.ztesoft.zsmart.nros.sbc.user.common.enums.DataStateEnum;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.StaffQuery;
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
    private UserDOMapper userDoMapper;

    @Autowired
    private StaffMapper staffMapper;

    public UserDO findById(Long id) {
        return userDoMapper.selectByPrimaryKey(id);
    }

    public List<StaffDO> queryStaffDOList(StaffQuery staffQuery) {
        StaffDetail staffDetail = query2StaffDetail(staffQuery);
        return staffMapper.selectStaffList(staffDetail);
    }

    public List<StaffDetail> queryStaffDetailList(StaffQuery staffQuery) {
        StaffDO staffDO = query2StaffDO(staffQuery);
        List<StaffDetail> staffDetails = staffMapper.selectStaffDetailList(staffDO);
        return staffDetails;
    }

    public StaffDetail queryStaffDetail(Long id) {
        return staffMapper.selectStaffDetail(id);
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
