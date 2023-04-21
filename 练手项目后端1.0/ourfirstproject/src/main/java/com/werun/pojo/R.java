package com.werun.pojo;

import lombok.Data;
//表现层统一回复模型类
@Data
public class R {
    private Boolean flag;
    private Object data;
    private String msg;
}
