package com.chenqi.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultEntity implements Serializable {
    //返回说明
    private String reason;
    //返回的code码
    private Integer code;
    //返回的数据
    private Object result;

    public ResultEntity() {
    }

    public ResultEntity(String reason, Integer code, Object result) {
        this.reason = reason;
        this.code = code;
        this.result = result;
    }

    //成功数据格式
    public static ResultEntity ok(Object result){
        return new ResultEntity("success",10001,result);
    }

    //上传失败的表示
    public static ResultEntity error(){
        return new ResultEntity("error",10002,null);
    }

    //失败实体Bean上
    public static ResultEntity error(Integer code, Object result){
        return new ResultEntity("error",code,result);
    }

}
