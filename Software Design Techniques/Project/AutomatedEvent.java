import java.util.ArrayList;

public class AutomatedEvent extends AutomatedEventManager {
    
    int eventID;
    int throttlePer;
    boolean allNeedToPass;
    Devices designatedDevice;
    ArrayList<Check<Number>> checkQueue;

    boolean addCheck(Check<Number> check){
        return checkQueue.add(check);
    }

    static void setupAutomatedEventsForDemo(){
        AutomatedEvent event1 = new AutomatedEvent();
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

        AutomatedEvent event2 = new AutomatedEvent();
        event2.eventID = 1;
        event2.throttlePer = 0;
        event2.designatedDevice = Devices.devices.get(4);
        event2.allNeedToPass = true;
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
    }

    @Override
    boolean export() {
        System.out.println("--- Automated Event Data ---");
        System.out.println("Event ID    : " + eventID);
        System.out.println("Throttle %  : " + throttlePer);
        designatedDevice.display();
        
        System.out.println("Event Queue : ");
        if (checkQueue == null || checkQueue.isEmpty()) {
            System.out.println("  [Empty]");
        } else {
            for (Check<Number> entry : checkQueue) {
                System.out.println("Check Object " );
                entry.export();
            }
        }
        
        System.out.println("---------------------------");
        return true; 
    }

    @Override
    public String toString() {
        return "Event[ID=" + eventID + ", Throttle=" + throttlePer + "%]";
    }

    @Override
    boolean peform() {
        boolean onePass = false;
        for (Check<Number> check : checkQueue) {

            // throttle checks
            try {
                Thread.sleep(Math.round(1000 * (1.0 + (throttlePer / 100.0))));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.err.println("The event execution was interrupted.");
            }

            check.setInput1(designatedDevice.curState);

            if (check.peform()){
                onePass = true;
                continue;
            } else {
                if (allNeedToPass){
                    return false;
                }
            }
        }


        return onePass;
    }
}