import java.util.Arrays;

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
//        TimeAllotment.timeAllotment(inputJson.timeslot, inputCsv.course2);
    }
}
