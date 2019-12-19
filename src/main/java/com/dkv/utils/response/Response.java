package com.dkv.utils.response;

public class Response<I> {
    private I obj;
    private int code;
    private String responseMessage;

    public Response(I obj) {
        this.obj = obj;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public I getObj() {
        return obj;
    }

    @Override
    public String toString() {
        return "Response{" +
                "obj=" + obj +
                ", code=" + code +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }
}
