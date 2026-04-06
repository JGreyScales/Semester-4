import java.util.ArrayList;

public class AutomatedEvent extends AutomatedEventManager {
    
    int eventID;
    int throttlePer;
    boolean allNeedToPass;
    Devices designatedDevice;
    ArrayList<Check<Number>> checkQueue = new ArrayList<>();

    boolean addCheck(Check<Number> check){
        return checkQueue.add(check);
    }

    static void setupAutomatedEventsForDemo(){
        Task event1 = new Task();
        event1.requiredPermission = PermissionManager.Permission.GUEST;
        event1.eventID = 1;
        event1.throttlePer = 0;
        event1.designatedDevice = Devices.devices.get(0);
        event1.allNeedToPass = true;
        Check<Number> check1 = new GreaterThan();
        check1.setInput2(50);
        event1.addCheck(check1);
        Check<Number> check2 = new LessThan();
        check2.setInput2(180);
        event1.addCheck(check2);
        Check<Number> check3 = new GreaterThan();
        check3.setInput2(-25);
        event1.addCheck(check3);

        AutomatedEventManager.addAutomatedEventToQueue(event1);

        Task event2 = new Task();
        event2.requiredPermission = PermissionManager.Permission.USER;
        event2.eventID = 2;
        event2.throttlePer = 30;
        event2.designatedDevice = Devices.devices.get(4);
        event2.allNeedToPass = false;
        Check<Number> check2_1 = new GreaterThan();
        check2_1.setInput2(50);
        event2.addCheck(check2_1);
        Check<Number> check2_2 = new LessThan();
        check2_2.setInput2(180);
        event2.addCheck(check2_2);
        Check<Number> check2_3 = new GreaterThan();
        check2_3.setInput2(-25);
        event2.addCheck(check2_3);

        AutomatedEventManager.addAutomatedEventToQueue(event2);

        Task event3 = new Task();
        event3.requiredPermission = PermissionManager.Permission.ADMIN;
        event3.eventID = 3;
        event3.throttlePer = 100;
        event3.designatedDevice = Devices.devices.get(4);
        event3.allNeedToPass = false;
        Check<Number> check3_1 = new GreaterThan();
        check3_1.setInput2(50);
        event3.addCheck(check3_1);
        Check<Number> check3_2 = new LessThan();
        check3_2.setInput2(180);
        event3.addCheck(check3_2);
        Check<Number> check3_3 = new GreaterThan();
        check3_3.setInput2(-25);
        event3.addCheck(check3_3);

        AutomatedEventManager.addAutomatedEventToQueue(event3);
    }

    @Override
    String export(String... dataToAdd) {
        String actualData = (dataToAdd.length > 0) ? dataToAdd[0] : "";

        StringBuilder sb = new StringBuilder(actualData);
        sb.append("\n--- Automated Event Data ---");
        sb.append("\nEvent ID    : " + eventID);
        sb.append("\nThrottle %  : " + throttlePer);
        sb.append("\n" + designatedDevice.display());
        
        sb.append("\nEvent Queue : ");
        if (checkQueue == null || checkQueue.isEmpty()) {
            sb.append("\n  [Empty]");
        } else {
            for (Check<Number> entry : checkQueue) {
                sb.append("\nCheck Object " );
                sb.append("\n" + entry.export());
            }
        }
        
        sb.append("\n---------------------------");
        return sb.toString(); 
    }

    @Override
    public String toString() {
        return "Event[ID=" + eventID + ", Throttle=" + throttlePer + "%]";
    }
}