package com.academy.fx.model;

public class RegistrationForm {
    private static final int INDEX_FIELD = 0;
    private static final int INDEX_VALUE = 1;

    private String[] firstName = new String[2];
    private String[] lastName = new String[2];
    private String[] mail = new String[2];
    private String[] password = new String[2];
    private String[] confirmPassword = new String[2];

    public RegistrationForm withFirstName(String firstNameField, String firstNameValue) {
        firstName = new String[] {firstNameField, firstNameValue};
        return this;
    }

    public RegistrationForm withLastName(String lastNameField, String lastNameValue) {
        lastName[INDEX_FIELD] = lastNameField;
        lastName[INDEX_VALUE] = lastNameValue;
        return this;
    }

    public RegistrationForm withMail(String mailField, String mailValue) {
        mail[INDEX_FIELD] = mailField;
        mail[INDEX_VALUE] = mailValue;
        return this;
    }

    public RegistrationForm withPassword(String passwordField, String passwordValue) {
        password[INDEX_FIELD] = passwordField;
        password[INDEX_VALUE] = passwordValue;
        return this;
    }

    public RegistrationForm withConfirmPassword(String confirmPasswordField, String confirmPasswordValue) {
        confirmPassword[INDEX_FIELD] = confirmPasswordField;
        confirmPassword[INDEX_VALUE] = confirmPasswordValue;
        return this;
    }

    public String getFirstNameFieldName() {
        return firstName[INDEX_FIELD];
    }

    public String getFirstNameValue() {
        return firstName[INDEX_VALUE];
    }

    public String getLastNameFieldName() {
        return lastName[INDEX_FIELD];
    }

    public String getLastNameValue() {
        return  lastName[INDEX_VALUE];
    }

    public String getMailFieldName() {
        return mail[INDEX_FIELD];
    }

    public String getMailValue() {
        return mail[INDEX_VALUE];
    }

    public String getPasswordFieldName() {
        return password[INDEX_FIELD];
    }

    public String getPasswordValue() {
        return password[INDEX_VALUE];
    }

    public String getConfirmPasswordFieldName() {
        return confirmPassword[INDEX_FIELD];
    }

    public String getConfirmPasswordValue() {
        return confirmPassword[INDEX_VALUE];
    }



}
