package w6.task1.thread;

/**
 * Created by Bohdan on 28.01.2017.
 */
public class ThreadSample extends Thread
{
    public ThreadSample()
    {
        System.out.println("Thread is created. First stage");
    }

    @Override
    public void run()
    {
        System.out.println("Thread is running. Second stage");
        try
        {
            currentThread().sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("Operating");
        try
        {
            currentThread().sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("Thread stopped. Fourth stage");
    }
}
