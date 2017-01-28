package lesson09_threads;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Created by IEvgen Boldyr on 28.01.17.
 */
public class SyncThreadsExam {

    private static Queue<Integer> queue;

    public static void main(String[] args) {
        queue = new PriorityQueue<>();

        for (int i = 0; i < 5; i++) {
            Thread thr = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        Random rm = new Random();
                        try {
                            Thread.currentThread().sleep(rm.nextInt(10000));
                            queue.offer(rm.nextInt(100));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thr.start();
        }

        Thread getter = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (queue.size() > 0) {
                        System.out.println("GET Element : " + queue.poll());
                        try {
                            Thread.currentThread().sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        getter.start();

    }


}
