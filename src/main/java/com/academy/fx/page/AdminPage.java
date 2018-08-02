package com.academy.fx.page;

import com.academy.fx.controller.AdminController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AdminPage implements Page {

    private static final String PAGE = "ui/page/admin.fxml";

    private Stage adminStage;
    private AdminController adminController;

    public AdminPage() {
        adminStage = new Stage();
    }

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }


    @Override
    public void init() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource(PAGE));
            BorderPane rootLayout = loader.load();
            adminController = loader.getController();
            Scene scene = new Scene(rootLayout, 400, 250);

            adminStage.setTitle("Account Page");
            adminStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void show() {
        adminStage.show();
        adminController.onInit();
    }

    @Override
    public void close() {
        adminStage.close();
    }

    @Override
    public void hide() {
        adminStage.hide();
        adminController.onHide();
    }
}
