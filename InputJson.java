import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class InputJson {
    public Map<String, String> room_no;
    public JSONArray course, times;
    public void getJsonData() {
        JSONParser parser = new JSONParser();
        room_no = new HashMap<String, String>();
        try {
            Object obj = parser.parse(new FileReader("course.json"));
            JSONObject jsonObject = (JSONObject) obj;
            room_no = (HashMap<String, String>) jsonObject.get("rooms");
            course = (JSONArray) jsonObject.get("courses");
            times = (JSONArray) jsonObject.get("times");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}