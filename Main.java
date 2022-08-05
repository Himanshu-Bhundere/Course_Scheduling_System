import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        InputCsv inputCsv = new InputCsv();
        InputJson inputJson = new InputJson();

        inputCsv.getCsvData();
        inputJson.getJsonData();

        Room_Allotment.bestFit(inputJson.room_no, inputCsv.course1);
        Room_Allotment.bestFit(inputJson.room_no, inputCsv.course2);
        Room_Allotment.bestFit(inputJson.room_no, inputCsv.course3);
        Room_Allotment.bestFit(inputJson.room_no, inputCsv.course4);

        TimeAllotment.timeAllotment(inputJson.timeslot, inputCsv.course1);
        TimeAllotment.timeAllotment(inputJson.timeslot, inputCsv.course2);
        TimeAllotment.timeAllotment(inputJson.timeslot, inputCsv.course3);
        TimeAllotment.timeAllotment(inputJson.timeslot, inputCsv.course4);

        System.out.println(inputJson.timeslot);

        System.out.println("\n\t\t\t\t\t\t\tTimeTable\n");
        for (Map.Entry<String, String> set : inputJson.timeslot.entrySet()){
            System.out.print("      "+set.getKey()+"   ");
        }
        System.out.println();

        String tempCourse;
        for (int i=0;i<Room_Allotment.alloted_rooms.size();i++) {
            System.out.print(Room_Allotment.alloted_rooms.get(i).get(1)); //print classroom number
            tempCourse=Room_Allotment.alloted_rooms.get(i).get(0);
            int j=0;
            for(Map.Entry<String, String> set : inputJson.timeslot.entrySet()) {
                if(Objects.equals(tempCourse, set.getValue())) {
                    System.out.print("    " + Room_Allotment.alloted_rooms.get(i).get(0));
                }
                else {
                    if(j==0)
                        System.out.print("\t\t  ");
                    else
                        System.out.print("\t     ");
                }
                j++;
            }
            System.out.println();
        }
    }
}
