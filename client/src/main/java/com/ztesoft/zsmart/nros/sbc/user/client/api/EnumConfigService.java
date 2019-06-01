package com.ztesoft.zsmart.nros.sbc.user.client.api;

import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.EnumConfigDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.EnumConfigQuery;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-04-17
 * Time: 11:08
 */
public interface EnumConfigService {

    List<EnumConfigDTO> listAllEnumConfigType();

    List<EnumConfigDTO> listEnumConfigByParams(EnumConfigQuery enumConfigQuery);

    List<EnumConfigDTO> listChannelEnumConfig();


}
