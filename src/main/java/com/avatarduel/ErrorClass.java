package com.avatarduel;

public class ErrorClass extends Exception{
    String errMsg, errCode;

    public ErrorClass(String msg){
        super(msg);
        this.errMsg = msg;
        this.errCode = "400";
    }

    public ErrorClass(String errCode, String msg){
        super(msg);
        this.errMsg = msg;
        this.errCode = errCode;
    }

    public String getErrCode(){
        return this.errCode;
    }

    public String getErrMsg(){
        return this.errMsg;
    }
}