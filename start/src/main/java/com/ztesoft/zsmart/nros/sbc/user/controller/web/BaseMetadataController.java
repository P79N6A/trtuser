package com.ztesoft.zsmart.nros.sbc.user.controller.web;

import com.ztesoft.zsmart.nros.base.exception.BusiException;
import com.ztesoft.zsmart.nros.base.model.ResponseMsg;
import com.ztesoft.zsmart.nros.sbc.user.client.api.EnumConfigService;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.EnumConfigDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-04-17
 * Time: 13:27
 */
@RestController
@RequestMapping("/metadata")
@Api(value = "基础数据配置列表", tags = {"基础数据配置列表"},description = "基础数据配置列表" )
public class BaseMetadataController {

    @Autowired
    private EnumConfigService enumConfigService;

    @GetMapping("/all_type")
    @ApiOperation(value="查询基础列表种类")
    public ResponseMsg listAllMetadataKind() throws BusiException {
        List<EnumConfigDTO> enumConfigDTOS = enumConfigService.listAllEnumConfigType();
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setSuccess(true);
        return responseMsg.success("success", enumConfigDTOS);
    }

    @GetMapping("/channel_type")
    @ApiOperation(value="查询渠道种类")
    public ResponseMsg list() throws BusiException {
        List<EnumConfigDTO> enumConfigDTOS = enumConfigService.listChannelEnumConfig();
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setSuccess(true);
        return responseMsg.success("success", enumConfigDTOS);
    }
}
