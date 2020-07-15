package de.wbs.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket client = new Socket("localhost", 1234); //socket braucht den Hostnamen und den Port
             InputStream in = client.getInputStream();
             OutputStream out = client.getOutputStream();) {
            System.out.println("an: " + client.getInetAddress());
            System.out.println("von Clientport: " + client.getLocalPort());
            System.out.println(" an ServerPort: " + client.getPort());
            out.write(127);
            System.out.println(in.read());  // wenn leer, dann -1
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

