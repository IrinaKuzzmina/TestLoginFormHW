package com.academy.fx.validator;

import com.academy.fx.model.AuthForm;
import com.academy.fx.model.User;
import com.academy.fx.service.PropertyService;
import com.academy.fx.service.UserService;

import static com.academy.fx.service.ErrorKey.*;

public class AuthValidator implements Validator<AuthForm> {
    private String errorMsg = "";
    private UserService userService = UserService.getInstance();
    private PropertyService propService = PropertyService.getInstance();

    @Override
    public boolean validate(AuthForm form) {
        if (form.getEmailValue() == null || form.getEmailValue().isEmpty()) {
            errorMsg = propService.getError(AUTH_EMAIL_EMPTY);
            return false;
        }

        if (form.getPasswordValue() == null || form.getPasswordValue().isEmpty()) {
            errorMsg = propService.getError(AUTH_PASSW_EMPTY);
            return false;
        }

        User user = userService.getByEmail(form.getEmailValue());
        if (user == null || !user.getPassword().equals(form.getPasswordValue())) {
            errorMsg = propService.getError(AUTH_ERROR);
            return false;
        }

        return true;
    }

    @Override
    public String getMsgError() {
        return errorMsg;
    }
}
