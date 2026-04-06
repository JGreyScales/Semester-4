import java.time.LocalDate;

public class DataExporter {
    static String exportFilePath = "exports/";
    Boolean exportable;
    String log;
    LocalDate time;
    String type;
    boolean status;


    String export(String... dataToAdd) {
        String actualData = (dataToAdd.length > 0) ? dataToAdd[0] : "";
        return actualData;
    }

    boolean exportData(DataExporter data){
        return false;
    }
}
