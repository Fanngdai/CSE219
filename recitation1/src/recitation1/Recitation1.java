/*
 * Opens a window that has 2 buttons which will print "Hello World!" or "Goodbye Cruel World!"
 * to the console.
 */
package recitation1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author fannydai
 */
public class Recitation1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button hello = new Button();
        hello.setText("Say 'Hello World'");
        Button goodbye = new Button();
        goodbye.setText("Goodbye Cruel World!");
        
        hello.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        goodbye.setOnAction(e->{
           System.out.println("Goodbye Cruel World!"); 
        });
        
        FlowPane root = new FlowPane();
        root.setHgap(10);
        root.setVgap(10);
        root.getChildren().addAll(hello, goodbye);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Greet");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }   
}