package rsp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 * This is a simple little program useful for randomly picking students
 * registered in our class to be called on to answer a question during lecture.
 *
 * @author Richard McKenna
 * @author Ritwik Banerjee
 */
public class RandomStudentPicker extends Application {

    String STUDENT_NAMES_FILE = "./data/student-names.json";
    int currentIndex = 0;
    Button prevButton = new Button("Previous");
    Button pickButton = new Button("Random");
    Button nextButton = new Button("Next");;
    ArrayList<String> students = new ArrayList();
    final Label studentNameLabel = new Label();

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("The Random Student Picker"); // set title

        JsonObject json = loadJSONFile(STUDENT_NAMES_FILE); // load JSON data
        JsonArray studentsArray = json.getJsonArray("names");
        for (int i = 0; i < studentsArray.size(); i++) {
            String studentName = studentsArray.getString(i);
            students.add(studentName);
        }

        List<String> fontFamilies = javafx.scene.text.Font.getFamilies();
        String randomFontFamily = fontFamilies.get((int) (Math.random() * fontFamilies.size()));
        Font buttonFont = new Font(randomFontFamily, 36);
        prevButton.setFont(buttonFont);
        pickButton.setFont(buttonFont);
        nextButton.setFont(buttonFont);
        randomFontFamily = fontFamilies.get((int) (Math.random() * fontFamilies.size()));
        studentNameLabel.setFont(new Font(randomFontFamily, 48));

        FlowPane buttonToolbar = new FlowPane();
        buttonToolbar.setAlignment(Pos.CENTER);
        buttonToolbar.getChildren().add(prevButton);
        buttonToolbar.getChildren().add(pickButton);
        buttonToolbar.getChildren().add(nextButton);

        currentIndex = pickRandomIndex();
        String startingStudent = students.get(currentIndex);
        studentNameLabel.setText(startingStudent);

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(buttonToolbar);
        root.getChildren().add(studentNameLabel);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);

        EventHandler buttonsHandler = (EventHandler<ActionEvent>) (ActionEvent event) -> {
            Task<Void> task = new Task<Void>() {
                @Override
                @SuppressWarnings({"CallToPrintStackTrace", "SleepWhileInLoop"})
                protected Void call() throws Exception {
                    int maxCount = 1;
                    if (event.getSource() == pickButton)
                        maxCount = 15;
                    for (int i = 0; i < maxCount; i++) {
                        if (event.getSource() == prevButton) {
                            currentIndex -= 1;
                            if (currentIndex < 0) {
                                currentIndex = students.size() - 1;
                            }
                        } else if (event.getSource() == nextButton) {
                            currentIndex += 1;
                            if (currentIndex > students.size()-1) {
                                currentIndex =  0;
                            }
                        } else {
                            currentIndex = pickRandomIndex();
                        }

                        // asynchronous call via multithreading
                        Platform.runLater(() -> {
                            String student = students.get(currentIndex);
                            studentNameLabel.setText(student);
                        });

                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException ie) {
                            ie.printStackTrace();
                        }
                    }
                    return null;
                }
            };
            // THIS GETS THE THREAD ROLLING
            Thread thread = new Thread(task);
            thread.start();
        };

        // REGISTER THE LISTENER WITH ALL 3 BUTTONS
        prevButton.setOnAction(buttonsHandler);
        pickButton.setOnAction(buttonsHandler);
        nextButton.setOnAction(buttonsHandler);

        // OPEN THE WINDOW
        primaryStage.show();
    }

    public int pickRandomIndex() {
        // RANDOMLY SELECT A STUDENT
        int randomIndex = (int) (Math.random() * students.size());
        return randomIndex;
    }

    // LOADS A JSON FILE AS A SINGLE OBJECT AND RETURNS IT
    private JsonObject loadJSONFile(String jsonFilePath) throws IOException {
        JsonObject json;
        try (InputStream is = new FileInputStream(jsonFilePath);
                JsonReader jsonReader = Json.createReader(is)) {
            json = jsonReader.readObject();
        }
        return json;
    }

    /**
     * This starts our JavaFX application rolling.
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
