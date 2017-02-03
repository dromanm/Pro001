package w6.task2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Bohdan on 28.01.2017.
 */
public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setScene(new Scene(new Controller().getView().getParent()));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
