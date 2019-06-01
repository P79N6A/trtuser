package com.ztesoft.zsmart.nros.sbc.user.common.enums;

/**
 * 用户中心异常CODE ENUM
 *
 * @author bin.yu
 * @create 2019-05-08 11:02
 **/
public enum ExceptionCodeEnum {

    USER_ORG_EXIST_CHILD_NODE("NROS-SBC-USER-0001","存在子节点，不能删除"),
    USER_ORG_EXISTED("NROS-SBC-USER-0002","该节点类型已存在"),
    USER_ORG_UN_EXISTED("NROS-SBC-USER-003","机构不存在")
    ;

    private String code;
    private String message;


    ExceptionCodeEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public static ExceptionCodeEnum getExceptionCodeEnum(String code) {
        for (ExceptionCodeEnum c : ExceptionCodeEnum.values()) {
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
