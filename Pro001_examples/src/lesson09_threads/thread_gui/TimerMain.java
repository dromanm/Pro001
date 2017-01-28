package lesson09_threads.thread_gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by IEvgen Boldyr on 28.01.17.
 */

public class TimerMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(
                getClass().getResource(
                        "/lesson09_threads/thread_gui/exam_main.fxml"));
        primaryStage.setTitle("Timer");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
