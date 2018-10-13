package recitation4_javafx;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 *
 * @author McKillaGorilla
 */
public class RedBoxManRenderer extends Application {
    Canvas canvas;
    GraphicsContext gc;
    ArrayList<Point2D> imagesRedBoxManLocations;
    ArrayList<Point2D> shapesRedBoxManLocations;
    Image redBoxManImage;
    
    @Override
    public void start(Stage primaryStage) {
	// INIT THE DATA MANAGERS
	imagesRedBoxManLocations = new ArrayList();
	shapesRedBoxManLocations = new ArrayList();
	
	// LOAD THE RED BOX MAN IMAGE
	redBoxManImage = new Image("RedBoxMan.png");
	
	// MAKE THE CANVAS
	canvas = new Canvas();
	canvas.setStyle("-fx-background-color: cyan");
	gc = canvas.getGraphicsContext2D();

	// PUT THE CANVAS IN A CONTAINER
	Group root = new Group();
	root.getChildren().add(canvas);
	
	canvas.setOnMouseClicked(e->{
            if(e.isShiftDown()){
               shapesRedBoxManLocations.add(new Point2D(e.getX(), e.getY()));
		render();
            }
            else if (e.isControlDown()) {
		imagesRedBoxManLocations.add(new Point2D(e.getX(), e.getY()));
		render();
	    }
	    else {
		clear();
	    }
	});
	
	// PUT THE CONTAINER IN A SCENE
	Scene scene = new Scene(root, 800, 600);
	canvas.setWidth(scene.getWidth());
	canvas.setHeight(scene.getHeight());

	// AND START UP THE WINDOW
	primaryStage.setTitle("Red Box Man Renderer");
	primaryStage.setScene(scene);
	primaryStage.show();
    }
    
    public void clearCanvas() {
	gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
    
    public void clear() {
	shapesRedBoxManLocations.clear();
	imagesRedBoxManLocations.clear();
	render();
    }
    
    public void render() {
	clearCanvas();
	for (int i = 0; i < shapesRedBoxManLocations.size(); i++) {
	    renderShapeRedBoxMan(shapesRedBoxManLocations.get(i));
	}
	for (int j = 0; j < imagesRedBoxManLocations.size(); j++) {
	    renderImageRedBoxMan(imagesRedBoxManLocations.get(j));
	}
    }
    
    public void renderShapeRedBoxMan(Point2D location) {
	String headColor = "#DD0000";
	String outlineColor = "#000000";
	int headW = 115;
	int headH = 88;
    
	// DRAW HIS RED HEAD
        gc.setFill(Paint.valueOf(headColor));
	gc.fillRect(location.getX(), location.getY(), headW, headH);
        gc.beginPath();
	gc.setStroke(Paint.valueOf(outlineColor));
	gc.setLineWidth(1);
	gc.rect(location.getX(), location.getY(), headW, headH);
	gc.stroke();
	
	// AND THEN DRAW THE REST OF HIM
        String eyeColor = "FFFF14";
	int eyeW = 30;
	int eyeH = 20;
        
        // left eye
        gc.setFill(Paint.valueOf(eyeColor));
	gc.fillRect(location.getX()+10, location.getY()+10, eyeW, eyeH);
        gc.beginPath();
	gc.setStroke(Paint.valueOf(outlineColor));
	gc.setLineWidth(1);
	gc.rect(location.getX()+10, location.getY()+10, eyeW, eyeH);
	gc.stroke();
        
        // right eye
        gc.setFill(Paint.valueOf(eyeColor));
	gc.fillRect(location.getX()+80, location.getY()+10, eyeW, eyeH);
        gc.beginPath();
	gc.setStroke(Paint.valueOf(outlineColor));
	gc.setLineWidth(1);
	gc.rect(location.getX()+80, location.getY()+10, eyeW, eyeH);
	gc.stroke();
        
        String pupilColor = "000000";
        int pupilW = 4;
        int pupilH = 4;
        
        // left pupil
        gc.setFill(Paint.valueOf(pupilColor));
	gc.fillRect(location.getX()+15, location.getY()+10, pupilW, pupilH);
        gc.beginPath();
	gc.setStroke(Paint.valueOf(outlineColor));
	gc.setLineWidth(1);
	gc.rect(location.getX()+15, location.getY()+10, pupilW, pupilH);
	gc.stroke();
        
        // left pupil
        gc.setFill(Paint.valueOf(pupilColor));
	gc.fillRect(location.getX()+82, location.getY()+10, pupilW, pupilH);
        gc.beginPath();
	gc.setStroke(Paint.valueOf(outlineColor));
	gc.setLineWidth(1);
	gc.rect(location.getX()+82, location.getY()+10, pupilW, pupilH);
	gc.stroke();
        
        // mouth
        int mouthW = 80;
        int mouthH = 4;
        
        // left pupil
        gc.setFill(Paint.valueOf(pupilColor));
	gc.fillRect(location.getX()+10, location.getY()+50, mouthW, mouthH);
        gc.beginPath();
	gc.setStroke(Paint.valueOf(outlineColor));
	gc.setLineWidth(1);
	gc.rect(location.getX()+10, location.getY()+50, mouthW, mouthH);
	gc.stroke();
        
        int bodyW = 80;
        int bodyH = 10;
        // body
        gc.setFill(Paint.valueOf(pupilColor));
	gc.fillRect(location.getX()+10, location.getY()+88, bodyW, bodyH);
        gc.beginPath();
	gc.setStroke(Paint.valueOf(outlineColor));
	gc.setLineWidth(1);
	gc.rect(location.getX()+10, location.getY()+88, bodyW, bodyH);
	gc.stroke();
        
        int waistW = 65;
        int waistH = 10;
        // waist
        gc.setFill(Paint.valueOf(pupilColor));
	gc.fillRect(location.getX()+20, location.getY()+98, waistW, waistH);
        gc.beginPath();
	gc.setStroke(Paint.valueOf(outlineColor));
	gc.setLineWidth(1);
	gc.rect(location.getX()+20, location.getY()+98, waistW, waistH);
	gc.stroke();
        
        int legW = 10;
        int legH = 10;
        // left leg
        gc.setFill(Paint.valueOf(pupilColor));
	gc.fillRect(location.getX()+10, location.getY()+108, legW, legH);
        gc.beginPath();
	gc.setStroke(Paint.valueOf(outlineColor));
	gc.setLineWidth(1);
	gc.rect(location.getX()+10, location.getY()+108, legW, legH);
        
        // right leg
        gc.setFill(Paint.valueOf(pupilColor));
	gc.fillRect(location.getX()+80, location.getY()+108, legW, legH);
        gc.beginPath();
	gc.setStroke(Paint.valueOf(outlineColor));
	gc.setLineWidth(1);
	gc.rect(location.getX()+80, location.getY()+108, legW, legH);
    }
    
    public void renderImageRedBoxMan(Point2D location) {
	gc.drawImage(redBoxManImage, location.getX(), location.getY());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	launch(args);
    }
    
}
