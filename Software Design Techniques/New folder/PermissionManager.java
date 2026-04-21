public class PermissionManager {

    public enum Permission {
        GUEST(0),
        USER(1),
        ADMIN(2);

        private final int level;

        Permission(int level) {
            this.level = level;
        }

        public int getLevel() {
            return this.level;
        }

        public static Permission fromLevel(int level) {
        for (Permission p : Permission.values()) {
            if (p.level == level) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid permission level: " + level);
    }
    }
    
    static boolean hasPermission(User user, Task task) {
        return user.getUserPermission().getLevel() >= task.getRequiredPermission().getLevel();
    }
}