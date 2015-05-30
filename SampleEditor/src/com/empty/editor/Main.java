package com.empty.editor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by mr3mpty on 30.05.15.
 */
public class Main extends Application{

    public static String inputTextParam;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        inputTextParam = getParameters().getNamed().get("inputText");
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("File editor");

        initRootLayout();
    }

    private void initRootLayout() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("views/MainView.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
