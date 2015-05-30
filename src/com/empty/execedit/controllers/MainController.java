package com.empty.execedit.controllers;

import org.controlsfx.dialog.Dialogs;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    private void onLoadFromDiskClick() {

        Dialogs.create()
                .title("Waiting for")
                .masthead("asd")
                .message("asdadsdsad")
                .showInformation();

    }
}
