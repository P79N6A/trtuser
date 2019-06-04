package com.ztesoft.zsmart.nros.sbc.user.server.common.enums;

/**
 * 机构类型
 *
 * @author bin.yu
 * @create 2019-04-22 15:36
 **/
public enum OrgTypeEnum {

    CHANNEL("A","渠道"),
    STORE("B","门店"),
    WAREHOUSE("C","仓库"),
    MERCHANT("D", "商家"),
    SUBSIDIARY("E", "子公司")
    ;

    private String code;
    private String name;


    OrgTypeEnum(String code, String name){
        this.code = code;
        this.name = name;
    }

    public static OrgTypeEnum getOrgTypeEnum(String code) {
        for (OrgTypeEnum c : OrgTypeEnum.values()) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
