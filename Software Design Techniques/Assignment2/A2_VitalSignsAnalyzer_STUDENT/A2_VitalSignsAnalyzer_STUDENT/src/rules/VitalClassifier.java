package rules;

import model.Severity;
import model.VitalSignRecord;
import stats.PatientSummary;
import util.Validation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Step 2:
 * - Implement per-vital classification methods using constants from VitalRules
 * - Overall severity is max severity across vitals in a row
 * - Aggregate OK/WARNING/CRITICAL counts per patient
 *
 * Step 3:
 * - Feed records into PatientSummary so it can compute statistics
 */
public class VitalClassifier {

    private static <T extends Comparable<T>> Severity getSeverity(T[] limits, T value) {
        Validation.require(limits.length == 4, "Limits length does not match expected");
        // limit schema
        // lower good, upper good, lower critical, upper critical
        // good bounds must be within critical bounds
        // gap between is classified as a warning bounds

        // warning bounds
        if ( value.compareTo(limits[0]) < 0 || value.compareTo(limits[1]) > 0){
            // critical bounds
            if (value.compareTo(limits[2]) <= 0 || value.compareTo(limits[3]) >= 0) {
                return Severity.CRITICAL;
            }
            return Severity.WARNING;
        }
        return Severity.OK;
    }

    public Severity classifyHeartRate(int hr) {
        return getSeverity(VitalRules.HR, hr);
    }

    public Severity classifySpo2(int spo2) {
       return getSeverity(VitalRules.SpO2, spo2);
    }

    public Severity classifybp(int sbp, int dbp) {
        Severity sbpClassification = getSeverity(VitalRules.SBP, sbp);
        Severity dbpClassification = getSeverity(VitalRules.DBP, dbp);
        return Severity.max(sbpClassification, dbpClassification);
    }

    public Severity classifyTemp(double tempC) {
        return getSeverity(VitalRules.TEMP, tempC);
    }

    public Severity classifyRecord(VitalSignRecord r) {
        Severity[] recordValues = new Severity[4];

        recordValues[0] = this.classifyHeartRate(r.getHrBpm());
        recordValues[1] = this.classifySpo2(r.getSpo2Pct());
        recordValues[2] = this.classifybp(r.getSbpMmhg(), r.getDbpMmhg());
        recordValues[3] = this.classifyTemp(r.getTempC());

        Severity max = Severity.OK;

        for (Severity severity : recordValues) {
            max = Severity.max(max, severity);
        }

        return max;
    }

    public Map<String, PatientSummary> buildSummaries(List<VitalSignRecord> records) {
        Map<String, PatientSummary> map = new HashMap<>();

        for (VitalSignRecord r : records) {
            PatientSummary s = map.computeIfAbsent(r.getPatientId(), PatientSummary::new);
            Severity severity = this.classifyRecord(r);

            if (severity.equals(Severity.CRITICAL)){s.incCritical();}
            else if (severity.equals(Severity.WARNING)){s.incWarning();}
            else {s.incOk();}
            
            s.addRecord(r, severity);
        }
        return map;
    }
}
