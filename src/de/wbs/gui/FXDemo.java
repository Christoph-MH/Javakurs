package de.wbs.gui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;


public class FXDemo extends Application {

    public FXDemo() {
    }

    @FXML
    private void initialize() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    Label label;

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Maingui.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);   // Scene muss gesetzt werden
        primaryStage.sizeToScene();

        primaryStage.show();
    }

    @FXML
    public void btn1onclick(MouseEvent mouseEvent) {
        System.out.println("Es wurde der Button gedrückt");
        label.setText("Button wurde gedrückt");
    }
}
