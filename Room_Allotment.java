import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


public class Room_Allotment {
    public static ArrayList<ArrayList<String>>alloted_rooms = new ArrayList<ArrayList<String>>();

    public static void bestFit(Map<String, String> rooms, String[][] course_cat){
        int temp, i= alloted_rooms.size();
        int prev_roomCap=999;
        for (String[] course: course_cat) {
            if(course[0] == null)
                continue;
            prev_roomCap=999;
            for (Map.Entry<String, String> set :rooms.entrySet()) {
                if(course[1] != null) {
                    temp = Integer.parseInt(set.getValue().strip()) - Integer.parseInt(course[1].strip());
                    if(temp>=0) {
                        if (prev_roomCap > Integer.parseInt(set.getValue().strip())){
                            ArrayList<String> temp_AL = new ArrayList<>(Arrays.asList(course[0], set.getKey()));
                            if(prev_roomCap == 999)
                                alloted_rooms.add(temp_AL);
                            else
                                alloted_rooms.set(i, temp_AL);
                            prev_roomCap=Integer.parseInt(set.getValue().strip());
                        }
                    }
                }
            }
            i++;
        }
        System.out.println(alloted_rooms);
    }
}
