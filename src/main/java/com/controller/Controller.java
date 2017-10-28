package com.controller;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Controller implements Initializable{

    private int[] num;
    private int max_team = 28;
    @FXML
    VBox ranking;
    @FXML
    Label testLabel;

    public void Load(){
        num = new int[max_team];
        for(int i=0;i<max_team;i++){
            num[i]= new Random().nextInt(max_team);
            System.out.println(num[i]);
        }
        Write();
    }

    public void Write(){
        ranking.getChildren().clear();
        for(int i = 0;i<max_team;i++){
            ranking.getChildren().add(new Label(String.valueOf(num[i])));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        Load();
    }
}
