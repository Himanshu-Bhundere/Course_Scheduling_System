import com.opencsv.CSVReader;

import java.io.FileReader;

public class inputCsv {
    public static void main(String[] args) {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader("/Users/himan/OneDrive/Desktop/SE/Exercise_1/Course_Scheduling_System/course.csv"));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                for (String token : nextLine) {
                    System.out.print(token);
                }
                System.out.print("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

