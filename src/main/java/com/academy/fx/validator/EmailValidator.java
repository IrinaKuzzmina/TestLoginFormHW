package com.academy.fx.validator;

public class EmailValidator implements Validator {
    private static final String REGEX = "^[\\w]+[.]?[\\w]+@[\\w]+[.]?[\\w]+$";
    private String msgError = "";

    @Override
    public boolean validate(String fieldName, String value) {
        if (value == null || value.isEmpty()) {
            msgError = String.format("Empty '%s'", fieldName);
            return false;
        }

        if (!value.matches(REGEX)) {
            msgError = String.format("Not correct format of '%s'", fieldName);
            return false;
        }

        return true;
    }

    @Override
    public String getMsgError() {
        return msgError;
    }
}
