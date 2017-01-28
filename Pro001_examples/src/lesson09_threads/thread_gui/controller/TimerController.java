package lesson09_threads.thread_gui.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by IEvgen Boldyr on 28.01.17.
 */

public class TimerController {

    private int counter;

    @FXML private Label lblTimer;

    @FXML
    public void onActionStartButton() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                counter = Integer.parseInt(lblTimer.getText());
                while (counter < 100) {
                    try {
                        Thread.currentThread().sleep(1000);
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                lblTimer.setText(Integer.toString(counter++));
                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
