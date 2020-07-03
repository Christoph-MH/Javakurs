package de.wbs.io;

import java.io.*;

public class LeseFehlerDatei {
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
        BufferedReader br = new BufferedReader(isr);

        String line = null;
        try {
//            br.mark(100);
            while (( line = br.readLine() ) != null) {
//                br.mark(5);
                System.out.println(line);
            }
            System.out.println(br.readLine());  // liefert null zurück
            System.out.println("br.markSupported:\t" + br.markSupported());

//            br.reset(); // Marke setzen, muss vor reset passieren
            System.out.println("br.readLine:\t"+br.readLine());
        } catch (IOException e) {
            e.printStackTrace();

        }
        finally{
            try {
                br.close();             // Stream schließen
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
