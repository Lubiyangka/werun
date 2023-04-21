package com.werun.demo_werun.util;

import lombok.Data;

@Data

public class R {
    private Integer code;
    private Boolean flag;
    private Object data;
    private String msg;

    public R() {
    }

    public R(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public R(Boolean flag, Object data, String msg) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Integer code, Boolean flag, Object data, String msg) {
        this.code = code;
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }

    public static R error(Integer code, String msg){
        return new R(code,false,null,msg);
    }
}
