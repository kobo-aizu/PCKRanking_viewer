package viewer;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Main extends Application implements Initializable{
    private int[] num;
    private int max_team = 10;
    @FXML
    VBox ranking;

    @FXML
    Label testLabel;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
        primaryStage.setTitle("Ranking");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();
    }

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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        Load();
    }
}
