package w6.task2;

import javafx.application.Platform;

import static java.lang.Thread.sleep;

/**
 * Created by Bohdan on 28.01.2017.
 */
public class Controller
{
    private View view = new View(this);

    private volatile int counter = 0;
    private Thread thread;

    public View getView()
    {
        return view;
    }

    public void start()
    {
        view.getButtonStart().setDisable(true);
        view.getButtonPause().setDisable(false);

        thread = new Thread(() ->
        {
            while (counter < 100 && !thread.isInterrupted())
            {
                try
                {
                    sleep(1000);
                    Platform.runLater(() -> view.getLabel().setText(String.valueOf(++counter)));
                }
                catch (InterruptedException e)
                {
                    thread.interrupt();
                }
            }
        });

        thread.setDaemon(true);
        thread.start();
    }

    public void pause()
    {
        view.getButtonPause().setDisable(true);
        view.getButtonStart().setDisable(false);
        thread.interrupt();
    }
}
