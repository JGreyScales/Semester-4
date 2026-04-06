import java.time.LocalDate;

public class Task extends AutomatedEvent {
    PermissionManager.Permission requiredPermission;

    PermissionManager.Permission getRequiredPermission(){
        return requiredPermission;
    }

    @Override
    boolean peform() {

        DataExporter de = new DataExporter();
        de.time = LocalDate.now();
        de.exportable = true;
        de.type = "Task perform";
        StringBuilder sb = new StringBuilder();

        if (requiredPermission.getLevel() > User.currentUser.permission.getLevel()){
            de.log = "Access denied";
            de.status = false;
            System.out.println("Access denied");
            AuditLogManager.addLog(de);
            return false;
        }

        int ticker = 0;
        boolean onePass = false;

        if (checkQueue.isEmpty()){
            de.log = "No checks to perform";
            de.status = true;
            System.out.println("No checks to perform");
            AuditLogManager.addLog(de);
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
                sb.append("\nCheck " + ticker + " Passed");
                System.out.println("Check " + ticker + " Passed");
                onePass = true;
                continue;
            } else {
                System.out.println("Check " + ticker + " Failed");
                sb.append("\nCheck " + ticker + " Failed");

                if (allNeedToPass){
                    de.status = false;
                    de.log = sb.toString();
                    AuditLogManager.addLog(de);
                    return false;
                }
            }
        }


        de.status = onePass;
        de.log = sb.toString();

        AuditLogManager.addLog(de);
        return onePass;
    }
}
