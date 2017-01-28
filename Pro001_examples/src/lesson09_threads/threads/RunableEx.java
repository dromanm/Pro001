package lesson09_threads.threads;

/**
 * Created by IEvgen Boldyr on 28.01.17.
 */
public class RunableEx implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Runnable start");
            Thread.currentThread().sleep(5000);
            System.out.println("Runnable example");
            Thread.currentThread().sleep(5000);
            System.out.println("Runnable stop");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
