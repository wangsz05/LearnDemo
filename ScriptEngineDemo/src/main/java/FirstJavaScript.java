import com.alibaba.fastjson.JSONObject;
import delight.nashornsandbox.NashornSandbox;
import delight.nashornsandbox.NashornSandboxes;
import netscape.javascript.JSObject;

import javax.script.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

import static java.lang.System.*;

public class FirstJavaScript {
    public static void main(String args[]) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        // 得到javascript脚本引擎

        ScriptEngine engine = manager.getEngineByName("javascript");
        String rce = "new java.lang.ProcessBuilder['(java.lang.String[])'](['cmd ',' /c ','calc']).start()";
        String rce1 = "\"\".getClass().forName(\"java.lang.Runtime\").getMethod(\"getRuntime\").invoke(null),\"calc.exe\")";
//        try {
//
//           engine.eval(rce);
//
//        } catch (ScriptException e) {
//            err.println(e);
//        }

        String jsf1 = "function test1() {return \"hello world\" }";

    NashornSandbox sandbox = NashornSandboxes.create();
    sandbox.setMaxCPUTime(100);// 设置脚本执行允许的最大CPU时间（以毫秒为单位），超过则会报异常,防止死循环脚本
    sandbox.setMaxMemory(1024 * 1024); //设置JS执行程序线程可以分配的最大内存（以字节为单位），超过会报ScriptMemoryAbuseException错误
    sandbox.allowNoBraces(false); // 是否允许使用大括号
    sandbox.allowLoadFunctions(true); // 是否允许nashorn加载全局函数
    sandbox.setMaxPreparedStatements(30); // because preparing scripts for execution is expensive // LRU初缓存的初始化大小，默认为0
    sandbox.setExecutor(Executors.newSingleThreadExecutor());// 指定执行程序服务，该服务用于在CPU时间运行脚本
        sandbox.allow(ProcessBuilder.class);


        sandbox.eval(jsf1);
    }

}