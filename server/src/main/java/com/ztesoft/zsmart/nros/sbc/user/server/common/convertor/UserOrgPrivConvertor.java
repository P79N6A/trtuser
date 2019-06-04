package com.ztesoft.zsmart.nros.sbc.user.server.common.convertor;

import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.UserOrgPrivDTO;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.UserOrgPriv;
import com.ztesoft.zsmart.nros.sbc.user.server.dao.dataobject.generator.UserOrgPrivDO;
import com.ztesoft.zsmart.nros.sbc.user.server.domain.authorization.model.AuthorizationBO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-06-04
 * Time: 9:13
 */
@Mapper(componentModel = "spring")
public interface UserOrgPrivConvertor {

    UserOrgPrivDTO userOrgPrivToUserOrgPrivDto(UserOrgPriv userOrgPriv);

    List<UserOrgPrivDTO> userOrgPrivListToUserOrgPrivDto(List<UserOrgPriv> userOrgPrivList);

    UserOrgPrivDO authorizationBOToUserOrgPrivDO(AuthorizationBO authorizationBO);

    List<UserOrgPrivDO> authorizationBOListToUserOrgPrivDoList(List<AuthorizationBO> authorizationBOList);

}
