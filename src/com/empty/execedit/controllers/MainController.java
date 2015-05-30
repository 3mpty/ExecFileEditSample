package com.empty.execedit.controllers;

import com.empty.execedit.Main;
import com.empty.execedit.models.Constants;
import com.empty.execedit.models.TextFile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.dialog.Dialogs;

import java.io.*;

public class MainController extends AppController{

    @FXML
    private Button sendButton;

    @FXML
    private TextArea textArea;

    private TextFile textFile;

    @FXML
    private void onLoadFromDiskClick() throws FileNotFoundException {

        File testFile = new File(Constants.TEST_FILENAME);

        //it would thrown later anyway, but it's better to control such events
        if (!testFile.exists()) {
            throw new FileNotFoundException("Couldn't find file '" + Constants.TEST_FILENAME + "' in: " + System.getProperty("user.dir"));
        }

        try {
            this.textFile = new TextFile(Constants.TEST_FILENAME);
            textArea.setText(this.textFile.getFileContent());
            sendButton.setDisable(false);
        } catch (IOException e) {
            e.printStackTrace();

            Dialogs.create()
                    .title("File error")
                    .masthead("Couldn't read sample file")
                    .message(e.getMessage())
                    .showError();

            sendButton.setDisable(true);
        }

    }

    @FXML
    private void setSendButtonClick() throws InterruptedException {

        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", Constants.EDITOR_BIN, "--inputText=" + textFile.getFileContent());
        StringBuilder stringBuilder = new StringBuilder();

        try {
            Process process = processBuilder.start();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = bufferedreader.readLine()) != null) {
                stringBuilder.append(line).append('\n');
            }

            int returnCode = process.waitFor();

            if (returnCode == 1) {
                textFile.updateText(stringBuilder.toString());
                textArea.setText(textFile.getFileContent());
            } else {
                System.err.print("Editor returned: " + returnCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
