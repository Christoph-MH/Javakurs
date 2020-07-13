package de.wbs.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;

public class Attribute {
    public static void main(String[] args) {
        Path source = Paths.get("G:/javademo", "Verzeichnis", "Daten.txt");
        Path file=Paths.get("G:/javademo", "Verzeichnis", "neuDaten.txt");

        try {
            BasicFileAttributes basicAttributes = Files.readAttributes(file, BasicFileAttributes.class);
            System.out.println("Datei wurde  erstellt um "+basicAttributes.creationTime());
            System.out.println("Datei wurde  modifiziert um "+basicAttributes.lastModifiedTime());

            // nur Windows!!
            DosFileAttributes dosAttributes =Files.readAttributes(file,DosFileAttributes.class);
            System.out.println(dosAttributes.isHidden());

            // nur Linux
//            PosixFileAttributes posixAttributes =Files.readAttributes(file,PosixFileAttributes.class);
//            System.out.println(posixAttributes.owner());
            DosFileAttributeView forChange=Files.getFileAttributeView(file,DosFileAttributeView.class);
            System.out.println("_____________");
            forChange.setHidden(true);
            System.out.println(dosAttributes.isHidden());
            System.out.println("_______________");
            System.out.println(forChange.readAttributes().isHidden());
            System.out.println(dosAttributes.lastModifiedTime());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
