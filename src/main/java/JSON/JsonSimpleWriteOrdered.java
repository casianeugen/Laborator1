package JSON;

import org.json.simple.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonSimpleWriteOrdered {
    public static void main(String[] args) {
        Map<Object,Object> map = new LinkedHashMap<>();
        map.put("is_vip", Boolean.TRUE);
        map.put("name", "mkyong.com");
        map.put("age", 100);
        map.put("balance", 100.21);

        System.out.println(JSONObject.toJSONString(map));
    }
}
