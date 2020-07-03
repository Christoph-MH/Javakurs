package de.wbs.io;

import java.io.*;

public class LeseFehlerDateiNeu {
    static File log = new File("G:/javademo/error.log");

    public static void main(String[] args) {
        File            log = new File("G:/javademo/error.log");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(log);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader isr = new InputStreamReader(fis);   // wir wollen Zeichenorientiert arbeiten
        // Zeilenweise arbeiten:


        String line = null;
        try ( BufferedReader buff = new BufferedReader(isr)
        ){
//            br.mark(100);
            while (true) {
                if((line = buff.readLine()) == null) break;
//                if(!(( line = buff.readLine())  != null)) break; // doppelte Negation??
//                br.mark(5);
                System.out.println(line);
            }
            System.out.println(buff.readLine());  // liefert null zurück
            System.out.println("buff.markSupported:\t" + buff.markSupported());

//            br.reset(); // Marke setzen, muss vor reset passieren
            System.out.println("buff.readLine:\t" + buff.readLine());
        } catch (IOException e) {
            e.printStackTrace();

        }
//        finally {
//            try {
//                buff.close();             // Stream schließen
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
