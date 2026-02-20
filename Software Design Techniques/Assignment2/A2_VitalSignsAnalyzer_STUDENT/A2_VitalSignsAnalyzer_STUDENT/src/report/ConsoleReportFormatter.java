package report;

import stats.PatientSummary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Step 2 + Step 3 output should be printed here.
 * You must print a readable report and ensure the required counts for the sample input match.
 */
public class ConsoleReportFormatter implements ReportFormatter<Map<String, PatientSummary>> {

    @Override
    public String format(Map<String, PatientSummary> summaries) {

        List<String> keys = new ArrayList<String>(summaries.keySet());
        Collections.sort(keys);

        StringBuilder value = new StringBuilder();
        value.append("PatientID,okCount,warningCount,criticalCount,recordCount,meanHR,minSp02,maxTemp,nonOkpercent\n");

        for (String key : keys) {
            value.append(summaries.get(key).toString());
        }


        return value.toString();
    }
}
