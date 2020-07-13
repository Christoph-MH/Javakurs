package de.wbs.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.spi.FileSystemProvider;
import java.util.HashMap;
import java.util.Map;

public class MyDirectories {

    public static void main(String[] args) {
        Path path = Paths.get(System.getProperty("user.home"));

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(path)) {
            for (Path dir : dirs) {
                if (Files.isDirectory(dir)) {
                    System.out.println( dir);       // Verzeichnis
                } else {
                    System.out.println("Datei: " + dir);    // Datei
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("___________________________________________");
        System.out.println("Ausgabe mit FileVisitor: ");

        try {
            path = Paths.get("G:/javademo");
            for (FileSystemProvider provider : FileSystemProvider.installedProviders()) {
                System.out.println(provider);
            }
            FileSystemProvider provider = FileSystemProvider.installedProviders().get(0);
            FileSystem         fs       = provider.newFileSystem(path, new HashMap<String, String>());

            Files.walkFileTree(fs.getPath("/"), new FileVisitor<Path>() {
                String str = "";

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println(str + dir);
                    str += "-";
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("Eine Datei mit Namen: " + file.getFileName());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.SKIP_SUBTREE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    str = str.substring(0, str.length() - 1);
                    return FileVisitResult.CONTINUE;
                }
            });      // Verzeichnisbaum durchwandern
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
