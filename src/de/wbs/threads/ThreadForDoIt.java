package de.wbs.threads;

public class ThreadForDoIt {

    public static void main(String[] args) {
        Runnable r  = new DoIt();
        Thread   t  = new Thread(r, "Worker 1 "); // Prozess der die übergebenen Prozesse abarbeitet
        Thread   t2 = new Thread(r, "Worker 2 "); // r ist der abzuarbeitetende Prozess
        t.setPriority(Thread.MIN_PRIORITY);            // Priorität für Thread, aber wg  mehrkern keine Notwendigkeit mehr
        t2.setPriority(Thread.MAX_PRIORITY);
        t.start();      // startet eigenen Prozess,  run ist zwar ausführbar aber kein Prozess!!
        t2.start();
//        t2.join();

    }
}
