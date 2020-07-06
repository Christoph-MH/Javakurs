package de.wbs.io;

import java.io.*;

public class WriteInfoFile {
    public static void main(String[] args) {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in)); // von Ta<ytatur einlesen

        File file =new File("G:/javademo/Text.txt");
        try(BufferedWriter output=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true)))) {
            // mit true wird weiter geschrieben
            String str = null;
            do{
                System.out.println("Hey, tipp mal was ");
                str=input.readLine();
            output.write(str);
            output.newLine();
            if(true)throw new IOException();
            output.flush();     // alles ausleeren

        }while (str.length()>0);    // läuft solange Zeichen übergeben werden



        }catch (FileNotFoundException e){
            e.printStackTrace();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
