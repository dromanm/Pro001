package lesson09_threads.thrqueue;

import java.util.Random;

/**
 * Created by IEvgen Boldyr on 24.06.16.
 * Project: OOP - Base002
 */

public class ThreadsTest {

    public static void main(String[] args) throws InterruptedException {
        final ThreadGroup group = new ThreadGroup("MainGroup");

        final Random random = new Random();
        Thread add = new Thread(group, new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 250; i++) {
                    try {
                        Thread.currentThread().sleep(1000);
                        ThreadsRandomizer.randomThread(group,
                                new Long(5000 + random.nextInt(5000)));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        add.start();

        Thread thread = new Thread(group, new Runnable() {
            @Override
            public void run() {
                ThreadSafe safe = new ThreadSafe();
                while (true) {
                    try {
                        if (safe.size() == 0) {
                            Thread.currentThread().sleep(10000);
                        } else {
                            System.out.println("GET Log: { " + safe.get() + " }");
                            Thread.currentThread().sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

        while (group.activeCount() > 0) {
            System.out.println("********** ACTIVE THREADS : {"
                    + group.activeCount() + "} **********");
            Thread.currentThread().sleep(15000);
            if (group.activeCount() == 1) {
                break;
            }
        }
    }
}
