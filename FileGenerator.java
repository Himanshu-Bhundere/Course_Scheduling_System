import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileGenerator {
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
