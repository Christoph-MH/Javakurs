package de.wbs.io;

import java.io.Console;
// Ausführung nur im Terminal möglich und dem passenden Verzeichnis der class Datei
public class MyConsole {
    static Console c=System.console(); // nicht über new erzeugt!!

    public static void main(String[] args) {
        if(c!=null){
            String user=c.readLine("User: ");
            char[]pwd=c.readPassword("Password: ");
            c.format("Hallo %s. Your password: %s",user,new String(pwd));
        }
    }
}
