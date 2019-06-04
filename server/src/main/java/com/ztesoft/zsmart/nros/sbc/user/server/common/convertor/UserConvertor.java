package com.ztesoft.zsmart.nros.sbc.user.server.common.convertor;

import com.ztesoft.zsmart.nros.base.convertor.IConvertor;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.UserDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.param.UserParam;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.UserQuery;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.UserDO;
import com.ztesoft.zsmart.nros.sbc.user.server.domain.user.model.UserBO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * BrandConvertor
 *
 * @author zhou.yanli
 * @create 2019-06-01 1:32
 */
@Mapper(componentModel = "spring")
public interface UserConvertor extends IConvertor<UserParam, UserQuery, UserDTO, UserBO, UserDO> {

    UserBO userDtoToUserBO(UserDTO userDTO);

    UserDTO userBOToUserDTO(UserBO userBO);

    List<UserBO> dtoListToBO(List<UserDTO> brandList);

    List<UserDTO> boListToDTO(List<UserBO> brandEList);

}
