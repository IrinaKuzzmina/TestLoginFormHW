package com.academy.fx.page;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RegistrationPage implements Page {
    private static final String PAGE = "ui/page/registration.fxml";

    private Stage registrationStage;

    public RegistrationPage() {
        registrationStage = new Stage();
    }

    @Override
    public void init() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource(PAGE));
            BorderPane rootLayout = loader.load();
            Scene scene = new Scene(rootLayout, 400, 350);

            registrationStage.setTitle("Registration Form");
            registrationStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void show() {
        registrationStage.show();
    }

    @Override
    public void close() {
        registrationStage.close();
    }

    @Override
    public void hide() {
        registrationStage.hide();
    }
}
