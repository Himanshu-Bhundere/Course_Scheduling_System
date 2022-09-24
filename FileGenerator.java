import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class FileGenerator {

    public static boolean slotExists(String time, String slot){
        String[] arr_slot = slot.split("");
        String time1 = null, time2 = null;

        for(int i=2; i< arr_slot.length; i++) {
            if (!Objects.equals(arr_slot[i], "F")) {  // character is a part of time string
                time1 = arr_slot[i];
                if (i + 1 != arr_slot.length)
                    time2 = arr_slot[i + 1];
                else
                    time2 = null;
                break;
            }
        }
        if(time2 == null)
            return Objects.equals(time, time1);
        else
            return Objects.equals(time, time1 + time2);
    }

    public static void dayTime(Map<String, String> roomNo, Map<String, String> timeslot) throws IOException {
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        try {
            FileWriter outputFile = new FileWriter("day-time-output.csv");
            outputFile.write(""+",");
            for(String day:daysOfWeek){
                outputFile.write(day+",");
            }
            outputFile.write("\n");

            for (int hr = 9; hr <= 14; hr++) {
                for (Map.Entry<String, String> set : timeslot.entrySet()) {
                    if (FileGenerator.slotExists(String.valueOf(hr), set.getKey())) {
                        //System.out.println(set.getKey() + " : " + set.getValue());

                        if (Objects.equals(set.getKey().split("")[0], "M")) {
                            for (int d = 0; d < 5; d++) {
                                if (d % 2 == 1) {
                                    //set.getValue|room[set.getValue]
                                    outputFile.write("course: " + set.getValue() + " | class-room: " + roomNo.get(set.getValue()) + ",");
                                } else {
                                    outputFile.write("-" + ",");
                                }
                            }
                            outputFile.write("\n");
                        } else {
                            for (int d = 0; d < 5; d++) {
                                if (d % 2 == 1) {
                                    outputFile.write("-" + ",");
                                } else {
                                    //set.getValue|room[set.getValue]
                                    outputFile.write("course: " + set.getValue() + " | class-room: " + roomNo.get(set.getValue()) + ",");
                                }
                            }
                            outputFile.write("\n");
                        }
                        outputFile.close();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("IOException occurred");
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
}
