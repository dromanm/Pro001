package hw6.notes;

import hw6.notes.util.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by eriol4ik on 02/02/2017.
 */
public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/main.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Notebooks");
        Scene main = new Scene(root);
        primaryStage.setScene(main);
        primaryStage.show();
    }

    @Override
    public void stop() {
        HibernateUtil.getSessionFactory().close();
    }
}
