package ru.edu.model;

import org.junit.Test;

import java.io.*;

public class Serialization {static class Example implements Serializable {

    String a ="df";

    int b=4;

    boolean c=true;

    @Override
    public String toString() {
        return "{" +
                "a='" + a + '\'' +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    static long serialVersionUID = 1l;

}


    @Test

    public void serialization() throws Exception {

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("./output/artist_by_country.serialized"));


        Example example = new Example();

        System.out.println("exanle"+ example.toString());
        //лучше использовать готовое решение

        outputStream.writeObject(example);


        //либо свое

//        outputStream.writeUTF(example.a);
//        outputStream.writeInt(example.b);
//
//        outputStream.writeBoolean(example.c);



        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("./output/artist_by_country.serialized"));


        //лучше использовать готовое решение

        Example o = (Example) inputStream.readObject();


        //либо свое

        Example readObject = new Example();
        System.out.println("read "+readObject.toString());
//

    }
}
