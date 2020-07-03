package de.wbs.io;

import java.io.*;

public class PersonLesen {

    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(new File("G:/javademo/MyObj.ser"))
        )) {
            Object o = ois.readObject();
            if (o instanceof Person) {
                Person p = (Person) o;
                System.out.println(p.getName());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
