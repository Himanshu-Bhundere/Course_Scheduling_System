import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.FileReader;

public class inputJson {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("/Users/himan/OneDrive/Desktop/SE/Exercise_1/Course_Scheduling_System/course.json"));
            JSONObject jsonObject = (JSONObject) obj;
            String name = (String) jsonObject.get("Name");
            String course = (String) jsonObject.get("Course");
            JSONArray subjects = (JSONArray) jsonObject.get("Subjects");
            System.out.println("Name: " + name);
            System.out.println("Course: " + course);
            System.out.println("Subjects:");
            for (Object subject : subjects) {
                System.out.println(subject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}