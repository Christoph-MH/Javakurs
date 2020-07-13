package de.wbs.nio;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteInG {
    public static void main(String[] args) {
        Path file = Paths.get("G:/javademo","Verzeichnis","Daten.txt");
        String info="Ein String, um in die Dateien geschrieben zu werden\n";
        List<String> zeilen=new ArrayList<>();
        try {
            Files.write(file, Collections.singleton(info),StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.write(file, info.getBytes(),StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i=00;i<11;i++){
            zeilen.add("Zeile "+i);
        }
        try {
            Files.write(file, info.getBytes(),StandardOpenOption.APPEND);
            Files.write(file,zeilen, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
    }
        try {
            for (String line:Files.readAllLines(file)){     // ganze Datei auslesen
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}}
