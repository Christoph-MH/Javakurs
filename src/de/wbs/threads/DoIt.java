package de.wbs.threads;

public class DoIt implements Runnable {
    @Override
    public void run() {
        System.out.println("Info aus Runnable (DoIt)");
        System.out.println(Thread.currentThread().getName());

        int i=0;

        while(i++<30){
            long start = System.currentTimeMillis();
            try {
                if (Thread.currentThread().getName().equals("Worker 1 ")){
                    Thread.yield(); // eigenständig nach runable und anderm Prozess Priority gewähren,  Prozessorzeit abgeben
                }
                Thread.sleep(100); // während Prozess schläft, kommt anderer Prozess, dann Exception
                long stop=System.currentTimeMillis();
                System.out.println(i+":"+Thread.currentThread().getName()+" time: "+(stop-start));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
