import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class MySerialDemo {
    public static void main(String[] args) {
        String jsonstr = "{\"@type\":\"UserFastJson\",\"password\":\"123456\",\"name\":\"李四\",\"sex\":\"0\"}";
        try {
            System.out.println("===============JSON.parse(jsonstr)=========================");
//           Object obj1= JSON.parse(jsonstr);
//            System.out.println("===============JSON.parseObject(jsonstr)=========================");
           JSONObject obj2= JSON.parseObject(jsonstr);
//            System.out.println("===============JSON.parseObject(jsonstr,UserFastJson.class)=========================");
//           UserFastJson obj3= JSON.parseObject(jsonstr,UserFastJson.class);
//            System.out.println(user.getName());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
