package com.academy.fx.validator;

public class PasswordValidator implements Validator{
    private String msgError = "";

    @Override
    public boolean validate(String fieldName, String password) {
        if (password == null || password.isEmpty()) {
            msgError = "Empty password";
            return false;
        }

        if (password.length() < 8) {
            msgError = "Short password";
            return false;
        }

        if (!password.matches(".*[\\d].*")) {
            msgError = "Password must contain digit";
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            msgError = "Password must contain upper symbols";
            return false;
        }

        if (!password.matches(".*[a-z].*")) {
            msgError = "Password must contain lower symbols";
            return false;
        }

        return true;
    }

    @Override
    public String getMsgError() {
        return msgError;
    }
}
