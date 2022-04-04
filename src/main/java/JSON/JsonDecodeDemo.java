package JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class JsonDecodeDemo {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try{
            Object obj = parser.parse(new FileReader("lab1.json"));
            JSONObject obj1 = (JSONObject) obj;
            System.out.println(obj);

            String tag1 = (String) obj1.get("plant");
            System.out.println("The second " + tag1);

        } catch (ParseException | IOException pe){
            pe.printStackTrace();
        }
    }
}