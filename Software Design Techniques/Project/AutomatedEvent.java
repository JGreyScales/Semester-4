import java.util.ArrayList;

public class AutomatedEvent extends AutomatedEventManager {
    
    int eventID;
    int throttlePer;
    ArrayList<Tuple<AutomatedEvent, Devices>> eventQueue;

    @Override
    boolean export() {
        return super.export();
    }

    @Override
    boolean peform() {
        return super.peform();
    }
}
