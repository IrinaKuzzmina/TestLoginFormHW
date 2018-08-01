package com.academy.fx.validator;

import com.academy.fx.model.AuthForm;
import com.academy.fx.model.User;
import com.academy.fx.service.UserService;

public class AuthValidator implements Validator<AuthForm> {
    private String errorMsg = "";
    private UserService userService = UserService.getInstance();

    @Override
    public boolean validate(AuthForm form) {
        if (form.getEmailValue() == null || form.getEmailValue().isEmpty()) {
            errorMsg = "Empty email";
            return false;
        }

        if (form.getPasswordValue() == null || form.getPasswordValue().isEmpty()) {
            errorMsg = "Empty password";
            return false;
        }

        User user = userService.getByEmail(form.getEmailValue());
        if (user == null || !user.getPassword().equals(form.getPasswordValue())) {
            errorMsg = "Invalid mail or password";
            return false;
        }

        return true;
    }

    @Override
    public String getMsgError() {
        return errorMsg;
    }
}
