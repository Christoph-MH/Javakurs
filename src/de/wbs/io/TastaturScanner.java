package de.wbs.io;

import java.util.Scanner;

public class TastaturScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte Vorname");
        String namer = scanner.next();
        System.out.println(namer);
        while (scanner.hasNext()){
            System.out.println(scanner.next());
            System.out.println("next: name");
        }
        System.out.println("Alter");

        int alter = scanner.nextInt();   // radix =Zahlensystem
        if (scanner.hasNextInt()) {
            System.out.println("Rentenbegin in " + ( 68 - alter ) + " Jahren");
        } else {
            System.out.println("Falscher Wert: " + scanner.next());
        }

    }
}
