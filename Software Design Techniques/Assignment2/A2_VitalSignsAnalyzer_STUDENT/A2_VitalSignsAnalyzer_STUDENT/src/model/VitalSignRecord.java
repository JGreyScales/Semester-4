package model;

/**
 * Immutable record representing one row from the vitals CSV.
 */
public class VitalSignRecord {
    private final String patientId;
    private final String timestampIso;
    private final int hrBpm;
    private final int spo2Pct;
    private final int sbpMmhg;
    private final int dbpMmhg;
    private final double tempC;

    public VitalSignRecord(
            String patientId,
            String timestampIso,
            int hrBpm,
            int spo2Pct,
            int sbpMmhg,
            int dbpMmhg,
            double tempC
    ) {
        this.patientId = patientId;
        this.timestampIso = timestampIso;
        this.hrBpm = hrBpm;
        this.spo2Pct = spo2Pct;
        this.sbpMmhg = sbpMmhg;
        this.dbpMmhg = dbpMmhg;
        this.tempC = tempC;
    }

    public String getPatientId() { return patientId; }
    public String getTimestampIso() { return timestampIso; }
    public int getHrBpm() { return hrBpm; }
    public int getSpo2Pct() { return spo2Pct; }
    public int getSbpMmhg() { return sbpMmhg; }
    public int getDbpMmhg() { return dbpMmhg; }
    public double getTempC() { return tempC; }

    @Override
    public String toString() {
        StringBuilder value = new StringBuilder();
        
        value.append("PatientID: ").append(this.getPatientId()).append('\n')
        .append("TimeStamp: ").append(this.getTimestampIso()).append('\n')
        .append("HRBPM: ").append(this.getHrBpm()).append('\n')
        .append("Spo2Pct: ").append(this.getSpo2Pct()).append('\n')
        .append("SbpMmhg: ").append(this.getSbpMmhg()).append('\n')
        .append("DbpMmhg: ").append(this.getDbpMmhg()).append('\n')
        .append("temp: ").append(this.getTempC()).append('\n');        
        return value.toString();
    }

}
