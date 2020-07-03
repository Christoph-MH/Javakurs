package de.wbs.io;

import java.io.*;

public class PersonSpeichern {
    public static void main(String[] args) {
        File file=new File("g:/javademo/MyObj.ser");
        Person p=new Person("Christoph");
        System.out.println("Der Name lautet: "+p.getName());
        FileOutputStream fos=null;
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(p);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
