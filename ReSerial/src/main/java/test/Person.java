package test;

import java.io.IOException;
import java.io.Serializable;

public class Person implements Serializable {

    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException, IOException {
        Runtime.getRuntime().exec("calc.exe");
    }

}
