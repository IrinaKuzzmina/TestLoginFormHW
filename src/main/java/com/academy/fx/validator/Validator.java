package com.academy.fx.validator;

public interface Validator {
    boolean validate(String fieldName, String value);
    String getMsgError();
}
