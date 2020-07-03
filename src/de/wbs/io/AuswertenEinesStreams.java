package de.wbs.io;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AuswertenEinesStreams {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner("ein 0.123 Inhalt 12 Werte 23 true 12,56");  // soll der Reihe nach ausgelesen werden
        Scanner scanner2 = new Scanner("ein,0.123,Inhalt,12,Werte,23,true,12.56");  // delimeter ändern:

        scanner.useLocale(Locale.ENGLISH);
        scanner2.useLocale(Locale.GERMAN);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int wert1 = scanner.nextInt();
                System.out.println(" Wert1: " + wert1);

            } else if (scanner.hasNextDouble()) {
                double wert3 = scanner.nextDouble();
                System.out.println(" Wert3 double: " + wert3);
            } else if (scanner.hasNextBoolean()) {
                boolean bool = scanner.nextBoolean();
                System.out.println(" bool: " + bool);
            } else {
                System.out.println("String gefunden: " + scanner.next());
            }
        }
        System.out.println("________________ anderer Delimiter ',' ------------");
        scanner2.useDelimiter(",");
        if(",".equals(Pattern.compile(",").pattern())) {    // zur double Erkennung
            scanner2.useLocale(Locale.ENGLISH);
        }
        while (scanner2.hasNext()) {

            if (scanner2.hasNextInt()) {
                int wert1 = scanner2.nextInt();
                System.out.println(" Wert1: " + wert1);

            } else if (scanner2.hasNextDouble()) {
                double wert3 = scanner2.nextDouble();
                System.out.println(" Wert3 double: " + wert3);
            } else if (scanner2.hasNextBoolean()) {
                boolean bool = scanner2.nextBoolean();
                System.out.println(" bool: " + bool);
            } else {
                System.out.println("String gefunden: " + scanner2.next());
            }
        }

    }
}
