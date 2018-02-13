package br.sghvet.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
Stage window;
    
    @Override
    public void start(Stage stage) throws Exception {
       
      
 
        window = stage;
        window.setTitle("SGHvet");
        Parent root = FXMLLoader.load(getClass().getResource("../view/fxml_ui_login.fxml"));
        Scene scene = new Scene(root );
        window.setScene(scene);
        window.show();
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
  
}
