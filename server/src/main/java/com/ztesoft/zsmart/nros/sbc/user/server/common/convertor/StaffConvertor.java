package com.ztesoft.zsmart.nros.sbc.user.server.common.convertor;

import com.ztesoft.zsmart.nros.base.convertor.IConvertor;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.StaffDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.param.StaffParam;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.StaffQuery;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.StaffDetail;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.StaffDO;
import com.ztesoft.zsmart.nros.sbc.user.server.domain.user.model.UserBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-06-03
 * Time: 16:51
 */
@Mapper(componentModel = "spring")
public interface StaffConvertor {

    @Mappings({
            @Mapping(target = "orgName", ignore = true),
            @Mapping(target = "orgId", ignore = true),
            @Mapping(target = "jobName", ignore = true),
            @Mapping(target = "jobId", ignore = true),

    })
    StaffDTO staffDOToStaffDTO(StaffDO staffDO);

    StaffDO staffDtoToStaffDo(StaffDTO staffDTO);

    List<StaffDTO> staffDOsToStaffDTOs(List<StaffDO> staffDOs);

    List<StaffDO> staffDtoListToStaffDoList(List<StaffDTO> staffDTOList);

    StaffDetail staffQueryToStaffDetail(StaffQuery staffQuery);

    StaffDO staffQueryToStaffDo(StaffQuery staffQuery);

    StaffDTO staffDetailToStaffDto(StaffDetail staffDetail);

    List<StaffDTO> staffDetailListToStaffDtoList(List<StaffDetail> staffDetailList);

}
