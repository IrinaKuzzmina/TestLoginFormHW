package com.academy.fx.validator;

public class NameValidator implements Validator {
    private String msgError = "";

    @Override
    public boolean validate(String fieldName, String value) {
        if (value == null || value.isEmpty()) {
            msgError = String.format("Empty field '%s'", fieldName);
            return false;
        }

        return true;
    }

    @Override
    public String getMsgError() {
        return msgError;
    }
}
