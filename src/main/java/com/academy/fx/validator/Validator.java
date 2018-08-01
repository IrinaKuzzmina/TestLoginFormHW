package com.academy.fx.validator;

public interface Validator<T> {
    boolean validate(T form);
    String getMsgError();
}
