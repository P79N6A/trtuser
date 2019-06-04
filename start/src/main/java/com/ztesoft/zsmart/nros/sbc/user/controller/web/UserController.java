package com.ztesoft.zsmart.nros.sbc.user.controller.web;

import com.github.pagehelper.PageInfo;
import com.ztesoft.zsmart.nros.base.exception.BusiException;
import com.ztesoft.zsmart.nros.base.model.ResponseMsg;
import com.ztesoft.zsmart.nros.base.util.CommonFunctions;
import com.ztesoft.zsmart.nros.sbc.user.client.api.UserOrgPrivService;
import com.ztesoft.zsmart.nros.sbc.user.client.api.UserService;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.StaffDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.UserDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.UserOrgPrivDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.StaffQuery;
import com.ztesoft.zsmart.nros.sbc.user.client.model.param.UserOrgParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户controller
 *
 * @author wang.yaoding
 * @create 2019-4-12 16:58:58
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api(value = "用户管理", tags = {"用户管理"}, description = "用户服务")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserOrgPrivService userOrgPrivService;
    

    @GetMapping("/{id}")
    @ApiOperation(value = "查询用户详情", notes = "查询用户详情")
    public ResponseMsg<?> queryUser(@PathVariable(name = "id")
    @ApiParam(name = "id", value = "用户编号", required = true) Long id) throws Exception{
        return CommonFunctions.runSupplier(()->userService.findById(id),"查询用户详情失败");
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
    public ResponseMsg selectOrgPrivByUserId(@PathVariable(name = "user_id")
    @ApiParam(name = "user_id", value = "用户主键", required = true) Long userId) {
        return CommonFunctions.runSupplierByList(()->userOrgPrivService.selectByUserId(userId),"查询用户机构权限列表失败");
    }

    @PostMapping("priv/batch")
    @ApiOperation(value = "批量新增用户机构权限", notes = "批量新增用户机构权限")
    public ResponseMsg batchInsertOrgPriv(@RequestBody
    @ApiParam(name = "userOrgParam", value = "json格式") UserOrgParam userOrgParam) {
        //TODO create字段没有
        return CommonFunctions.runSupplier(()->userOrgPrivService.insertByBatch(userOrgParam.getUserIds(), userOrgParam.getOrgIds(), null),"");
    }

    @PostMapping("priv/delete")
    @ApiOperation(value = "删除用户机构权限", notes = "删除用户机构权限")
    public ResponseMsg deleteByUserIdAndOrgId(@PathVariable(name = "user_id")
    @ApiParam(name="userId", value = "用户主键") Long userId,
    @PathVariable(name="org_id") @ApiParam(name="orgId",value="要删除的机构主键") Long orgId) {
        return CommonFunctions.runSupplier(()->userOrgPrivService.deleteByUserIdAndOrgId(userId, orgId),"删除用户机构权限");
    }

    @PostMapping("priv/batch/delete")
    @ApiOperation(value = "批量删除用户机构权限", notes = "批量删除用户机构权限")
    public ResponseMsg deleteByUserIdAndOrgId(@PathVariable(name="user_id") @ApiParam(name = "userId", value = "用户主键") Long userId,
    @RequestBody @ApiParam(name = "orgIds", value = "要删除的机构id") List<Long> orgIds) {
        userOrgPrivService.deleteByUserIdAndOrgIds(userId, orgIds);
        return ResponseMsg.build(null).success();
    }
}
