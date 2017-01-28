package lesson09_threads;

import lesson09_threads.threads.MyThread;

/**
 * Created by IEvgen Boldyr on 28.01.17.
 */

public class CreationThreadEx {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Запуск главного потока ");

        Thread thread = new MyThread();
        thread.setDaemon(true); //Делаем поток системным/служебным
        thread.start();

        //Thread.currentThread().sleep(4000);
        System.out.println("Завершение работы главного потока");
    }
}
