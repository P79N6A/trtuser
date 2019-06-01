package com.ztesoft.zsmart.nros.sbc.user.dao.dataobject.generator;

import java.io.Serializable;
import java.util.Date;

/**
 * MerchantDO
 * @author 浩鲸云计算科技股份有限公司
 * @date 2019-04-25
 */
public class MerchantDO implements Serializable {
    /**
     * MerchantDO-主键
     */
    private Long id;

    /**
     * MerchantDO-创建时间
     */
    private Date gmtCreate;

    /**
     * MerchantDO-修改时间
     */
    private Date gmtModified;

    /**
     * MerchantDO-创建者
     */
    private String creator;

    /**
     * MerchantDO-修改者
     */
    private String modifier;

    /**
     * MerchantDO-乐观锁版本号
     */
    private Long version;

    /**
     * MerchantDO-是否启用(0,1)
     */
    private String active;

    /**
     * MerchantDO-机构逻辑主键(同盒马merchant_id)
     */
    private Long orgId;

    /**
     * MerchantDO-名称
     */
    private String name;

    /**
     * MerchantDO-负责人
     */
    private String principal;

    /**
     * MerchantDO-联系人电话
     */
    private String phone;

    /**
     * MerchantDO-传真
     */
    private String fax;

    /**
     * MerchantDO-支付宝账号
     */
    private String alipayAccount;

    /**
     * MerchantDO-分账费率
     */
    private Long ledgerAccountRate;

    /**
     * MerchantDO-备注
     */
    private String remark;

    /**
     * MerchantDO-编码
     */
    private String code;

    /**
     * MerchantDO-省
     */
    private String province;

    /**
     * MerchantDO-市
     */
    private String city;

    /**
     * MerchantDO-区
     */
    private String area;

    /**
     * MerchantDO-详细地址
     */
    private String address;

    /**
     * MerchantDO-扩展字段
     */
    private String extension;

    /**
     * MerchantDO-上级机构id
     */
    private Long parentOrgId;

    /**
     * MerchantDO-电子身份标签
     */
    private String appKey;

    /**
     * MerchantDO-商家类型,1.正式2.测试
     */
    private String flag;

    /**
     * MerchantDO-合同编码
     */
    private String contractCode;

    /**
     * MerchantDO-合同创建时间
     */
    private Date contractCreateTime;

    /**
     * MerchantDO-合同生效时间
     */
    private Date contractStartTime;

    /**
     * MerchantDO-合同终止时间
     */
    private Date contractEndTime;

    /**
     * MerchantDO-邮箱地址
     */
    private String email;

    /**
     * MerchantDO-state
     */
    private String state;

    /**
     * This field was generated by MyBatis Generator.
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取：MerchantDO-主键
     *
     * @return 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：MerchantDO-主键
     *
     * @param id MerchantDO-主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：MerchantDO-创建时间
     *
     * @return 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置：MerchantDO-创建时间
     *
     * @param gmtCreate MerchantDO-创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取：MerchantDO-修改时间
     *
     * @return 修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置：MerchantDO-修改时间
     *
     * @param gmtModified MerchantDO-修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取：MerchantDO-创建者
     *
     * @return 创建者
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置：MerchantDO-创建者
     *
     * @param creator MerchantDO-创建者
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 获取：MerchantDO-修改者
     *
     * @return 修改者
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置：MerchantDO-修改者
     *
     * @param modifier MerchantDO-修改者
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 获取：MerchantDO-乐观锁版本号
     *
     * @return 乐观锁版本号
     */
    public Long getVersion() {
        return version;
    }

    /**
     * 设置：MerchantDO-乐观锁版本号
     *
     * @param version MerchantDO-乐观锁版本号
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * 获取：MerchantDO-是否启用(0,1)
     *
     * @return 是否启用(0,1)
     */
    public String getActive() {
        return active;
    }

    /**
     * 设置：MerchantDO-是否启用(0,1)
     *
     * @param active MerchantDO-是否启用(0,1)
     */
    public void setActive(String active) {
        this.active = active == null ? null : active.trim();
    }

    /**
     * 获取：MerchantDO-机构逻辑主键(同盒马merchant_id)
     *
     * @return 机构逻辑主键(同盒马merchant_id)
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 设置：MerchantDO-机构逻辑主键(同盒马merchant_id)
     *
     * @param orgId MerchantDO-机构逻辑主键(同盒马merchant_id)
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * 获取：MerchantDO-名称
     *
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：MerchantDO-名称
     *
     * @param name MerchantDO-名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取：MerchantDO-负责人
     *
     * @return 负责人
     */
    public String getPrincipal() {
        return principal;
    }

    /**
     * 设置：MerchantDO-负责人
     *
     * @param principal MerchantDO-负责人
     */
    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    /**
     * 获取：MerchantDO-联系人电话
     *
     * @return 联系人电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置：MerchantDO-联系人电话
     *
     * @param phone MerchantDO-联系人电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取：MerchantDO-传真
     *
     * @return 传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * 设置：MerchantDO-传真
     *
     * @param fax MerchantDO-传真
     */
    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    /**
     * 获取：MerchantDO-支付宝账号
     *
     * @return 支付宝账号
     */
    public String getAlipayAccount() {
        return alipayAccount;
    }

    /**
     * 设置：MerchantDO-支付宝账号
     *
     * @param alipayAccount MerchantDO-支付宝账号
     */
    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount == null ? null : alipayAccount.trim();
    }

    /**
     * 获取：MerchantDO-分账费率
     *
     * @return 分账费率
     */
    public Long getLedgerAccountRate() {
        return ledgerAccountRate;
    }

    /**
     * 设置：MerchantDO-分账费率
     *
     * @param ledgerAccountRate MerchantDO-分账费率
     */
    public void setLedgerAccountRate(Long ledgerAccountRate) {
        this.ledgerAccountRate = ledgerAccountRate;
    }

    /**
     * 获取：MerchantDO-备注
     *
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置：MerchantDO-备注
     *
     * @param remark MerchantDO-备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取：MerchantDO-编码
     *
     * @return 编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置：MerchantDO-编码
     *
     * @param code MerchantDO-编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取：MerchantDO-省
     *
     * @return 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置：MerchantDO-省
     *
     * @param province MerchantDO-省
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取：MerchantDO-市
     *
     * @return 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置：MerchantDO-市
     *
     * @param city MerchantDO-市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取：MerchantDO-区
     *
     * @return 区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置：MerchantDO-区
     *
     * @param area MerchantDO-区
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 获取：MerchantDO-详细地址
     *
     * @return 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置：MerchantDO-详细地址
     *
     * @param address MerchantDO-详细地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取：MerchantDO-扩展字段
     *
     * @return 扩展字段
     */
    public String getExtension() {
        return extension;
    }

    /**
     * 设置：MerchantDO-扩展字段
     *
     * @param extension MerchantDO-扩展字段
     */
    public void setExtension(String extension) {
        this.extension = extension == null ? null : extension.trim();
    }

    /**
     * 获取：MerchantDO-上级机构id
     *
     * @return 上级机构id
     */
    public Long getParentOrgId() {
        return parentOrgId;
    }

    /**
     * 设置：MerchantDO-上级机构id
     *
     * @param parentOrgId MerchantDO-上级机构id
     */
    public void setParentOrgId(Long parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    /**
     * 获取：MerchantDO-电子身份标签
     *
     * @return 电子身份标签
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     * 设置：MerchantDO-电子身份标签
     *
     * @param appKey MerchantDO-电子身份标签
     */
    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    /**
     * 获取：MerchantDO-商家类型,1.正式2.测试
     *
     * @return 商家类型,1.正式2.测试
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置：MerchantDO-商家类型,1.正式2.测试
     *
     * @param flag MerchantDO-商家类型,1.正式2.测试
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    /**
     * 获取：MerchantDO-合同编码
     *
     * @return 合同编码
     */
    public String getContractCode() {
        return contractCode;
    }

    /**
     * 设置：MerchantDO-合同编码
     *
     * @param contractCode MerchantDO-合同编码
     */
    public void setContractCode(String contractCode) {
        this.contractCode = contractCode == null ? null : contractCode.trim();
    }

    /**
     * 获取：MerchantDO-合同创建时间
     *
     * @return 合同创建时间
     */
    public Date getContractCreateTime() {
        return contractCreateTime;
    }

    /**
     * 设置：MerchantDO-合同创建时间
     *
     * @param contractCreateTime MerchantDO-合同创建时间
     */
    public void setContractCreateTime(Date contractCreateTime) {
        this.contractCreateTime = contractCreateTime;
    }

    /**
     * 获取：MerchantDO-合同生效时间
     *
     * @return 合同生效时间
     */
    public Date getContractStartTime() {
        return contractStartTime;
    }

    /**
     * 设置：MerchantDO-合同生效时间
     *
     * @param contractStartTime MerchantDO-合同生效时间
     */
    public void setContractStartTime(Date contractStartTime) {
        this.contractStartTime = contractStartTime;
    }

    /**
     * 获取：MerchantDO-合同终止时间
     *
     * @return 合同终止时间
     */
    public Date getContractEndTime() {
        return contractEndTime;
    }

    /**
     * 设置：MerchantDO-合同终止时间
     *
     * @param contractEndTime MerchantDO-合同终止时间
     */
    public void setContractEndTime(Date contractEndTime) {
        this.contractEndTime = contractEndTime;
    }

    /**
     * 获取：MerchantDO-邮箱地址
     *
     * @return 邮箱地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置：MerchantDO-邮箱地址
     *
     * @param email MerchantDO-邮箱地址
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取：MerchantDO-state
     *
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * 设置：MerchantDO-state
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}