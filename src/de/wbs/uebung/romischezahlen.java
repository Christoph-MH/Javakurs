package de.wbs.uebung;

public class romischezahlen {

     int[] dezimalZahlen = { 1, 5, 10, 50, 100, 500, 1000 };
     String[] rom = { "I", "V", "X", "L", "C", "D", "M" };

     public static void main(String[] args) {

          String rom = "XCIVI";
          System.out.println(rom2dez(rom));
     }

     public static int rom2dez(String rom) {
          char[] a;
          a = rom.toCharArray();
          int zahl1 = 0;
          int zahl2 = 0;
          int ergebnis = 0;
          int g;
          int i = 0;

          for (g = 0; g < a.length; g++) {

                if (a[g] == 'I') {
                     zahl2 = 1;
                } else if (a[g] == 'V') {
                     zahl2 = 5;
                } else if (a[g] == 'X') {
                     zahl2 = 10;
                } else if (a[g] == 'L') {
                     zahl2 = 50;
                } else if (a[g] == 'C') {
                     zahl2 = 100;
                } else if (a[g] == 'D') {
                     zahl2 = 500;
                } else if (a[g] == 'M') {
                     zahl2 = 1000;
                }

                if (g < a.length - 1) {
                     i = g + 1;

                     if (a[i] == 'I') {
                          zahl1 = 1;
                     } else if (a[i] == 'V') {
                          zahl1 = 5;
                     } else if (a[i] == 'X') {
                          zahl1 = 10;
                     } else if (a[i] == 'L') {
                          zahl1 = 50;
                     } else if (a[i] == 'C') {
                          zahl1 = 100;
                     } else if (a[i] == 'D') {
                          zahl1 = 500;
                     } else if (a[i] == 'M') {
                          zahl1 = 1000;
                     }

                }
                if (zahl2 < zahl1) {
                     ergebnis -= zahl2;
                } else {
                     ergebnis += zahl2;
                }
          }
          return ergebnis;
     }
}    