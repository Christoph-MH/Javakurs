package de.wbs.threads.counter;

public class Addiere implements Runnable{

    Counter c=null;

    Addiere(Counter c){
        this.c=c;
    }

    @Override
    public void run() {
        synchronized (c) {  // ganzer synchronisierender Block wird ausgeführt
            int i = c.getCount();
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            c.setCount(i);
        }
    }
}
