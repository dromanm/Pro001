package homeWork01.start;

import homeWork01.controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Prigovor on 24.12.2016.
 */
public class Main  extends Application {

    private static final Locale DEFAULT_LOCALE = new Locale("ru");

    @Override
    public void start(Stage primaryStage) throws Exception {

        Locale.setDefault(DEFAULT_LOCALE);

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/homeWork01/fxml/MainFXML.fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("homeWork01.bundles.Locale"));

        Parent fxmlMain = fxmlLoader.load();
        MainController mainController = fxmlLoader.getController();
        mainController.setMainStage(primaryStage);

        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(fxmlMain , 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
