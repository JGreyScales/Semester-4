import java.util.ArrayList;

public class AuditLogManager extends DataExporter {
    static ArrayList<DataExporter> dataList = new ArrayList<>();

    static void addLog(DataExporter data){
        dataList.add(data);
    }

    static ArrayList<DataExporter> fetchLogsOfType(String data, ArrayList<DataExporter> curList){
        ArrayList<DataExporter> filtered = new ArrayList<>();
            for (DataExporter log : curList) {
                if (log.type.equalsIgnoreCase(data)) {
                    filtered.add(log);
                }
            }
        return filtered;
    }

    static ArrayList<DataExporter> filterByStatus(boolean status, ArrayList<DataExporter> curList){
        ArrayList<DataExporter> filtered = new ArrayList<>();
            for (DataExporter log : curList) {
                if (log.status == status) {
                    filtered.add(log);
                }
            }
        return filtered;
    }

    static ArrayList<DataExporter> filterByInvokerID(int ID, ArrayList<DataExporter> curList){
        ArrayList<DataExporter> filtered = new ArrayList<>();
            for (DataExporter log : curList) {
                if (log.invokerID == ID) {
                    filtered.add(log);
                }
            }
        return filtered;
    }

    static ArrayList<DataExporter> filterByTime(int minimumDate, ArrayList<DataExporter> curList){
       ArrayList<DataExporter> filtered = new ArrayList<>();
        for (DataExporter log : curList) {
            if (log.time.toEpochSecond(null, null) >= minimumDate) {
                filtered.add(log);
            }
        }
        return filtered;
    }

    static ArrayList<String> getEventStringsFromData(ArrayList<DataExporter> curList) {
        ArrayList<String> eventStrings = new ArrayList<>();
        for (DataExporter log : curList) {
            eventStrings.add(log.type);
        }
        return eventStrings;
    }
}
