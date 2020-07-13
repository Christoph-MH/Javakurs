package de.wbs.nio;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo2 {
    public static void main(String[] args) {
        Path path = Paths.get("G:", "javademo", "StartProjekt", "src", "fileundio");
        System.out.println(path.toAbsolutePath());
        System.out.println("____ __________");
        System.out.println(path.resolve("src"));
        System.out.println(path.resolve("src").toAbsolutePath());
        System.out.println("______________ ________________");
        System.out.println(path.getName(1));
        System.out.println(path.getName(1).resolve("bin"));
        System.out.println("_____________________aktuelles Arbeitsverzeichnis + StartProjekt/bin");
        System.out.println(path.getName(1).resolve("bin").toAbsolutePath());
        System.out.println(path.toAbsolutePath());
        System.out.println("_______________for____________");
        System.out.println(path.getNameCount());
        System.out.println(path.getName(3) + " : " + path.getName(3).toAbsolutePath()); // Zählen von 0..3 => 4 Pfadteile
        for (int i = path.getNameCount() - 1; i >= 0; i--) {
            System.out.println(path.getName(i) + " : " + path.getName(i).toAbsolutePath());
        }
        System.out.println("_____________  gewünschte Nutzung__________");
        Path home=Paths.get(System.getProperty("user.home"));
        System.out.println(home.toAbsolutePath());
        System.out.println(home.getName(0).resolve("Docs").toAbsolutePath());
//        try {
//            System.out.println(home.getName(0).resolve("Docs").toRealPath(LinkOption.NOFOLLOW_LINKS));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
