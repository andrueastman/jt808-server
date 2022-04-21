package com.jt808.commons.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.jt808.commons.util.StrUtils;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Api Result<T>
 */
public class APIResult<T> {

    public static final APIResult SUCCESS = new ImmutableAPIResult<>(new APIResult<>());
    @JsonView(View.class)
    @Schema(description = "The response code (success: 200; Client error: 400-499; Server error: 500-599)")
    protected int code;
    @JsonView(View.class)
    @Schema(description = "The response message")
    protected String msg;
    @JsonView(View.class)
    @Schema(description = "The response message details\n")
    protected String detailMsg;
    @JsonView(View.class)
    @Schema(description = "The response data")
    protected T data;
    public APIResult() {
        this.code = APICodes.Success.getCode();
        this.msg = APICodes.Success.getMessage();
    }

    public APIResult(Exception e) {
        this.code = APICodes.UnknownError.getCode();
        this.msg = e.getMessage();
        this.detailMsg = StrUtils.getStackTrace(e);
    }

    public APIResult(APICode code, Exception e) {
        this.code = code.getCode();
        this.msg = code.getMessage();
        this.detailMsg = StrUtils.getStackTrace(e);
    }

    public APIResult(APIException e) {
        this.code = e.getCode();
        this.msg = e.getMessage();
        this.detailMsg = e.getDetailMessage();
    }

    public APIResult(APICode code) {
        this.code = code.getCode();
        this.msg = code.getMessage();
    }

    public APIResult(APICode code, String message) {
        this.code = code.getCode();
        this.msg = message;
    }

    public APIResult(APICode code, String message, String detailMsg) {
        this.code = code.getCode();
        this.msg = message;
        this.detailMsg = detailMsg;
    }

    public APIResult(T t) {
        this(APICodes.Success, t);
    }

    public APIResult(APICode code, T data) {
        this(code);
        this.data = data;
    }

    public APIResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> APIResult<T> ok(T data) {
        return new APIResult<>(data);
    }

    public boolean isSuccess() {
        return APICodes.Success.getCode() == code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDetailMsg() {
        return detailMsg;
    }

    public void setDetailMsg(String detailMsg) {
        this.detailMsg = detailMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public interface View {
    }

    public static final class ImmutableAPIResult<T> extends APIResult<T> {

        public ImmutableAPIResult(APIResult<T> that) {
            this.code = that.code;
            this.msg = that.msg;
            this.detailMsg = that.detailMsg;
            this.data = that.data;
        }

        @Override
        public void setCode(int code) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setMsg(String msg) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setDetailMsg(String detailMsg) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setData(T data) {
            throw new UnsupportedOperationException();
        }
    }
}