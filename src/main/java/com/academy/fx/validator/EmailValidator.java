package com.academy.fx.validator;

public class EmailValidator implements Validator {
    private String msgError = "";

    @Override
    public boolean validate(String value) {
        return true;
    }

    @Override
    public String getMsgError() {
        return msgError;
    }
}
