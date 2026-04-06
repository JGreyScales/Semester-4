import java.time.LocalDate;

public class GreaterThan extends Check<Number> {
    @Override
    String export(String... dataToAdd) {
        String actualData = (dataToAdd.length > 0) ? dataToAdd[0] : "";
        StringBuilder sb = new StringBuilder(actualData);
        sb.append("\nEvent type: GreaterThan");

        return super.export(sb.toString());
    }

    @Override
    boolean peform() {

        DataExporter de = new DataExporter();
        de.time = LocalDate.now();
        de.exportable = true;
        de.type = "Peform check";
        de.log = this.export();
        de.status = input1.doubleValue() > input2.doubleValue();

        AuditLogManager.addLog(de);
        return de.status;
    }
}
