package stats;

import model.Severity;
import model.VitalSignRecord;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Aggregated counts and statistics for one patient.
 *
 * Step 2 :
 * - store OK/WARNING/CRITICAL counts and provide increment methods
 *
 * Step 3 :
 * - compute recordCount, mean HR, min SpO2, max temp, non-OK percentage
 */
public class PatientSummary {
    private final String patientId;
    
    // Step 2 counts
    private int okCount;
    private int warningCount;
    private int criticalCount;

    //  Step 3: add fields required for statistics
    public Map<Integer, List<Object>> records;
    private int recordID = 0;

    public PatientSummary(String patientId) {
        this.patientId = patientId;
        this.records = new HashMap<Integer, List<Object>>();
    }

    @Override
    public String toString() {
        StringBuilder value = new StringBuilder();

        value.append(this.getPatientId()).append(',')
            .append(this.getOkCount()).append(',')
            .append(this.getWarningCount()).append(',')
            .append(this.getCriticalCount()).append(',')
            .append(this.recordCount()).append(',')
            .append(this.meanHR()).append(',')
            .append(this.minSp02()).append(',')
            .append(this.maxTemp()).append(',')
            .append(this.nonOkpercent())
            .append('\n');
        
        return value.toString();
    }

    public String getPatientId() { return patientId; }

    public int getOkCount() { return okCount; }
    public int getWarningCount() { return warningCount; }
    public int getCriticalCount() { return criticalCount; }

    public void incOk() { okCount++; }
    public void incWarning() { warningCount++; }
    public void incCritical() { criticalCount++; }

    public void addRecord(VitalSignRecord r, Severity overallSeverity) {
        // Step 3: accumulate stats here
        List<Object> pair = new ArrayList<Object>();
        pair.add(r);
        pair.add(overallSeverity);
        this.records.put(this.recordID, pair);
        this.recordID++;
    }

    public void printRecords() {
        records.forEach((key, value) -> {
            VitalSignRecord vitalSignRecord = (VitalSignRecord) value.get(0);
            Severity severity = (Severity) value.get(1);

            System.out.println("Severity: " + severity.toString() + '\n' +vitalSignRecord.toString());
        });
    }

    public Integer recordCount(){
        return this.records.size();
    }

    public double meanHR(){
        ArrayList<Integer> hrS = new ArrayList<Integer>();

        records.forEach((key, value) -> {
            VitalSignRecord vitalSignRecord = (VitalSignRecord) value.get(0);
            hrS.add(vitalSignRecord.getHrBpm());
        });

        // round to two decimal places
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(StatsUtil.mean(hrS)));
    }

    public double minSp02(){
        ArrayList<Integer> sp02s = new ArrayList<Integer>();

        records.forEach((key, value) -> {
            VitalSignRecord vitalSignRecord = (VitalSignRecord) value.get(0);
            sp02s.add(vitalSignRecord.getSpo2Pct());
        });

        return StatsUtil.min(sp02s);
    }

    public double maxTemp(){
        ArrayList<Double> temps = new ArrayList<Double>();

        records.forEach((key, value) -> {
            VitalSignRecord vitalSignRecord = (VitalSignRecord) value.get(0);
            temps.add(vitalSignRecord.getTempC());
        });

        return StatsUtil.max(temps);
    }

    public double nonOkpercent(){
        double nonOkCount = this.recordCount() - this.getOkCount();
        double totalCount = this.recordCount();
        
        if (totalCount == 0) { 
            return 0;
        }
        
        // round to two decimal places
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format((nonOkCount / totalCount) * 100));
    }

    // Step 3: add getters: recordCount, meanHR, minSpO2, maxTemp, nonOkPercent
}
