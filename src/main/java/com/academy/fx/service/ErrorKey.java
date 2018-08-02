package com.academy.fx.service;

public enum ErrorKey {

    REG_FIELD_EMPTY("reg.field.empty"),
    REG_EMAIL_FORMAT("reg.email.format"),
    REG_PASSW_EMPTY("reg.passw.empty"),
    REG_PASSW_SHORT("reg.passw.short"),
    REG_PASSW_DIGIT("reg.passw.digit"),
    REG_PASSW_UPPER("reg.passw.upper"),
    REG_PASSW_LOWER("reg.passw.lower"),
    REG_PASSW_EQ("reg.passw.eq"),
    REG_USER_EXISTS("reg.user.exists"),

    AUTH_EMAIL_EMPTY("auth.email.empty"),
    AUTH_PASSW_EMPTY("auth.passw.empty"),
    AUTH_ERROR("error");


    private String value;

    ErrorKey(String value) {
        this.value= value;
    }

    public String getValue() {
        return value;
    }
}
