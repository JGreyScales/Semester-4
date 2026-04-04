public class Task extends AutomatedEvent {
    PermissionManager.Permission requiredPermission;

    PermissionManager.Permission getRequiredPermission(){
        return requiredPermission;
    }

    @Override
    boolean peform() {
        return super.peform();
    }

    @Override
    boolean export() {
        return super.export();
    }
}
