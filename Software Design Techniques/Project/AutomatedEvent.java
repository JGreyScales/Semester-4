import java.util.ArrayList;

public class AutomatedEvent extends AutomatedEventManager {
    
    int eventID;
    int throttlePer;
    ArrayList<Tuple<AutomatedEvent, Devices>> eventQueue;

    @Override
    boolean export() {
        System.out.println("--- Automated Event Data ---");
        System.out.println("Event ID    : " + eventID);
        System.out.println("Throttle %  : " + throttlePer);
        
        
        System.out.println("Event Queue : ");
        if (eventQueue == null || eventQueue.isEmpty()) {
            System.out.println("  [Empty]");
        } else {
            for (Tuple<AutomatedEvent, Devices> entry : eventQueue) {
                System.out.println("Check Object " );
                entry.getFirst().export();

                System.out.println("Device Object " );
                entry.getSecond();
            }
        }
        
        System.out.println("---------------------------");
        return true; 
    }

    // Adding a toString method is best practice for printing objects
    @Override
    public String toString() {
        return "Event[ID=" + eventID + ", Throttle=" + throttlePer + "%]";
    }

    @Override
    boolean peform() {
        return super.peform();
    }
}