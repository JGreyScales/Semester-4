import java.time.LocalDate;

public class Equals extends Check<Number> {
    @Override
    String export(String... dataToAdd) {
        String actualData = (dataToAdd.length > 0) ? dataToAdd[0] : "";
        StringBuilder sb = new StringBuilder(actualData);
        sb.append("\nEvent type: Equals");

        return super.export(sb.toString());
    }

    @Override
    boolean peform() {
        DataExporter de = new DataExporter();
        de.time = LocalDate.now();
        de.exportable = true;
        de.type = "Peform check";
        de.log = this.export();
        de.status = input1 == input2;

        AuditLogManager.addLog(de);
        return de.status;
    }
}
