package de.wbs.io;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person extends Parent implements Serializable {
    // private static final long serialVersionUID = 2787123L;

    private           String  name;
    private           Integer myInt = 55;
    private transient Adress  adress;  // transient machen, damit Problem serialiaz wird?!
    private transient String  pwd   = "leer";  //transient schliesst pwd von Serializing aus,
    private transient int     age;

    public Person(String name, String firstName) {
        super(firstName);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Adress getAdress()            { return adress; }

    public void setAdress(Adress adress) { this.adress = adress; }

    public String getPwd()               { return pwd; }

    public void setPwd(String pwd)       { this.pwd = pwd; }

    public int getAge()                  { return age; }

    public void setAge(int age)          { this.age = age; }

    private void writeObject(ObjectOutputStream oos) {
        try {
            oos.defaultWriteObject();   // wird vom System übergeben
            oos.writeObject("Hallo ");        // write String kennt er nicht
            oos.writeInt(age);
            oos.writeObject(adress.city);   // Attribute werden zusätzlich reingeschhrieben, damit es in Datei gespeichert
            // wird
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream ois) { // Reihenfolge in Write beachten, damit es beim read passt
        try {
            ois.defaultReadObject();
            pwd = (String) ois.readObject();  // soll ein String drin sein -> cast, pwd kann jetzt Hallo ausgeben
            age = ois.readInt();      // Alter lesen
            String tmp = (String) ois.readObject();
            setAdress(( new Adress(tmp) ));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Parent {
    String firstName = "Default";

    public Parent() {}


    public Parent(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName()               { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }


}

//class Adress implements Serializable {       // nur mit impl serial. wird ..
final class Adress {   // nicht überschreibbar und nicht serialisierbar
    String city;

    public Adress()                  {}


    public Adress(String city)       { this.city = city; }

    public String getCity()          { return city; }

    public void setCity(String city) { this.city = city; }
}