import delight.nashornsandbox.NashornSandbox;
import delight.nashornsandbox.NashornSandboxes;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.concurrent.Executors;

import static java.lang.System.err;

public class FirstJavaScriptJS {
    public static void main(String args[]) throws ScriptException, IOException, NoSuchMethodException {
        ScriptEngineManager manager = new ScriptEngineManager();
        // 得到javascript脚本引擎
        ScriptEngine engine = manager.getEngineByName("javascript");

        //一段JavaScript脚本语言代码
        String str ="var user={name:'夏洛',age:18,schools:['北京大学','清华大学']};";
        str +="print(user.name);"; //写出println(user.name); 会报错即多个ln会报错，不知道为啥？
        //用引擎执行脚本语言代码
        engine.eval(str);//eval() 获取返回值

        String scriptText = "function greet(name) { print('Hello, '+name ); } ";


            Object temp = engine.eval(scriptText);
            System.out.println(temp);

        //方法调用
        Invocable invocable = (Invocable) engine;
        invocable.invokeFunction("greet", "Alex");



    }
}
