package com.academy.fx.page;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginPage implements Page {
    private static final String PAGE = "page/login.fxml";

    private Stage loginStage;

    public LoginPage() {
        this.loginStage = new Stage();
    }

    public LoginPage(Stage loginStage) {
        this.loginStage = loginStage;
    }

    @Override
    public void show() {
        loginStage.show();
    }

    @Override
    public void close() {
        loginStage.close();
    }

    @Override
    public void hide() {
        loginStage.hide();
    }

    @Override
    public void init() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource(PAGE));
            BorderPane rootLayout = loader.load();
            Scene scene = new Scene(rootLayout, 400, 300);

            loginStage.setTitle("Login Form");
            loginStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
