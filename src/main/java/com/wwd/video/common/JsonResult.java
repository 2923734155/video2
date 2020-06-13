package com.wwd.video.common;

public class JsonResult {
    private int code;
    private int roles;
    private  Object info;

    public JsonResult() {
    }

    public JsonResult(int code,int roles, Object info) {
        this.code = code;
        this.info = info;
        this.roles= roles;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public int getRoles() {
        return roles;
    }

    public void setRoles(int roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", roles=" + roles +
                ", info=" + info +
                '}';
    }
}
