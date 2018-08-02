package com.academy.fx.page;

import com.academy.fx.controller.AccountController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AccountPage implements Page {

    private static final String PAGE = "ui/page/account.fxml";

    private Stage accountStage;
    private String email;

    public AccountPage(String email) {
        this.email = email;
        accountStage = new Stage();
    }

    @Override
    public void init() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource(PAGE));
            BorderPane rootLayout = loader.load();
            AccountController controller = loader.getController();
            controller.init(email);
            Scene scene = new Scene(rootLayout, 400, 250);

            accountStage.setTitle("Account Page");
            accountStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

