//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ztesoft.zsmart.nros.sbc.nrosuser.plugin.jde.dao.model.common;

import java.util.HashMap;
import java.util.Map;

public class EISResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public EISResult() {
        this.put((String)"httpcode", Integer.valueOf(200));
    }

    public static EISResult error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static EISResult error(String msg) {
        return error(500, msg);
    }

    public static EISResult error(int code, String msg) {
        EISResult r = new EISResult();
        r.put((String) "httpcode", code);
        r.put((String) "httpmsg", msg);
        return r;
    }

    public static EISResult ok(String msg) {
        EISResult r = new EISResult();
        r.put((String) "httpmsg", msg);
        return r;
    }



    public static EISResult ok(Map<String, Object> map) {
        EISResult r = new EISResult();
        r.putAll(map);
        r.put("httpmsg","success");
        return r;
    }

    public static EISResult ok(Object data) {
        EISResult r = new EISResult();
        r.put("data", data);
        r.put("httpmsg", "success");
        return r;
    }

    public static EISResult ok() {
        return new EISResult();
    }

    @Override
    public EISResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
