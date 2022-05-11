import javax.script.*;
import java.io.*;

import static java.lang.System.*;

public class FirstJavaScript {
    public static void main(String args[]) {
        ScriptEngineManager manager = new ScriptEngineManager();
        // 得到javascript脚本引擎

        ScriptEngine engine = manager.getEngineByName("javascript");
        try {
            // 开始运行脚本，并返回当前的小时
            Double hour = (Double) engine.eval("var date = new Date();" + "date.getHours();");
            String msg;
            // 将小时转换为问候信息
            if (hour < 10) {
                msg = "上午好";
            } else if (hour < 16) {
                msg = "下午好";
            } else if (hour < 20) {
                msg = "晚上好";
            } else {
                msg = "晚安";
            }
            out.printf("小时%s: %s%n", hour, msg);
        } catch (ScriptException e) {
            err.println(e);
        }
    }
}