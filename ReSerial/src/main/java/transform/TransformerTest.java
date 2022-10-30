package transform;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.MapTransformer;

import java.io.IOException;
import java.util.HashMap;

public class TransformerTest {
    public static void main(String[] args) throws IOException {
        HashMap<String,Object> map = new HashMap<>();
        map.put("key",Runtime.getRuntime());
        Transformer transform = MapTransformer.getInstance(map);
//        Runtime runtime = (Runtime) transform.transform("key");
//        runtime.exec("calc");
        ((Runtime) transform.transform("key")).exec("calc");
        System.out.println("finish");
    }
}
