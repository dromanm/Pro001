package com.hibernate.homework.menu;

import com.hibernate.homework.menu.observe.ObserveMenuController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Bohdan on 03.02.2017.
 */
public class Main extends Application
{
    private Stage primaryStage;

    private static Main instance;

    public static Main getInstance()
    {
        return instance;
    }

    public Main()
    {
        instance = this;
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.primaryStage = primaryStage;

        replaceSceneContent(new ObserveMenuController());
        primaryStage.setTitle("Title");
        primaryStage.show();
    }

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
        primaryStage.setMaximized(true);
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
