package com.academy.fx.model;

public class AuthForm {
    private static final int INDEX_FIELD = 0;
    private static final int INDEX_VALUE = 1;

    private String[] email = new String[2];
    private String[] password = new String[2];

    public AuthForm withEmail(String emailField, String emailValue) {
        this.email[INDEX_FIELD] = emailField;
        this.email[INDEX_VALUE] = emailValue;
        return this;
    }

    public AuthForm withPassword(String passwordField, String passwordValue) {
        this.password[INDEX_FIELD] = passwordField;
        this.password[INDEX_VALUE] = passwordValue;
        return this;
    }

    public String getEmailField() {
        return email[INDEX_FIELD];
    }

    public String getEmailValue() {
        return email[INDEX_VALUE];
    }

    public String getPasswordField() {
        return password[INDEX_FIELD];
    }

    public String getPasswordValue() {
        return password[INDEX_VALUE];
    }
}
