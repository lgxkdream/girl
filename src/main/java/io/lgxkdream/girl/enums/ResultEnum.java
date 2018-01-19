package io.lgxkdream.girl.enums;

public enum ResultEnum {

    SUCCESS(200, "响应成功"),
    UNKONW_ERROR(500, "未知错误"),
    PRIMARY_SCHOOL(501, "你还在上小学吧"),
    MIDDLE_SCHOOL(502, "你可能在上初中");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
