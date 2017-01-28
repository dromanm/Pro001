package lesson09_threads;

import java.util.Random;

/**
 * Created by IEvgen Boldyr on 28.01.17.
 */

public class ThreadGroupsEx {

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("MAIN GROUP");

        for (int i = 0; i < 100; i++) {
            Thread thr = new Thread(group, new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.currentThread().sleep(
                                new Random().nextInt(20000));
                        System.out.println(
                                Thread.currentThread().getName()
                                        + " завершил работу! "
                        );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thr.setDaemon(true);
            thr.start();
        }

        while (group.activeCount() > 0) {
            Thread.currentThread().sleep(1000);
            System.out.println("В работе: "
                    + group.activeCount()
                    + " потоков. " );
        }
    }
}
