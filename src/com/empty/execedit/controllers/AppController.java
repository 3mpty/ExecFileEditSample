package com.empty.execedit.controllers;

import com.empty.execedit.Main;

/**
 * Created by mr3mpty on 30.05.15.
 */
public abstract class AppController {

    private Main main;

    public Main getMainApp(){
        return main;
    }

    public void setMainApp(Main mainApp){
        this.main = mainApp;
    }
}
