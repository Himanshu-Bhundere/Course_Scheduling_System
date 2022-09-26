import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

public class InputCsv {

    public String[][] course1 = new String[30][3];  // PG having preference
    public String[][] course2 = new String[30][3];  // UG with preference
    public String[][] course3 = new String[30][3];  // PG without preference
    public String[][] course4 = new String[30][3];  // UG without preference
    public void getCsvData() {

        String splitBy = ",", line; // use comma as separator
        String[] room_Cap= Main.inputJson.room_no.values().toArray(new String[0]);
        int length = 0;

        int row_course1 = 0, row_course2 = 0, row_course3 = 0, row_course4 = 0;   // counter for course
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("course.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                int num_pref = 0;
                String[] courseDetails = line.split(splitBy);

                if (courseDetails.length > 2) {
                    courseDetails[2] = courseDetails[2].replaceAll("\"", "");
                    num_pref = courseDetails[2].split(";").length;
                }
                length=0;
                for (String str: room_Cap) {
                    if (Integer.parseInt(courseDetails[1])>Integer.parseInt(str))
                        length++;
                }
                if (courseDetails[0].compareTo("cs599") > 0 ) {
                    if (num_pref > 0) {
                        System.arraycopy(courseDetails, 0, course1[row_course1], 0, 3);
                        if(length==room_Cap.length) {
                            course1[row_course1][0] = courseDetails[0]+"A";
                            if(Integer.parseInt(course1[row_course1][1])%2==0)
                                course1[row_course1][1]= String.valueOf(Integer.parseInt(course1[row_course1][1])/2);
                            else
                                course1[row_course1][1]= String.valueOf(Integer.parseInt(course1[row_course1][1])/2+1);
                            row_course1++;
                            System.arraycopy(courseDetails, 0, course1[row_course1], 0, 3);
                            course1[row_course1][0]=courseDetails[0]+"B";
                            course1[row_course1][1]= String.valueOf(Integer.parseInt(course1[row_course1][1])/2);
                        }
                        row_course1++;
                    } else {
                        System.arraycopy(courseDetails, 0, course3[row_course3], 0, 2);
                        if(length==room_Cap.length) {
                            course3[row_course3][0] = courseDetails[0]+"A";
                            if(Integer.parseInt(course3[row_course3][1])%2==0)
                                course3[row_course3][1]= String.valueOf(Integer.parseInt(course3[row_course3][1])/2);
                            else
                                course3[row_course3][1]= String.valueOf(Integer.parseInt(course3[row_course3][1])/2+1);
                            row_course3++;
                            System.arraycopy(courseDetails, 0, course3[row_course3], 0, 2);
                            course3[row_course3][0]=courseDetails[0]+"B";
                            course3[row_course3][1]= String.valueOf(Integer.parseInt(course3[row_course3][1])/2);
                        }
                        row_course3++;
                    }
                } else {
                    if (num_pref > 0) {
                        System.arraycopy(courseDetails, 0, course2[row_course2], 0, 3);
                        if(length==room_Cap.length) {
                            course2[row_course2][0] = courseDetails[0]+"A";
                            if(Integer.parseInt(course2[row_course2][1])%2==0)
                                course2[row_course2][1]= String.valueOf(Integer.parseInt(course2[row_course2][1])/2);
                            else
                                course2[row_course2][1]= String.valueOf(Integer.parseInt(course2[row_course2][1])/2+1);
                            row_course2++;
                            System.arraycopy(courseDetails, 0, course2[row_course2], 0, 3);
                            course2[row_course2][0]=courseDetails[0]+"B";
                            course2[row_course2][1]= String.valueOf(Integer.parseInt(course2[row_course2][1])/2);
                        }
                        row_course2++;
                    } else {
                        System.arraycopy(courseDetails, 0, course4[row_course4], 0, 2);
                        if(length==room_Cap.length) {
                            course4[row_course4][0] = courseDetails[0]+"A";
                            if(Integer.parseInt(course4[row_course4][1])%2==0)
                                course4[row_course4][1]= String.valueOf(Integer.parseInt(course4[row_course4][1])/2);
                            else
                                course4[row_course4][1]= String.valueOf(Integer.parseInt(course4[row_course4][1])/2+1);
                            row_course4++;
                            System.arraycopy(courseDetails, 0, course4[row_course4], 0, 3);
                            course4[row_course4][0]=courseDetails[0]+"B";
                            course4[row_course4][1]= String.valueOf(Integer.parseInt(course4[row_course4][1])/2);
                        }
                        row_course4++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        for (int i = 0; i < row_course1; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(course1[i][j]);
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < row_course3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(course3[i][j]);
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < row_course2; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(course2[i][j]);
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < row_course4; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(course4[i][j]);
//            }
//            System.out.println();
//        }
    }
}