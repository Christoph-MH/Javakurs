package de.wbs.threads.lager;

import org.jetbrains.annotations.Contract;

public class Verbraucher implements Runnable {

    Lager l;


    @Contract(pure = true)
    public Verbraucher(Lager l) { this.l = l;  }   // Brauchen immer das Objekt..


    @Override
    public void run() {
        // wie gewähleiste ich, das sich ein Objekt im Lager befindet?
        synchronized (l) {
            while (l.getValue() == null) {
                try {
                    l.wait();       // warte bis was im Lager drin ist
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String str = l.getValue();
            l.setValue(null);
            System.out.println(Thread.currentThread().getName() + " " + str);
            l.notifyAll();  // Ich habe fertig, andere Verbraucher können was machen
        }

    }
}
