import java.util.ArrayList;

public class AutomatedEventManager extends DataExporter {
    static ArrayList<AutomatedEvent> automationQueue;

    static boolean static_export() {

        System.out.println("AutomationQueue Contents:");
        if (automationQueue != null) {
            for (AutomatedEvent event : automationQueue) {
                event.export();
            }
        } else {
            System.out.println("Queue is null.");
        }

        return true;
    }

    @Override
    boolean export() {

        System.out.println("AutomationQueue Contents:");
        if (automationQueue != null) {
            for (AutomatedEvent event : automationQueue) {
                event.export();
            }
        } else {
            System.out.println("Queue is null.");
        }

        return super.export();
    }

    boolean peform() {
        return true;
    }
}
