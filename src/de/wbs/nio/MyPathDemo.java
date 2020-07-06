package de.wbs.nio;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class MyPathDemo {
    public static void main(String[] args) {
        FileSystem fs = FileSystems.getDefault();

        Path path = fs.getPath("G:/", "Frank", "/StartProjekt/fileundio");
        System.out.println(path.toAbsolutePath());
        System.out.println(path.toUri());   // uri/url: unified l=locator, i=identifier
        path = fs.getPath("G:/", "Frank", "/StartProjekt", "\\fileundio");
        System.out.println(path.toAbsolutePath());
        System.out.println(path.toUri());
        System.out.println("---------- im aktuellen Pfad ------------");
        path = fs.getPath(( "src" ));
        System.out.println(path.toAbsolutePath());
        Path path2 = path.resolve("de");
        System.out.println(path2.toAbsolutePath());
        path2 = path.resolve("com");  // com ist nicht vorhanden, ist nur im Speicher - zum Erstellen?
        System.out.println(path2.toAbsolutePath());
        System.out.println("\n-------------C:\\Users\\User\\IdeaProjects\\Javakurs\\src------------");
        Path pathParent = path2.getParent();
        System.out.println(pathParent.toAbsolutePath());
        System.out.println(pathParent.getNameCount());
        System.out.println("\n____________________________________ FranksVerzeichnis---------------");
        path = fs.getPath("G:/", "Frank", "/StartProjekt/fileundio");
        System.out.println(path.toAbsolutePath());
        System.out.println("----------------------------");
        System.out.println(path.getNameCount());

        path2 = path.getName(2).resolve("Gui");   // 0= "Frank", 1=StartProjekt, 2=fileundio
        System.out.println(path2);
        System.out.println(path2.getParent());
        System.out.println(path2.toAbsolutePath());
        path = fs.getPath("G:/", "Frank", "/StartProjekt/fileundio");
        System.out.println(path.toAbsolutePath());
        System.out.println("----------------------------");
        System.out.println(path.getNameCount());

        Path path3 = path.getName(0).resolve("Gui");   // 0= "Frank", 1=StartProjekt, 2=fileundio
        System.out.println(path3);
        System.out.println(path3.getParent());
        System.out.println(path3.toAbsolutePath());

    }
}
