package w6.task2;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Created by Bohdan on 28.01.2017.
 */
public class View
{
    private GridPane gridPane = new GridPane();

    private Label label = new Label();

    private Button buttonStart = new Button();
    private Button buttonPause = new Button();

    private Controller controller;

    public View(Controller controller)
    {
        this.controller = controller;
        init();
    }

    public Parent getParent()
    {
        return gridPane;
    }

    public Label getLabel()
    {
        return label;
    }

    public Button getButtonStart()
    {
        return buttonStart;
    }

    public Button getButtonPause()
    {
        return buttonPause;
    }

    public void init()
    {
        label.setAlignment(Pos.CENTER);
        label.setMinSize(120, 30);

        buttonStart.setAlignment(Pos.CENTER);
        buttonStart.setMinSize(120, 30);
        buttonStart.setText("Start");

        buttonStart.setOnAction(event ->
        {
            controller.start();
        });

        buttonPause.setAlignment(Pos.CENTER);
        buttonPause.setMinSize(120, 30);
        buttonPause.setText("Pause");
        buttonPause.setDisable(true);

        buttonPause.setOnAction(event ->
        {
            controller.pause();
        });

        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(label, 0, 0);
        gridPane.add(buttonStart, 0, 1);
        gridPane.add(buttonPause, 0, 2);

        gridPane.setHgap(10);
        gridPane.setVgap(10);
    }
}
