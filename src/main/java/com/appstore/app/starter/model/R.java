package com.appstore.app.starter.model;

public class R {
    private Integer status;
    private String msg;
    private Object obj;

    public static R build() {
        return new R();
    }

    public static R ok(String msg) {
        return new R(200, msg, null);
    }

    public static R ok(String msg, Object obj) {
        return new R(200, msg, obj);
    }

    public static R error(String msg) {
        return new R(500, msg, null);
    }

    public static R error(String msg, Object obj) {
        return new R(500, msg, obj);
    }

    private R() {
    }

    private R(Integer status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    public Integer getStatus() {
        return status;
    }

    public R setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public R setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public R setObj(Object obj) {
        this.obj = obj;
        return this;
    }
}