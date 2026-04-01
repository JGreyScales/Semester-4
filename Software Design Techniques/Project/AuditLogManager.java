import java.util.ArrayList;

public class AuditLogManager extends DataExporter {
    static ArrayList<DataExporter> dataList;

    boolean recieveLog(DataExporter data){
        return false;
    }

    boolean fetchLogsOf(DataExporter data){
        return false;
    }

    boolean fetchLogs(){
        return false;
    }

    boolean filterByStatus(boolean status){
        return false;
    }

    boolean filterByInvokerID(int ID){
        return false;
    }

    boolean filterByTime(int minimumDate){
        return false;
    }

    boolean filterByDevice(Devices device){
        return false;
    }

    ArrayList<String> getEventStringsFromData() {
        return null;
    }

    ArrayList<DataExporter> getDataList(){
        return null;
    }

    @Override
    boolean export() {
        // TODO Auto-generated method stub
        return super.export();
    }
}
