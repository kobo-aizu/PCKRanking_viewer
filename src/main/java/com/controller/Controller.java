package com.controller;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class Controller implements Initializable{
    private final int TEAM_NUM = 20;
    private int[] num;
    private int max_team = 46;
    @FXML
    VBox ranking;
    @FXML
    Label testLabel;
    private final String REST_URL = "http://localhost:8080/Akode_history/api/";

    public void Load(){
        num = new int[TEAM_NUM];
        for(int i=0;i<TEAM_NUM;i++){
            num[i]= new Random().nextInt(max_team)+1;
        }
        Write();
    }

    public void Write(){
        ranking.getChildren().clear();
        for(int i = 0;i<TEAM_NUM;i++){
            try {
                final Client client = ClientBuilder.newClient();
                final String result = client.target(REST_URL)
                        .path("history")
                        .path("search")
                        .path("prefecture")
                        .path(String.valueOf(num[i]))
                        .request(MediaType.TEXT_PLAIN_TYPE)
                        .get(String.class);
                ranking.getChildren().add(new Label(result));
            }catch(Exception e){
                System.err.println("異常発生");
                System.err.println(e);
            }



        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        Load();
    }
}
