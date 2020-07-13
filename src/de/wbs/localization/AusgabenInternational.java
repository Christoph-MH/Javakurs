package de.wbs.localization;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class AusgabenInternational {
    public static void main(String[] args) {
        //        Locale.setDefault(new Locale("hi","In"));
        //      Locale.setDefault(Locale.US);
        System.out.println("Sprache auf diesem System: ");
        System.out.println(Locale.getDefault().getDisplayLanguage());
        Locale.setDefault(new Locale("de", "ch"));
//        System.out.println(Locale.getDefault().getDisplayLanguage());
        Locale.setDefault(new Locale("en", "US"));
        ResourceBundle rb = ResourceBundle.getBundle("de.wbs.resources.hello"); // sind im Sourcen Ordner
        Calendar       c  = Calendar.getInstance();
        Date           d  = c.getTime();
        System.out.println(d);

        DateFormat df = DateFormat.getDateInstance();
        System.out.println(df.format(d));

        double wert = 123_456.2346;

        System.out.println(wert);
        System.out.println(NumberFormat.getInstance().format(wert));
        System.out.println("_________________ WÄhrung -------------");
        System.out.println(NumberFormat.getCurrencyInstance().format(wert));

// Spracheinstellungen bzw angepasste Texte in resources
        System.out.println("_____________ Ausgabe der eingestellten Texte (resources) in der gewählten Sprache ");
        System.out.println("Hello WelT");
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("appName"));
        System.out.println(rb.getString("more"));
        System.out.println(rb.getString("test"));
        System.out.println(rb.getString("notranslation"));
        System.out.println(rb.getString("analog"));
        System.out.println(rb.getString("deutsch"));

        char mv='m';
        String anrede=null;
        String name="Sloma";
        if (mv=='m'){
            anrede=rb.getString("mr");
        }else{
            anrede=rb.getString("mrs");
        }
        String output= MessageFormat.format(rb.getString("sayHello"),anrede,name);
        System.out.println(output);
    }
}
