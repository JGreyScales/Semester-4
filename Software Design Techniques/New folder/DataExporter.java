import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class DataExporter {
    static String exportFilePath = "exports/";
    Boolean exportable;
    String log;
    LocalDate time;
    String type;
    boolean status;
    int invokerID;


    String export(String... dataToAdd) {
        String actualData = (dataToAdd.length > 0) ? dataToAdd[0] : "";
        return actualData;
    }

    // some code is taken from
    // https://www.w3schools.com/java/java_files_create.asp
    static boolean exportData(ArrayList<DataExporter> data) {
        String fileName = "log-" + new SimpleDateFormat("dd-MM-yyyy").format(new Date()) + ".txt";
        try (FileWriter myWriter = new FileWriter(fileName)) {
            
            for (DataExporter obj : data) {
                String record = String.valueOf(obj.invokerID) + " | " +
                                String.valueOf(obj.status)    + " | " +
                                String.valueOf(obj.type)      + " | " +
                                String.valueOf(obj.exportable)+ " | " +
                                String.valueOf(obj.time)      + " | " +
                                String.valueOf(obj.log);

                myWriter.write(record + System.lineSeparator());
            }
            
            System.out.println("Successfully wrote to the file: " + fileName);
            return true;

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
            return false;
        }
    }
}
