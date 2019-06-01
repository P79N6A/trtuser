package com.ztesoft.zsmart.nros.sbc.user.common.enums;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yaodingw
 * Date: 2019-04-18
 * Time: 15:38
 */
public enum DataStateEnum {
    A("A","有效"),
    X("X","作废"),
    ALL("ALL","全部");

    private String code;
    private String name;


    DataStateEnum(String code, String name){
        this.code = code;
        this.name = name;
    }

    public static DataStateEnum getDataStateEnum(String code) {
        for (DataStateEnum c : DataStateEnum.values()) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }


    public static String getDataState(String code){
        DataStateEnum dataStateEnum=getDataStateEnum(code);
        if(dataStateEnum == null){
            return A.getCode();
        }else if(dataStateEnum==ALL){
            return null;
        }else{
            return dataStateEnum.getCode();
        }
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
