package com.academy.fx.validator;

public class NameValidator implements Validator {
    private String msgError = "";

    @Override
    public boolean validate(String value) {
        if (value == null || value.isEmpty()) {
            msgError = "Empty name";
            return false;
        }

        return true;
    }

    @Override
    public String getMsgError() {
        return msgError;
    }
}
