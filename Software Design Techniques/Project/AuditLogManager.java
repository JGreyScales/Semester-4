import java.util.ArrayList;

public class AuditLogManager extends DataExporter {
    static ArrayList<DataExporter> dataList = new ArrayList<>();

    static void addLog(DataExporter data){
        dataList.add(data);
    }

    ArrayList<DataExporter> fetchLogsOfType(String data){
        ArrayList<DataExporter> filtered = new ArrayList<>();
            for (DataExporter log : dataList) {
                if (log.type.equalsIgnoreCase(type)) {
                    filtered.add(log);
                }
            }
        return filtered;
    }

    ArrayList<DataExporter> filterByStatus(boolean status){
        ArrayList<DataExporter> filtered = new ArrayList<>();
            for (DataExporter log : dataList) {
                if (log.status == status) {
                    filtered.add(log);
                }
            }
        return filtered;
    }

    ArrayList<DataExporter> filterByInvokerID(int ID){
        ArrayList<DataExporter> filtered = new ArrayList<>();
            for (DataExporter log : dataList) {
                if (log.invokerID == ID) {
                    filtered.add(log);
                }
            }
        return filtered;
    }

    ArrayList<DataExporter> filterByTime(int minimumDate){
       ArrayList<DataExporter> filtered = new ArrayList<>();
        for (DataExporter log : dataList) {
            if (log.time.toEpochSecond(null, null) >= minimumDate) {
                filtered.add(log);
            }
        }
        return filtered;
    }

    ArrayList<String> getEventStringsFromData() {
        ArrayList<String> eventStrings = new ArrayList<>();
        for (DataExporter log : dataList) {
            eventStrings.add(log.type);
        }
        return eventStrings;
    }
}
