package w6.task1.thread;

/**
 * Created by Bohdan on 28.01.2017.
 */
public class Main
{
    /*
    * Состояния потоков
    * 1). Только созданный
    * 2). Выполняемый (после старта)
    * 3). Приостановленный (в ожидании)
    * 4). Выполнен
    *
    * Runnable использует меньше ресурсов
    * Thread используется при необходимости использования большего кол-ва ф-онала
     */

    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Main thread starting");
        new ThreadSample().start();
        Thread.currentThread().sleep(4000);
        System.out.println("Main thread stopping");
    }
}
