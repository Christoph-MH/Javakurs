package de.wbs.threads.counter;

public class CounterDemo {
    public static void main(String[] args) {


        Counter count = new Counter();
        Runnable add = new Addiere(count);
        Runnable sub = new Subtrahiere(count);
        Thread addiere = new Thread(add);
        Thread subtrahiere = new Thread(sub);
        addiere.start();
        subtrahiere.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count.getCount());

    }
}
