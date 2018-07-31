package com.academy.fx.page;

import com.academy.fx.controller.AccountController;
import javafx.stage.Stage;

public class AccountPage implements Page {

    private Stage accountStage;
    private AccountController accountController;

    @Override
    public void init() {
        accountStage = new Stage();
        accountController = new AccountController();
    }

    @Override
    public void show() {
        accountStage.show();
    }

    @Override
    public void hide() {
        accountStage.hide();
    }

    @Override
    public void close() {
        accountStage.close();
    }
}

