import java.time.LocalDate;
import java.util.ArrayList;

public class AutomatedEventManager extends DataExporter {
    static ArrayList<AutomatedEvent> automationQueue = new ArrayList<>();

    static boolean addAutomatedEventToQueue(AutomatedEvent event){
        DataExporter de = new DataExporter();

        de.time = LocalDate.now();
        de.status = automationQueue.add(event);
        de.type = "automation added to queue";
        de.exportable = true;
        de.log = "added automation: " + event.export();

        return de.status;
    }

    static boolean static_export() {

        System.out.println("AutomationQueue Contents:");
        if (automationQueue != null) {
            for (AutomatedEvent event : automationQueue) {
                System.out.print(event.export());
            }
        } else {
            System.out.println("Queue is null.");
        }
        System.out.println();
        return true;
    }

    @Override
    String export(String... dataToAdd) {
        String actualData = (dataToAdd.length > 0) ? dataToAdd[0] : "";
        StringBuilder sb = new StringBuilder(actualData);

        sb.append("\nAutomationQueue Contents:");
        if (automationQueue != null) {
            for (AutomatedEvent event : automationQueue) {
                sb.append("\n" + event.export());
            }
        } else {
            sb.append("\nQueue is null.");
        }

        return sb.toString();
    }

    boolean peform() {
        return true;
    }
}
