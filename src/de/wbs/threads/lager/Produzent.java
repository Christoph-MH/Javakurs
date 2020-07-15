package de.wbs.threads.lager;

public class Produzent implements Runnable{

    Lager l;

    ThreadGroup tg;
    public Produzent(Lager l, ThreadGroup tg){
        this.l=l;
        this.tg=tg;
    }

    @Override
    public void run() {

        synchronized (l) {
            while(l.getValue()!=null) {   // wenn etwas drinsteht im value des Lagers soll Produzent warter
                try {
                    l.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            l.setValue("Hallo ");   // wird ins Lager geschrieben
            // ein Produzent, mehrere Verbraucher
            // Wenn Verbraucher Arbeit erledigt:
            l.notify();     // nur ein Produzent, bei mehreren ein notifyAll
        }

    }
}
