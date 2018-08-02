package com.academy.fx.validator;

import com.academy.fx.model.RegistrationForm;
import com.academy.fx.service.PropertyService;
import com.academy.fx.service.UserService;

import static com.academy.fx.service.ErrorKey.*;

public class RegistrationValidator implements Validator<RegistrationForm> {
    private static final String EMAIL_REGEX = "^[\\w]+[.]?[\\w]+@[\\w]+[.]?[\\w]+$";

    private String errorMessage = "";
    private UserService userService = UserService.getInstance();
    private PropertyService propService = PropertyService.getInstance();

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
            errorMessage = String.format(propService.getError(REG_FIELD_EMPTY), fieldName);
            return false;
        }

        return true;
    }

    private boolean validateMail(String fieldName, String mail) {
        if (mail == null || mail.isEmpty()) {
            errorMessage = String.format(propService.getError(REG_FIELD_EMPTY), fieldName, fieldName);
            return false;
        }

        if (!mail.matches(EMAIL_REGEX)) {
            errorMessage = String.format(propService.getError(REG_EMAIL_FORMAT), mail, fieldName);
            return false;
        }

        return true;
    }

    private boolean validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            errorMessage = propService.getError(REG_PASSW_EMPTY);
            return false;
        }

        if (password.length() < 8) {
            errorMessage = propService.getError(REG_PASSW_SHORT);
            return false;
        }

        if (!password.matches(".*[\\d].*")) {
            errorMessage = propService.getError(REG_PASSW_DIGIT);
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            errorMessage = propService.getError(REG_PASSW_UPPER);
            return false;
        }

        if (!password.matches(".*[a-z].*")) {
            errorMessage = propService.getError(REG_PASSW_LOWER);
            return false;
        }

        return true;
    }

    private boolean validateEqualsPasswords(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            errorMessage = propService.getError(REG_PASSW_EQ);
            return false;
        }

        return true;
    }

    private boolean validateExistenceUser(String mail) {
        if (userService.getByEmail(mail) != null) {
            errorMessage = propService.getError(REG_USER_EXISTS);
            return false;
        }

        return true;
    }
}
