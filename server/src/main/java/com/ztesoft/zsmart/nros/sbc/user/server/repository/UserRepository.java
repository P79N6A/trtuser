package com.ztesoft.zsmart.nros.sbc.user.server.repository;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztesoft.zsmart.nros.core.repository.BaseRepository;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.StaffDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.UserDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.StaffQuery;
import com.ztesoft.zsmart.nros.sbc.user.server.common.convertor.StaffConvertor;
import com.ztesoft.zsmart.nros.sbc.user.server.common.convertor.UserConvertor;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.StaffDetail;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.StaffDO;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.UserDO;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.mapper.StaffMapper;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.mapper.generator.UserDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-06-03
 * Time: 15:40
 */
@Repository
public class UserRepository implements BaseRepository {

    @Autowired
    private UserDOMapper userDoMapper;

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private UserConvertor userConvertor;

    @Autowired
    private StaffConvertor staffConvertor;



    public UserDTO findUserDOById(Long id) {
        UserDO userDO = userDoMapper.selectByPrimaryKey(id);
        UserDTO userDTO = userConvertor.doToDTO(userDO);
        return userDTO;
    }

    public PageInfo<StaffDTO> queryStaffDOListByPage(StaffQuery staffQuery) {
        //1. 声明分页对象
        Page page = PageHelper.startPage(staffQuery.getPageIndex(), staffQuery.getPageSize());
        //2. 转换入参为数据库实体对象
        StaffDO staffDO = staffConvertor.staffQueryToStaffDo(staffQuery);
        //3. 查询数据库
        List<StaffDO> staffDOList=staffMapper.selectStaffList(staffDO);
        //4. 把数据库实体对象转换为数据传输对象
        List<StaffDTO> staffDTOList=staffConvertor.staffDOsToStaffDTOs(staffDOList);

        //5. 构造分页返回对象
        PageInfo pageInfo = page.toPageInfo();
        pageInfo.setList(staffDTOList);
        return (PageInfo<StaffDTO>)pageInfo;
    }


    public PageInfo<StaffDTO> queryStaffDetailListByPage(StaffQuery staffQuery) {
        //1. 声明分页对象
        Page page = PageHelper.startPage(staffQuery.getPageIndex(), staffQuery.getPageSize());
        //2. 转换入参为数据实体对象
        StaffDetail staffDetail = staffConvertor.staffQueryToStaffDetail(staffQuery);
        //3. 查询数据库
        List<StaffDetail> staffDetailList = staffMapper.selectStaffDetailList(staffDetail);
        //4. 把数据库实体对象转换为数据传输对象
        List<StaffDTO> staffDTOList = staffConvertor.staffDetailListToStaffDtoList(staffDetailList);
        //5. 构造分页返回对象
        PageInfo pageInfo = page.toPageInfo();
        pageInfo.setList(staffDTOList);
        return (PageInfo<StaffDTO>)pageInfo;
    }

    public StaffDTO queryStaffDetailById(Long id) {
        StaffDetail staffDetail = staffMapper.selectStaffDetail(id);
        return staffConvertor.staffDetailToStaffDto(staffDetail);
    }

}
