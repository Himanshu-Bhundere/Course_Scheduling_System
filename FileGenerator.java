import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class FileGenerator {

    public static boolean slotExists(String time, String slot){
        String[] arr_slot = slot.split("");
        String time1=null, time2=null;

        for(int i=2; i< arr_slot.length; i++) {
            if (!Objects.equals(arr_slot[i], "F")) {  // character is a part of time string
                time1 = arr_slot[i];
                if (i + 1 != arr_slot.length)
                    time2 = arr_slot[i + 1];
                break;
            }
        }
        if(time2 == null)
            return Objects.equals(time, time1);
        else
            return Objects.equals(time, time1 + time2);
    }

    public static void dayTime(ArrayList<ArrayList<String>> roomNo, Map<String, String> timeslot){
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        try {
            FileWriter outputFile = new FileWriter("day-time-output.csv");

            outputFile.write(""+",");
            for(String day:daysOfWeek){
                outputFile.write(day+",");
            }
            outputFile.write("\n");

            for (int hr = 9; hr <= 14; hr++) {
                outputFile.write(hr+":00"+",");
                for (Map.Entry<String, String> set : timeslot.entrySet()) {
                    //checking every working with the current row time
                    if (FileGenerator.slotExists(String.valueOf(hr), set.getKey())) { //if it matches

                        System.out.println(set.getKey()+" : "+set.getValue());
                        System.out.println(Objects.equals(set.getKey().split("")[0], "M"));

                        if (Objects.equals(set.getKey().split("")[0], "M")) { // for MWF
                            for (int d = 0; d <= 5; d++) {
                                if (d % 2 == 1) {
                                    //set.getValue|room[set.getValue]
                                    if(set.getValue() != null)
                                        outputFile.write("course: " + set.getValue() + " | class-room: " + FileGenerator.getClass(roomNo,set.getValue()) + ",");
                                } else {
                                    outputFile.write("" + ",");
                                }
                            }
                        } else { //for TT
                            for (int d = 0; d < 5; d++) {
                                if (d % 2 == 0) {
                                    outputFile.write("" + ",");
                                } else {
                                    //set.getValue|room[set.getValue]
                                    if(set.getValue() != null)
                                        outputFile.write("course: " + set.getValue() + " | class-room: " + FileGenerator.getClass(roomNo,set.getValue()) + ",");
                                }
                            }
                        }
                        outputFile.write("\n");
                    }
                }
            }
            outputFile.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void outputFile(Map<String, String> room_no, Map<String,String> timeslot, String[][] timeTable) {
        try {
            FileWriter outputFile = new FileWriter("output.csv");
            for (int j = 0; j < room_no.size() + 1; j++) {
                for (int k = 0; k < timeslot.size() + 1; k++) {
                    if (j == 0) {
                        if (k == 0)
                            outputFile.write(timeTable[j][k] + ",");
                        else
                            outputFile.write(timeTable[j][k] + ",");
                    } else {
                        if (k >= timeslot.size() - 2)
                            outputFile.write(timeTable[j][k] + ",");
                        else
                            outputFile.write(timeTable[j][k] + ",");
                    }
                }
                outputFile.write("\n");
            }
            outputFile.close();
        } catch (IOException e) {
            System.out.println("IOException occurred");
        }
    }

    public static String getClass(ArrayList<ArrayList<String>> roomNo, String course){
        String classroom = null;
        for(ArrayList<String> tup: roomNo){
            if(Objects.equals(tup.get(0), course))
                classroom = tup.get(1);
        }
        return classroom;
    }
}
