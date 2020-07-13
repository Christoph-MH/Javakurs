package de.wbs.localization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AusgabeMitMyProps {

    public static void main(String[] args) {
        try {
            FileInputStream in =new FileInputStream("src/de/wbs/resources/hello.properties");
            MyProps props=new MyProps(in);
            System.out.println(props.getString("hello"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
