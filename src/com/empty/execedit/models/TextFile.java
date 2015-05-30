package com.empty.execedit.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by mr3mpty on 30.05.15.
 */
public class TextFile {

    private String fileContent;

    public TextFile(String fileName) throws IOException {
        this.fileContent = new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public String getFileContent() {
        return fileContent;
    }

    public void updateText(String s) {
        this.fileContent = s;
    }

    public void save() {
        //TODO
    }
}
