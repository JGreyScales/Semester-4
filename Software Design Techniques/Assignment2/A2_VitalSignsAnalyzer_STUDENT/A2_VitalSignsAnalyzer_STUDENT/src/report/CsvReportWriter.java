package report;

import stats.PatientSummary;
import report.ConsoleReportFormatter;

import java.io.File;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Step 4 :
 * - Write out/report.csv with one row per patient
 * - Must be ordered by patient_id
 * - Must include counts and statistics columns
 */
public class CsvReportWriter {

    public void write(String outPath, Map<String, PatientSummary> summaries) {
        ConsoleReportFormatter formatter = new ConsoleReportFormatter();
        String reportText = formatter.format(summaries);

        File csvOutputFile = new File(outPath);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            pw.print(reportText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
