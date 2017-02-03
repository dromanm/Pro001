package w6.task4;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Bohdan on 28.01.2017.
 */
public class SynchronizeSample
{
    public static void main(String[] args)
    {
        Queue<Integer> queue = new PriorityQueue<>();

        ThreadGroup threadGroup = new ThreadGroup("MAIN");

        for (int i = 0; i < 5; i++)
        {
            Thread thread = new Thread(threadGroup, () ->
            {
                try
                {
                    Thread.currentThread().sleep(1000);
                    queue.add(new Random().nextInt(256));
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            });

            thread.start();
        }

        Thread threadGetter = new Thread(() ->
        {
            while (true)
            {
                System.out.println(queue.poll());
                try
                {
                    Thread.currentThread().sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });

        threadGetter.start();
    }
}
