package de.wbs.nio;

import java.io.IOException;
import java.nio.file.*;

public class CopyAndMove {
    public static void main(String[] args) {
        Path source = Paths.get("G:/javademo", "Verzeichnis", "Daten.txt");
        Path source1 = Paths.get("G:/javademo/Verzeichnis/Daten.txt");
        Path target = Paths.get("G:/javademo", "Verzeichnis", "DatenKopie.txt");

        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING,StandardCopyOption.COPY_ATTRIBUTES);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Path moveTo=Paths.get("G:/javademo", "Verzeichnis", "neuDaten.txt");
//        try {
//            Files.move(target,moveTo);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println(source);
    }
}
