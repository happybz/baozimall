package com.baozimall.common;

/**
 * 响应编码枚举类
 */
public enum ResponseCode {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");

    private final int code;//编码
    private final String desc;//状态描述


    ResponseCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    //开放Code和Desc
    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}
