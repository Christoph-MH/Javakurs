package de.wbs.threads;

public class MyJoin {
    static String name=null;

    public static void main(String[] args) {
        Thread t=new Thread(()->{
//        new Thread(()->{    // wenn wir auf diesen nicht nochmal zugreifen wollen
            try {
                Thread.sleep(2000);
                Thread.currentThread().interrupt(); // bewirkt hier nichts, nur Flag
                name="Christoph";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        }).start();   //siehe oben
        });
        t.start();
        try {
            t.join(100);    // warten mit dem joinen nicht so lange, wie Prozess benötigt.2100 gibt Christoph aus
            Thread.currentThread().interrupt(); // bewirkt hier nichts
            if (name==null){
                name="DefaultInfo";
            }
            System.out.println(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(name); // ohne join...

    }
}
