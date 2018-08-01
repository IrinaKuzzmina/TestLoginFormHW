package com.academy.fx.validator;

import com.academy.fx.model.RegistrationForm;
import com.academy.fx.service.UserService;

public class RegistrationValidator implements Validator<RegistrationForm> {
    private static final String REGEX = "^[\\w]+[.]?[\\w]+@[\\w]+[.]?[\\w]+$";

    private String errorMessage = "";
    private UserService userService = UserService.getInstance();

    @Override
    public boolean validate(RegistrationForm form) {
        if (!validateName(form.getFirstNameFieldName(), form.getFirstNameValue()))
            return false;

        if (!validateName(form.getLastNameFieldName(), form.getLastNameValue()))
            return false;

        if (!validateMail(form.getMailFieldName(), form.getMailValue()))
            return false;

        if (!validatePassword(form.getPasswordValue()))
            return false;

        if (!validateEqualsPasswords(form.getPasswordValue(), form.getConfirmPasswordValue()))
            return false;

        if (!validateExistenceUser(form.getMailValue()))
            return false;

        return true;
    }

    @Override
    public String getMsgError() {
        return errorMessage;
    }

    private boolean validateName(String fieldName, String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            errorMessage = String.format("Empty field '%s'", fieldName);
            return false;
        }

        return true;
    }

    private boolean validateMail(String fieldName, String mail) {
        if (mail == null || mail.isEmpty()) {
            errorMessage = String.format("Empty '%s'", fieldName);
            return false;
        }

        if (!mail.matches(REGEX)) {
            errorMessage = String.format("Not correct format of '%s'", fieldName);
            return false;
        }

        return true;
    }

    private boolean validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            errorMessage = "Empty withPassword";
            return false;
        }

        if (password.length() < 8) {
            errorMessage = "Short withPassword";
            return false;
        }

        if (!password.matches(".*[\\d].*")) {
            errorMessage = "Password must contain digit";
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            errorMessage = "Password must contain upper symbols";
            return false;
        }

        if (!password.matches(".*[a-z].*")) {
            errorMessage = "Password must contain lower symbols";
            return false;
        }

        return true;
    }

    private boolean validateEqualsPasswords(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            errorMessage = "Not equals passwords";
            return false;
        }

        return true;
    }

    private boolean validateExistenceUser(String mail) {
        if (userService.getByEmail(mail) != null) {
            errorMessage = "User with such email already exists";
            return false;
        }

        return true;
    }
}
