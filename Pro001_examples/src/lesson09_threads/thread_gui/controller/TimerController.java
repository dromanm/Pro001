package lesson09_threads.thread_gui.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Created by IEvgen Boldyr on 28.01.17.
 */

public class TimerController {

    private int counter;
    private Thread thread;

    @FXML private Label lblTimer;
    @FXML private Button btnStart;
    @FXML private Button btnPause;

    @FXML
    public void onActionStartButton() {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                counter = Integer.parseInt(lblTimer.getText());

                btnStart.setDisable(true);
                btnPause.setDisable(false);

                while (!thread.isInterrupted()) {
                    try {
                        Thread.currentThread().sleep(1000);
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                lblTimer.setText(Integer.toString(counter++));
                            }
                        });
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    public void onActionPauseButton() {
        //Метод для приостановки выполнения потока
        thread.interrupt();
        btnStart.setDisable(false);
        btnPause.setDisable(true);
    }
}
