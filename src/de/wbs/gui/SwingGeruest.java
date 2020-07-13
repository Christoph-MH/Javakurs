package de.wbs.gui;

import javax.swing.*;
import java.awt.*;

public class SwingGeruest {

    private static void createAndShowGui() {
        JFrame.setDefaultLookAndFeelDecorated(true);    // altes Java default GUI
        JFrame frame=new JFrame("Swing-Gerüst");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label=new JLabel(" Wieder ein neues Fenster");
        frame.getContentPane().setLayout(new FlowLayout()); // zweites Label zentriert
        frame.getContentPane().add(label);
        frame.getContentPane().add(new JLabel("und ein weiteres Label"));
        frame.getContentPane().add(new JLabel("und ein weiteres Labell sfdlgkädföjgänjsrgläknnf-lkgn-sdlkfng-lksdn"));
//        JPanel panel=new JPanel(new FlowLayout());
//        panel.add(label);
//        panel.add(new JLabel("Noch ein Text"));
//        frame.setContentPane(panel);

        frame.setSize(640,480);
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(2421,312);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(()->createAndShowGui());   //reiht den Prozess in die Queue ein, wo das ganze ausgeführt wird

    }
}
