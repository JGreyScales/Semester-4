import io.CsvVitalReader;
import model.VitalSignRecord;
import report.ConsoleReportFormatter;
import report.CsvReportWriter;
import rules.VitalClassifier;
import stats.PatientSummary;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Main <path-to-vitals.csv>");
            return;
        }

        String path = args[0];

        CsvVitalReader reader = new CsvVitalReader();
        List<VitalSignRecord> records = reader.read(path);

        VitalClassifier classifier = new VitalClassifier();
        Map<String, PatientSummary> summaries = classifier.buildSummaries(records);

        // this will print a full debug log of POOx
        // PatientSummary patient = summaries.get("P003");
        // patient.printRecords();
        // System.out.println(patient.toString());

        ConsoleReportFormatter formatter = new ConsoleReportFormatter();
        String reportText = formatter.format(summaries);
        formatter.printToConsole(reportText);

        CsvReportWriter writer = new CsvReportWriter();
        writer.write("out/report.csv", summaries);

        System.out.println("Wrote out/report.csv");
    }
}
