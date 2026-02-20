package rules;

import model.Severity;
import model.VitalSignRecord;
import stats.PatientSummary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Step 2: Implement per-vital classification using VitalRules constants.
 * Step 3: Feed records into PatientSummary for statistics.
 */
public class VitalClassifier {

    /**
     * Logic:
     * 1. If within [lowerOk, upperOk] inclusive -> OK
     * 2. If below lowerCritical OR above upperCritical -> CRITICAL
     * 3. Else -> WARNING
     */
    private Severity classifyInt(Integer[] limits, int value) {
        if (value >= limits[0] && value <= limits[1]) {
            return Severity.OK;
        }
        // Critical is < lower or > upper (Note: your HR/SBP rules use > for Critical, 
        // so we check if it falls outside the warning/ok zone)
        if (value < limits[2] || value > limits[3]) {
            return Severity.CRITICAL;
        }
        return Severity.WARNING;
    }

    private Severity classifyDouble(Double[] limits, double value) {
        if (value >= limits[0] && value <= limits[1]) {
            return Severity.OK;
        }
        // Temp rule says CRITICAL if < 35.5 or >= 39.0
        if (value < limits[2] || value >= limits[3]) {
            return Severity.CRITICAL;
        }
        return Severity.WARNING;
    }

    public Severity classifyHeartRate(int hr) {
        return classifyInt(VitalRules.HR, hr);
    }

    public Severity classifySpo2(int spo2) {
        // SpO2 logic: OK >= 95, WARNING 90-94, CRITICAL < 90
        if (spo2 >= VitalRules.SpO2[0]) return Severity.OK;
        if (spo2 < VitalRules.SpO2[2]) return Severity.CRITICAL;
        return Severity.WARNING;
    }

    public Severity classifybp(int sbp, int dbp) {
        Severity sbpSev = classifyInt(VitalRules.SBP, sbp);
        
        // DBP implementation based on your rules: OK < 90, CRITICAL >= 96
        Severity dbpSev;
        if (dbp <= 89) {
            dbpSev = Severity.OK;
        } else if (dbp >= 96) {
            dbpSev = Severity.CRITICAL;
        } else {
            dbpSev = Severity.WARNING;
        }
        
        return Severity.max(sbpSev, dbpSev);
    }

    public Severity classifyTemp(double tempC) {
        return classifyDouble(VitalRules.TEMP, tempC);
    }

    public Severity classifyRecord(VitalSignRecord r) {
        Severity hr = classifyHeartRate(r.getHrBpm());
        Severity spo2 = classifySpo2(r.getSpo2Pct());
        Severity bp = classifybp(r.getSbpMmhg(), r.getDbpMmhg());
        Severity temp = classifyTemp(r.getTempC());

        // Overall severity is the maximum of any single vital
        return Severity.max(hr, Severity.max(spo2, Severity.max(bp, temp)));
    }

    public Map<String, PatientSummary> buildSummaries(List<VitalSignRecord> records) {
        Map<String, PatientSummary> map = new HashMap<>();

        for (VitalSignRecord r : records) {
            PatientSummary s = map.computeIfAbsent(r.getPatientId(), PatientSummary::new);
            Severity severity = this.classifyRecord(r);

            if (severity == Severity.CRITICAL) {
                s.incCritical();
            } else if (severity == Severity.WARNING) {
                s.incWarning();
            } else {
                s.incOk();
            }

            s.addRecord(r, severity);
        }
        return map;
    }
}