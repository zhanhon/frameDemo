package com.zhanh.utilslibrary.network.response;

/**
 * 返回结果封装
 */

public class ResponseEntity<T> {
    private static final int SUCCESS_CODE = 0;//成功的code

    public boolean isSuccess(){
        return code == SUCCESS_CODE;
    }

    private int code; // 返回的code
    private T data; // 具体的数据结果
    private String msg; // message 可用来返回接口的说明

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
