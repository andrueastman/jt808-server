package com.jt808.commons.model;

/**
 * Api exception
 */
public class APIException extends RuntimeException {

    private final int code;
    private String message;
    private String detailMessage;

    public APIException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public APIException(APICode code) {
        this.code = code.getCode();
        this.message = code.getMessage();
    }

    public APIException(APICode code, String msg) {
        this.code = code.getCode();
        this.message = msg;
    }

    public APIException(APICode code, String message, String detailMessage) {
        this.code = code.getCode();
        this.message = message;
        this.detailMessage = detailMessage;
    }

    public APIException(Throwable e) {
        super(e);
        this.code = APICodes.UnknownError.getCode();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    @Override
    public String toString() {
        return '{' +"code:" + code +",message:" + super.getMessage() +'}';
    }
}