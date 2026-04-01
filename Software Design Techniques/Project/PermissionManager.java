public class PermissionManager {
    static enum permission {
        Guest,
        User,
        Admin
    }

    static boolean hasPermission(User user, Task task){
        return false;
    }
}
