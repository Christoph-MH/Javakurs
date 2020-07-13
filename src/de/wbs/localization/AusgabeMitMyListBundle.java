package de.wbs.localization;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class AusgabeMitMyListBundle {

    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("de.wbs.resources.MyListBundle",Locale.US);
        System.out.println(rb.getString("wert"));
//        System.out.println(rb.getString("zahl")); // Fehler weil Integer vorlieget
        System.out.println((Integer) rb.getObject("zahl") + 2);
        if (rb.containsKey("array")) {                                      // prüfen ob key vorhanden
            String[] werte = (String[]) rb.getObject("array");
            for (String val : werte) {
                System.out.println(val);
            }
        }
        // rb.getKeys();    //liefert enumeration
        System.out.println("___________ enumeration -----------------");
        Enumeration<String> en=rb.getKeys();
        while (en.hasMoreElements()){
            System.out.println(en.nextElement());
        }
    }
}
