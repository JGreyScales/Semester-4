import java.util.ArrayList;
import java.util.Scanner;

public class UIManager {
    static ArrayList<String> screenPath = new ArrayList<>();
    static Scanner lineReader = new Scanner(System.in);

    String getStringInput(){
        return lineReader.nextLine();
    }

    int getInputChoice(int min, int max){
        boolean interfacing = true;
        int inputInt = -9999;

        while (interfacing) {
                System.out.println("Enter an int between " + min + '-' + max);
                inputInt = lineReader.nextInt();

                if (min <= inputInt && inputInt <= max){
                    interfacing = false;
                } else {
                    System.out.println("Invalid selection");
                }
        }

        // lineReader.close();
        
        return inputInt;
    }    

    void getHomePage(){
        if (screenPath.isEmpty() || !screenPath.get(0).equals("homepage")){
                screenPath.add(0, "homepage");
            } else {
                Devices.setRandomAllDevices();
            }
        
        System.out.println("1) display devices");
        System.out.println("2) execute next automation");
        System.out.println("3) add automation");
        System.out.println("4) display automation list");
        System.out.println("5) display users");
        System.out.println("6) add user");
        System.out.println("7) display audits");
        System.out.println("8) sign in to user");
        System.out.println("9) run demo autosetup");

        int choice = this.getInputChoice(1, 9);

        switch (choice) {
            case 1:
                Devices.displayAll();
                break;
            case 2:

                if (AutomatedEventManager.automationQueue.isEmpty()){
                    System.out.println("Automation queue is empty");
                    break;
                }
                AutomatedEvent event = AutomatedEventManager.automationQueue.get(0);

                // push automated to the back of the queue
                AutomatedEventManager.automationQueue.add(event);
                AutomatedEventManager.automationQueue.remove(0);

                System.out.println("Executing event: " + event.eventID);
                boolean result = event.peform();
                System.out.println("Result: " + result);

                break;
            case 3:

                screenPath.add("addAutomationpage");
                this.getAddAutiomationPage();
                break;
            case 4:
                AutomatedEventManager.static_export();
                break;
            case 5:
                User.static_displayUsers();
                break;
            case 6:
                screenPath.add("addUserPage");
                this.getAdduserPage();
                break;
            case 7:
                screenPath.add("auditPage");
                this.getAuditPage();
                break;
            case 8:
                screenPath.add("loginPage");
                this.getLoginPage();
                break; 
            case 9:
                System.out.println("Creating demo devices");
                Devices.createDevicesForDemo();

                System.out.println("Creating demo automated events");
                AutomatedEvent.setupAutomatedEventsForDemo();
            default:
                break;
        }

        this.getHomePage();
        return;
    }

    void getAddAutiomationPage(){

        AutomatedEvent event = new AutomatedEvent();

        System.out.println("enter the eventID");
        event.eventID = this.getInputChoice(1, 999);

        System.out.println("enter the throttle %");
        event.throttlePer = this.getInputChoice(0, 100);

        Devices.displayAll();
        System.out.println("Select a device by index");
        event.designatedDevice = Devices.devices.get(this.getInputChoice(0, Devices.devices.size()));

        System.out.println("Do all checks need to pass? (0) NO (1) Yes");
        event.allNeedToPass = getInputChoice(0, 1) == 1;

        boolean addingChecks = true;
        while (addingChecks){
            System.out.println("Add a new check? (0) No (1) Yes");

            if (1 == getInputChoice(0, 1)){
                System.out.println("What type of check is this? (1) = (2) > (3) <");
                Check<Number> checkObject;
                switch (this.getInputChoice(1, 3)) {
                    case 1:
                        checkObject = new Equals();
                        break;
                    case 2:
                        checkObject = new GreaterThan();
                        break;
                    case 3:
                        checkObject = new LessThan();
                        break;
                    default:
                        // abort
                        return;
                }

                System.out.println("What is the value to compare against");
                checkObject.setInput2(getInputChoice(-200, 200));

                event.addCheck(checkObject);
            } else {
                addingChecks = false;
            }
        }

        AutomatedEventManager.addAutomatedEventToQueue(event);

        screenPath.remove("addAutomationPage");
        return;
    }

    void getAdduserPage(){

        screenPath.remove("addUserPage");
        return;
    }

    void getLoginPage(){


        screenPath.remove("loginpage");
        return;
    }

    void getAuditPage(){

        screenPath.remove("auditPage");
        return;
    }

    void getTasksPage(){
        return;
    }

}
