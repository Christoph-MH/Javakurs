package de.wbs.nio;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FirstNio {
    public static void main(String[] args) {
        // Kein File Objekt,sondern Pfadobjekt vs java.io
        FileSystem fs= FileSystems.getDefault();    // FileSystems, nicht FileSystem!!
//        System.out.println(fs.getPath("G:/"));
        for (Path p:fs.getRootDirectories()){
            System.out.println(p.getFileName());
            System.out.println(p);
            System.out.println(p.toUri());      // file:///C:/
            System.out.println(p.toAbsolutePath());
            try {
                System.out.println(p.toRealPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("------------ Nun die FileStores: ---------------------");
        for(FileStore fstore:fs.getFileStores()){
            try {
                System.out.println("Name: "+fstore.name()+" Type: "+ fstore.type()+" Speicher: "+fstore.getUsableSpace());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
