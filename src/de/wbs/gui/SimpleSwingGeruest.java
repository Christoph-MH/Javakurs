package de.wbs.gui;

import javax.swing.*;
import java.awt.*;

public class SimpleSwingGeruest extends JFrame {    // JFrame, das Fenster auf dem gearbeitet wird
    // Hauptfenster wird nur einmal gestartet

    public SimpleSwingGeruest() {
        super("Swing-Gerüst");
        JLabel label = new JLabel("Hallo Welt!");
        this.add(label);
        this.add(new JLabel("War of the worlds"));
    }

    public static void main(String[] args) {
        JFrame rahmen = new SimpleSwingGeruest();
//        rahmen.setLocationRelativeTo(null); // immer in der Mitte des Hauptbildschirms
        rahmen.setLocation(2421,512);
        rahmen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Wenn ich Frame schließe, dann Programm beenden
        rahmen.pack();
        rahmen.setVisible(true);
    }
}
