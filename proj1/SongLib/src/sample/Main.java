//Jonathen Sheffer
//Aaron Teitz


package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override



     public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/SongLib.fxml"));
        AnchorPane root = (AnchorPane)loader.load();
        //Parent root = FXMLLoader.load(getClass().getResource("/sample/Songlib.fxml"));

        Controller control = loader.getController();
        control.start();
        primaryStage.setTitle("Song Lib");
        primaryStage.setScene(new Scene(root, 820, 620 ));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
