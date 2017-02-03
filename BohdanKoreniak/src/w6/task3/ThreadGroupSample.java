package w6.task3;

import java.util.Random;

/**
 * Created by Bohdan on 28.01.2017.
 */
public class ThreadGroupSample
{
    public static void main(String[] args)
    {
        ThreadGroup threadGroup = new ThreadGroup("MAIN GROUP");

        for (int i = 0; i < 100; i++)
        {
            Thread thread = new Thread(threadGroup, () ->
            {
                try
                {
                    Thread.currentThread().sleep(new Random().nextInt(25000));
                    System.out.println(Thread.currentThread().getName() + " completed task");
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            });

            //thread.setDaemon(true);
            thread.start();
        }

        while (threadGroup.activeCount() > 0)
        {
            try
            {
                Thread.currentThread().sleep(1000);
                System.out.println("Works " + threadGroup.activeCount() + " threads");
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
