package com.empty.editor.controllers;

import com.empty.editor.Main;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * Created by mr3mpty on 30.05.15.
 */
public class MainController {

    @FXML
    private TextArea textArea;

    @FXML
    private void initialize() {

        if(Main.inputTextParam != null) {
            textArea.setText(Main.inputTextParam);
        }
    }

    @FXML
    private void onSaveClick() {
        System.out.print(textArea.getText());
        System.exit(1);
    }
}
