package de.wbs.nio;

import java.io.IOException;
import java.nio.file.*;

public class MyWatchService {

    public static void main(String[] args) {
        // beobachten was in einem Verzeichnis passiert
        try {
            WatchService watcher= FileSystems.getDefault().newWatchService();
            Path path= Paths.get("G:/javademo", "Verzeichnis");
            Path path1=Paths.get("G:/javademo","javademo_sub");
            path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_DELETE,
                          StandardWatchEventKinds.ENTRY_MODIFY);
            path1.register(watcher, StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_DELETE,
                           StandardWatchEventKinds.ENTRY_MODIFY);

            while (true){
                WatchKey key=watcher.take();

                for (WatchEvent<?> event:key.pollEvents()){
                    System.out.println(event.kind() + " : "+event.context());
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
