package com.jt808.commons.model;

/**
 * Api code enums
 */
public enum APICodes implements APICode {

    Success(200, "Ok"),
    UnregisteredUser(402, "Unregistered User"),
    Unauthorized(403, "Unauthorized"),
    MissingParameter(400, "Missing Parameter"),
    TypeMismatch(410, "Type Mismatch"),
    InvalidParameter(411, "Invalid Parameter"),
    NotSupportedType(412, "Unsupported Type"),
    NotImplemented(413, "Not Implemented"),
    OperationFailed(420, "Operation Failed"),
    OfflineClient(4000, "Offline Client"),
    UnknownError(500, "Unknown Error");

    private final int code;
    private final String message;

    APICodes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}