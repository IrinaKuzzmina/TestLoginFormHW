package com.academy.fx.page;

import com.academy.fx.controller.RegistrationController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RegistrationPage implements Page {
    private static final String STYLES = "styles/registration.css";
    private static final String PAGE = "page/registration.fxml";

    private Stage registrationStage;
    private RegistrationController registrationController;

    public RegistrationPage() {
        registrationController = new RegistrationController();
        registrationStage = new Stage();
    }

    @Override
    public void init() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource(PAGE));
            BorderPane rootLayout = loader.load();
            Scene scene = new Scene(rootLayout, 400, 350);
            scene.getStylesheets().add(getClass().getClassLoader().getResource(STYLES).toExternalForm());

            registrationStage.setTitle("Registration Page");
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
}
