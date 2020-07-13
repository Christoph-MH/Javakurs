package de.wbs.threads;

public class DoIt implements Runnable {
    @Override
    public void run() {
        System.out.println("Info aus Runnable (DoIt)");
        System.out.println(Thread.currentThread().getName());

    }
}
