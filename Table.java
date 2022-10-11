/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Soft
 */
public class Table extends Application {
    
    @Override
    public void start(Stage stage) {
       
        
        try {
           Parent root = FXMLLoader.load(getClass().getResource("newtable.fxml"));
       
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("interfaceStyle.css");
        stage.setTitle("                                                                                            .... Registeration Course ...");
        stage.setScene(scene);
        stage.show();
         } catch (Exception ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
