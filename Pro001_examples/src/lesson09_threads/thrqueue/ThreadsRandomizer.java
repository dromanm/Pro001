package lesson09_threads.thrqueue;

/**
 * Created by IEvgen Boldyr on 24.06.16.
 * Project: OOP - Base002
 */
public class ThreadsRandomizer {

    private ThreadsRandomizer() {}

    public static void randomThread(ThreadGroup group, final Long mills) {
        Thread thread = new Thread(group, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(mills);
                    ThreadSafe safe = new ThreadSafe();
                    safe.add(Thread.currentThread().getName() + " " + mills);
                    System.out.println("ADD Log: { " +Thread.currentThread().getName() + " " + mills +" }");
                    Thread.currentThread().sleep(mills);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
