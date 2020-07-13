package de.wbs.threads;

public class FirstThread extends Thread{
    public FirstThread(){
        super();
    }
    public FirstThread(String first){
        super(first);
    }
    public FirstThread(Runnable target){
        super(target);
    }
    public FirstThread(Runnable target, String name){
        super(target,name);
    }

    public static void main(String[] args) {
        Thread t=new FirstThread();
        System.out.println(Thread.currentThread().getName());   // main (HauptThread)
        System.out.println("Erster StateAufruf: "+t.getState());    // t State=  NEW
        t.run();
        System.out.println("Zweiter StateAufruf: "+ t.getState());
        t.start();
        System.out.println("Dritter StateAufruf: "+ t.getState());
    }


    // benötigt run Methode da thread erweitert
    public void run(){
        System.out.println("\tState in Run \t" +getState());
        System.out.println("\tThread in Run \t" +Thread.currentThread().getState()); // currentThread; um auf den aktuellen
        // Thread zu schauen  +  native
        System.out.println("\tgetName in Run \t" +getName());
    }

}
