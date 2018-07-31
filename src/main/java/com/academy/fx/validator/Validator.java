package com.academy.fx.validator;

public interface Validator {
    boolean validate(String value);
    String getMsgError();
}
