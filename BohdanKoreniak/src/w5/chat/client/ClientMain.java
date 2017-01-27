package w5.chat.client;

import w5.chat.Controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClientMain extends Application
{
    private Stage primaryStage;

    private static ClientMain instance;

    public static ClientMain getInstance()
    {
        return instance;
    }

    public ClientMain()
    {
        instance = this;
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.primaryStage = primaryStage;

        ClientController controller = new ClientController();
        controller.run();

        if (controller.isClientConnected())
        {
            primaryStage.setTitle("Chat");
            primaryStage.show();
        }
    }

    /**
     * Replaces the application primary stage scene with view parent object taken from controller object
     */
    public void replaceSceneContent(Controller controller)
    {
        Scene scene = primaryStage.getScene();

        if (scene == null)
        {
            scene = new Scene(controller.getView().getParent());
            primaryStage.setScene(scene);
        }
        else
        {
            primaryStage.getScene().setRoot(controller.getView().getParent());
        }

        controller.getView().getParent().requestFocus();
    }

    @Override
    public void stop() throws Exception
    {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
