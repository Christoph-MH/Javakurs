package de.wbs.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VerzeichnisseAnlegen {
    public static void main(String[] args) {
        Path path = Paths.get("G:/javademo");

        if (Files.exists(path)) {    // Wenn path nicht existiert passiert nichts!
            try {
                if (!Files.exists(path.resolve("Verzeichnis"))) {

                    Files.createDirectory(path.resolve("Verzeichnis"));
                }
                if (!Files.exists(path.resolve("OrdnerA/OrdnerB"))) {
                    Files.createDirectories(path.resolve("OrdnerA/OrdnerB"));   // Files.createDirectories() mehrere Dir erstelle
                }

                Files.createFile((path.resolve("Verzeichnis").resolve("Daten.txt"))); // Wenn existiert auch If Bedingung
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
