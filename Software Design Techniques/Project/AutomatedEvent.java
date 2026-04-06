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
        int ticker = 0;
        boolean onePass = false;

        if (checkQueue.isEmpty()){
            System.out.println("No checks to perform");
            return true;
        }

        for (Check<Number> check : checkQueue) {
            ticker += 1;
            // throttle checks
            try {
                Thread.sleep(Math.round(1000 * (1.0 + (throttlePer / 100.0))));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.err.println("The event execution was interrupted.");
            }

            check.setInput1(designatedDevice.curState);

            if (check.peform()){
                System.out.println("Check " + ticker + " Passed");
                onePass = true;
                continue;
            } else {
                System.out.println("Check " + ticker + " Failed");
                if (allNeedToPass){
                    return false;
                }
            }
        }


        return onePass;
    }
}