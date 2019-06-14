package com.ztesoft.zsmart.nros.sbc.user.controller.web;

import com.ztesoft.zsmart.nros.base.annotation.CenterController;
import com.ztesoft.zsmart.nros.base.exception.BusiException;
import com.ztesoft.zsmart.nros.base.model.ResponseMsg;
import com.ztesoft.zsmart.nros.base.util.CommonFunctions;
import com.ztesoft.zsmart.nros.sbc.user.client.api.UserOrgPrivService;
import com.ztesoft.zsmart.nros.sbc.user.client.api.UserService;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.StaffDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.UserDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.UserOrgPrivDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.param.UserOrgParam;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.StaffQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 用户controller
 *
 * @author wang.yaoding
 * @create 2019-4-12 16:58:58
 */
@Slf4j
@CenterController
@RequestMapping("/user")
@Api(value = "用户管理", tags = {"用户管理"}, description = "用户服务")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserOrgPrivService userOrgPrivService;
    

    @GetMapping("/{id}")
    @ApiOperation(value = "查询用户详情", notes = "查询用户详情", response = UserDTO.class)
    public ResponseMsg<?> queryUser(@PathVariable(name = "id")
    @ApiParam(name = "id", value = "用户编号", required = true) Long id) throws Exception{
        return CommonFunctions.runSupplier(()->userService.findById(id),"查询用户详情失败");
    }


    @GetMapping("/staff/{id}")
    @ApiOperation(value = "查询员工详情", notes = "查询员工详情", response = StaffDTO.class)
    public ResponseMsg<?> queryStaffDetail(@PathVariable Long id) {
        return CommonFunctions.runSupplier(()->userService.findStaffDetailById(id),"查询员工详情失败");
    }

    @PostMapping
    @ApiOperation(value = "查询用户列表", notes = "查询用户列表", response = StaffDTO.class)
    public ResponseMsg listStaffInfo(@RequestBody StaffQuery staffQuery) throws BusiException {
        return CommonFunctions.runSupplierByPage(()->userService.listStaffInfo(staffQuery),"查询用户列表失败");
    }
    @PostMapping("/staff")
    @ApiOperation(value = "查询员工列表", notes = "查询员工列表", response = StaffDTO.class)
    public ResponseMsg listStaffDetailInfo(@RequestBody StaffQuery staffQuery) throws BusiException {
        return CommonFunctions.runSupplierByPage(()->userService.listStaffDetailInfo(staffQuery),"查询员工列表失败");
    }




    @GetMapping("priv/userId/{userId}")
    @ApiOperation(value = "查询用户机构权限list", notes = "查询用户机构权限list", response = UserOrgPrivDTO.class)
    public ResponseMsg<?> selectOrgPrivByUserId(@PathVariable(name = "user_id")
    @ApiParam(name = "userId", value = "用户主键", required = true) Long userId) {
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
