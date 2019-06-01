package com.ztesoft.zsmart.nros.sbc.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztesoft.zsmart.nros.base.util.ConvertUtil;
import com.ztesoft.zsmart.nros.sbc.user.client.api.UserService;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.StaffDetail;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.StaffDO;
import com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator.UserDO;
import com.ztesoft.zsmart.nros.sbc.user.domain.user.UserDomain;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.StaffDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.UserDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.StaffQuery;
import jodd.bean.BeanCopy;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        UserDO userDo = userDomain.findById(id);
        return ConvertUtil.beanCopy(userDo, UserDTO.class);
    }

    @Override
    public StaffDTO findStaffDetailById(Long id) {
        StaffDetail staffDetail = userDomain.queryStaffDetail(id);
        return ConvertUtil.beanCopy(staffDetail, StaffDTO.class);
    }

    @Override
    public PageInfo listStaffInfo(StaffQuery staffQuery) {
        Page page = PageHelper.startPage(staffQuery.getPageIndex(), staffQuery.getPageSize());
        List<StaffDO> staffDOList = userDomain.queryStaffDOList(staffQuery);
        List<StaffDTO> staffDTOList = do2DTO(staffDOList);
        PageInfo pageInfo = page.toPageInfo();
        pageInfo.setList(staffDTOList);
        return pageInfo;
    }

    @Override
    public PageInfo listStaffDetailInfo(StaffQuery staffQuery) {
        Page page = PageHelper.startPage(staffQuery.getPageIndex(), staffQuery.getPageSize());
        List<StaffDetail> staffDetails = userDomain.queryStaffDetailList(staffQuery);
        List<StaffDTO> staffDTOList = do2DetailDTO(staffDetails);
        PageInfo pageInfo = page.toPageInfo();
        pageInfo.setList(staffDTOList);
        return pageInfo;

    }



    private List<StaffDTO> do2DetailDTO(List<StaffDetail> staffDetails) {
        if (CollectionUtils.isEmpty(staffDetails)) {
            return null;
        }
        List<StaffDTO> result = new ArrayList<>();
        for (StaffDetail staffDetail : staffDetails) {
            StaffDTO staffDTO = new StaffDTO();
            BeanCopy.beans(staffDetail, staffDTO).copy();
            result.add(staffDTO);
        }
        return result;
    }


    private List<StaffDTO> do2DTO(List<StaffDO> staffDOList) {
        if (CollectionUtils.isEmpty(staffDOList)) {
            return null;
        }
        List<StaffDTO> result = new ArrayList<>();
        for (StaffDO staffDO : staffDOList) {
            StaffDTO staffDTO = new StaffDTO();
            BeanCopy.beans(staffDO, staffDTO).copy();
            result.add(staffDTO);
        }

        return result;
    }

}
