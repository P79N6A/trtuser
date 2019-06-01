package com.ztesoft.zsmart.nros.sbc.nrosuser.controller.web;

import com.github.pagehelper.PageInfo;
import com.ztesoft.zsmart.nros.base.exception.BusiException;
import com.ztesoft.zsmart.nros.base.model.ResponseMsg;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.ChannelQuery;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.StoreQuery;
import com.ztesoft.zsmart.nros.sbc.user.client.model.query.WarehouseQuery;
import com.ztesoft.zsmart.nros.sbc.user.client.api.ChannelService;
import com.ztesoft.zsmart.nros.sbc.user.client.api.MerchantService;
import com.ztesoft.zsmart.nros.sbc.user.client.api.OrgService;
import com.ztesoft.zsmart.nros.sbc.user.client.api.StoreService;
import com.ztesoft.zsmart.nros.sbc.user.client.api.SubsidiaryService;
import com.ztesoft.zsmart.nros.sbc.user.client.api.WarehouseService;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.ChannelDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.MerchantDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.OrgDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.OrgDetailDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.StaffOrgDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.StoreDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.SubsidiaryDTO;
import com.ztesoft.zsmart.nros.sbc.user.client.model.dto.WarehouseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 组织架构controller
 *
 * @author bin.yu
 * @create 2019-04-22 14:24
 **/
@RestController
@RequestMapping("/org")
@Api(value = "组织机构信息管理", tags = {"组织机构信息管理"},description = "组织机构信息管理" )
public class OrgController {

    @Autowired
    private OrgService orgService;

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private SubsidiaryService subsidiaryService;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private WarehouseService warehouseService;

    @ApiOperation(value = "获取员工所属的顶级机构", notes = "获取员工所属的顶级机构")
    @RequestMapping(value = "/self/root", method = RequestMethod.GET)
    public ResponseMsg queryRootOrgListByStaffId(Long staffId) {
        if (staffId == null) {
            // TODO: 2019/4/22 staffId从session取
        }
        List<OrgDTO> orgDTOS = orgService.queryOwnedOrgListByStaffId(staffId);
        return ResponseMsg.build(orgDTOS).success();
    }


    @ApiOperation(value = "获取员工所属的机构列表", notes = "获取员工所属的机构列表")
    @RequestMapping(value = "self/org", method = RequestMethod.GET)
    public ResponseMsg findOrgByStaffId(Long staffId, String orgType) {
        List<StaffOrgDTO> staffOrgDTOS = orgService.selectStaffOrg(staffId, orgType);
        return ResponseMsg.build(staffOrgDTOS).success();
    }

    @ApiOperation(value = "查询直属下级节点",notes = "查询直属下级节点")
    @RequestMapping(value = "/parent/{orgId}", method = RequestMethod.GET)
    public ResponseMsg queryOrgListByParentId(@PathVariable Long orgId) {
        List<OrgDTO> orgDTOS = orgService.queryOrgListByParentId(orgId);
        return ResponseMsg.build(orgDTOS).success();
    }


    @ApiOperation(value = "增加组织节点",notes = "增加组织节点")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseMsg addOrg(@RequestBody OrgDetailDTO org) {
        orgService.addOrg(org);
        return ResponseMsg.build(null).success();
    }

    @ApiOperation(value = "修改组织节点",notes = "修改组织节点")
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseMsg modOrg(@RequestBody OrgDetailDTO org){
        orgService.modOrg(org);
        return ResponseMsg.build(null).success();
    }

    @ApiOperation(value = "删除组织节点",notes = "删除组织节点")
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseMsg delOrg(Long orgId) {
        orgService.delOrg(orgId);
        return ResponseMsg.build(null).success();
    }

    @ApiOperation(value = "查询组织节点详情",notes = "查询组织节点详情")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseMsg findOrgByOrgId(Long orgId){
        OrgDetailDTO orgByOrgId = orgService.findOrgByOrgId(orgId);
        return ResponseMsg.build(orgByOrgId).success();
    }


    // ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** *****
    // 子公司部分

    @ApiOperation(value = "通过orgId查询子公司详情",notes = "通过orgId查询子公司详情")
    @RequestMapping(value = "subsidiary/" ,method = RequestMethod.GET)
    public ResponseMsg findSubsidiaryByOrgId(Long orgId){
        SubsidiaryDTO subsidiaryDTO = subsidiaryService.findSubsidiaryByOrgId(orgId);
        return ResponseMsg.build(subsidiaryDTO).success();
    }

    @ApiOperation(value = "通过id查询子公司详情",notes = "通过id查询子公司详情")
    @RequestMapping(value = "subsidiary/{id}" ,method = RequestMethod.GET)
    public ResponseMsg findSubsidiaryById(@PathVariable Long id){
        SubsidiaryDTO subsidiaryDTO = subsidiaryService.findById(id);
        return ResponseMsg.build(subsidiaryDTO).success();
    }


    // ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** *****
    // 商家部分
    @ApiOperation(value = "通过orgId查询商家详情",notes = "通过orgId查询商家详情")
    @RequestMapping(value = "merchant/" ,method = RequestMethod.GET)
    public ResponseMsg findMerchantByOrgId(Long orgId){
        MerchantDTO merchantDTO = merchantService.findMerchantByOrgId(orgId);
        return ResponseMsg.build(merchantDTO).success();
    }

    @ApiOperation(value = "通过id查询商家详情",notes = "通过id查询商家详情")
    @RequestMapping(value = "merchant/{id}" ,method = RequestMethod.GET)
    public ResponseMsg findMerchantById(@PathVariable Long id){
        MerchantDTO merchantDTO = merchantService.findById(id);
        return ResponseMsg.build(merchantDTO).success();
    }

    // ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** *****
    // 渠道部分

    @RequestMapping(value = "/channel/page", method = RequestMethod.POST)
    @ApiOperation(value = "获取渠道列表分页", notes = "获取渠道列表分页", response = ChannelDTO.class)
    public ResponseMsg listChannel(@RequestBody ChannelQuery channelQuery) throws BusiException {
        PageInfo pageInfo = channelService.listChannels(channelQuery);
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setSuccess(true);
        return responseMsg.success("success", pageInfo);
    }

    @RequestMapping(value = "/channel", method = RequestMethod.GET)
    @ApiOperation(value = "条件渠道列表不分页")
    public ResponseMsg listChannelByParams(ChannelQuery channelQuery) throws BusiException {
        List<ChannelDTO> listAllChannels = channelService.listChannelsByParams(channelQuery);
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setSuccess(true);
        return responseMsg.success("success", listAllChannels);
    }

    @RequestMapping(value = "/channel/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "根据ID查询渠道详情", notes = "根据ID查询渠道详情")
    public ResponseMsg findChannelById(@PathVariable("id") Long id) throws BusiException {
        ChannelDTO channelDTO=channelService.findChannelById(id);
        return ResponseMsg.build(channelDTO).success();
    }

    @RequestMapping(value = "/channel/orgId/{orgId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据机构ID查询渠道详情", notes = "根据机构ID查询渠道详情")
    public ResponseMsg findChannelByOrgId(@PathVariable("orgId") Long orgId) throws BusiException {
        ChannelDTO channelDTO = channelService.findChannelByOrgId(orgId);
        return ResponseMsg.build(channelDTO).success();
    }


    // ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** *****
    // 门店部分

    @RequestMapping(value = "/store", method = RequestMethod.GET)
    @ApiOperation(value = "查询门店列表", notes = "查询门店列表", response = StoreDTO.class)
    public ResponseMsg queryStoreByParams(StoreQuery storeQuery) throws BusiException {
        PageInfo pageInfo = storeService.listStoreByParams(storeQuery);
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setSuccess(true);
        return responseMsg.success("success", pageInfo);
    }

    @RequestMapping(value ="/store/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询门店详情", notes = "查询门店详情", response = StoreDTO.class)
    public ResponseMsg queryStoreDetailByParams(@PathVariable("id") Long id) throws BusiException {
        StoreDTO storeDTO = storeService.queryStoreDetailByParams(id);
        return ResponseMsg.build(storeDTO).success();
    }

    @RequestMapping(value = "/store/testPushStoreMqServer/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "测试门店推送", notes = "测试门店推送")
    public ResponseMsg testPushStoreMqServer(@PathVariable("id") Long id) {
        storeService.pushStoreMqServer(id);
        return ResponseMsg.build(null).setSuccess(true);
    }


    // ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** *****
    // 仓库部分


    @RequestMapping(value = "/warehouse/page", method = RequestMethod.GET)
    @ApiOperation(value = "获取仓库列表(分页)", notes = "获取仓库列表(分页)", response = WarehouseDTO.class)
    public ResponseMsg pageWarehouse(@RequestBody WarehouseQuery warehouseQuery) throws BusiException {
        PageInfo pageInfo = warehouseService.pageWarehouses(warehouseQuery);
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setSuccess(true);
        return responseMsg.success("success", pageInfo);
    }

    @RequestMapping(value = "/warehouse/list", method = RequestMethod.GET)
    @ApiOperation(value = "获取仓库列表不分页", notes = "获取仓库列表不分页", response = WarehouseDTO.class)
    public ResponseMsg listWarehousesByParams(WarehouseQuery warehouseQuery) throws BusiException {
        List<WarehouseDTO> warehouseDTOS = warehouseService.listWarehousesByParams(warehouseQuery);
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setSuccess(true);
        return responseMsg.success("success", warehouseDTOS);
    }

    @RequestMapping(value = "/warehouse/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "根据id获取仓库详情", notes = "根据id获取仓库详情", response = WarehouseDTO.class)
    public ResponseMsg selectByPrimaryKey(@PathVariable("id") Long id) {
        WarehouseDTO warehouseDTO = warehouseService.selectByPrimaryKey(id);
        return ResponseMsg.build(warehouseDTO).success();
    }
}
