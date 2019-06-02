package com.ztesoft.zsmart.nros.sbc.user.controller.web;

import com.github.pagehelper.PageInfo;
import com.ztesoft.zsmart.nros.base.exception.BusiException;
import com.ztesoft.zsmart.nros.base.model.ResponseMsg;
import com.ztesoft.zsmart.nros.sbc.user.client.api.UserOrgPrivService;
import com.ztesoft.zsmart.nros.sbc.user.client.api.UserService;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.StaffDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.UserDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.UserOrgPrivDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.StaffQuery;
import com.ztesoft.zsmart.nros.sbc.user.client.model.param.UserOrgParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户controller
 *
 * @author wang.yaoding
 * @create 2019-4-12 16:58:58
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户管理", tags = {"用户管理"})
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserOrgPrivService userOrgPrivService;
    

    @GetMapping("/{id}")
    @ApiOperation("查询用户详情")
    public ResponseMsg<?> queryUser(@PathVariable Long id) {
        UserDTO userDTO = userService.findById(id);
        return ResponseMsg.build(userDTO).success();
    }


    @GetMapping("/staff/{id}")
    @ApiOperation("查询用户详情")
    public ResponseMsg<?> queryStaffDetail(@PathVariable Long id) {
        StaffDTO staffDTO = userService.findStaffDetailById(id);
        return ResponseMsg.build(staffDTO).success();
    }

    @GetMapping
    @ApiOperation(value = "查询用户列表", notes = "查询用户列表", response = StaffDTO.class)
    public ResponseMsg listStaffInfo(StaffQuery staffQuery) throws BusiException {
        PageInfo pageInfo = userService.listStaffInfo(staffQuery);
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setSuccess(true);
        return responseMsg.success("success", pageInfo);
    }

    @GetMapping("priv/userId/{userId}")
    @ApiOperation(value = "查询用户机构权限list", notes = "查询用户机构权限list")
    public ResponseMsg selectOrgPrivByUserId(@PathVariable Long userId) {
        List<UserOrgPrivDTO> userOrgPrivDTOS = userOrgPrivService.selectByUserId(userId);
        return ResponseMsg.build(userOrgPrivDTOS).success();
    }

    @PostMapping("priv/batch")
    @ApiOperation(value = "批量新增用户机构权限", notes = "批量新增用户机构权限")
    public ResponseMsg batchInsertOrgPriv(@RequestBody UserOrgParam param) {
        userOrgPrivService.insertByBatch(param.getUserIds(), param.getOrgIds(), null);
        return ResponseMsg.build(null).success();
    }

    @PostMapping("priv/delete")
    @ApiOperation(value = "删除用户机构权限", notes = "删除用户机构权限")
    public ResponseMsg deleteByUserIdAndOrgId(Long userId,Long orgId) {
        userOrgPrivService.deleteByUserIdAndOrgId(userId, orgId);
        return ResponseMsg.build(null).success();
    }

    @PostMapping("priv/batch/delete")
    @ApiOperation(value = "批量删除用户机构权限", notes = "批量删除用户机构权限")
    public ResponseMsg deleteByUserIdAndOrgId(Long userId, @RequestBody List<Long> orgIds) {
        userOrgPrivService.deleteByUserIdAndOrgIds(userId, orgIds);
        return ResponseMsg.build(null).success();
    }
}
