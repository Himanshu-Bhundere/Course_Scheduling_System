import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Room_Allotment {
    public static ArrayList<ArrayList<String>>alloted_rooms = new ArrayList<ArrayList<String>>();

//    String[][] alloted_rooms = new String[2][2];
    public static void main(String[] args) {

        InputCsv inputCsv = new InputCsv();
        InputJson inputJson = new InputJson();

        inputCsv.getCsvData();
        inputJson.getJsonData();

        bestFit(inputJson.room_no, inputCsv.course1);
        bestFit(inputJson.room_no, inputCsv.course2);
        bestFit(inputJson.room_no, inputCsv.course3);
        bestFit(inputJson.room_no, inputCsv.course4);
    }

    public static void bestFit(Map<String, String> rooms, String[][] course_cat){
        int lowest, temp, i=0;
        for (String[] course: course_cat) {
            if(course[0] == null)
                continue;
            lowest = 999;
            for (Map.Entry<String, String> set :rooms.entrySet()) {
                if(course[1] != null) {
                    temp = Integer.parseInt(set.getValue().strip()) - Integer.parseInt(course[1].strip());
                    if(temp>=0) {
                        if (lowest > temp){
                            ArrayList<String> temp_AL = new ArrayList<>(Arrays.asList(course[1], set.getKey()));
                            if(lowest == 999)
                               alloted_rooms.add(temp_AL);
                            else
                                alloted_rooms.set(i, temp_AL);
                            lowest = temp;
                        }
                    }
                }
            }
            System.out.println(rooms);
            rooms.remove(alloted_rooms.get(i).get(1));
            System.out.println(rooms);
            System.out.println();
            i++;
        }
        System.out.println(alloted_rooms);

//                if(barray[j]!=1)
//                {
//                    temp=b[j]-p[i];
//                    if(temp>=0)
//                        if(lowest>temp)
//                        {
//                            parray[i]=j;
//                            lowest=temp;
//                        }
//                }
//            }
//            barray[parray[i]]=1;
//            lowest=10000;
//        }
    }
}

