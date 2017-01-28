package lesson09_threads.threads;

/**
 * Created by IEvgen Boldyr on 28.01.17.
 */

public class MyThread extends Thread {

    public MyThread() {
        System.out.println("1. Поток создан, но ожидает" +
                " выполнения");
    }

    @Override
    public synchronized void start() {
        System.out.println("2. Поток запущен");
        super.start();
    }

    @Override
    public void run() {
        System.out.println("3. Процесс выполнения кода");
        try {
            currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("MyThread Example");
        Thread thread = new Thread(new RunableEx());
        thread.start();

        try {
            currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("4. Код выполнен, поток " +
                " прекращает свою работу");
    }
}
