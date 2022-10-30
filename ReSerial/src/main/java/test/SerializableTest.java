package test;

import java.io.*;
import java.util.HashMap;

public class SerializableTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException, FileNotFoundException {

        HashMap hsmap = new HashMap();

        Person person = new Person("zhangsan", 24);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abc.txt"));
        oos.writeObject(person);
        oos.close();


        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ois.readObject();
        ois.close();
    }
}
