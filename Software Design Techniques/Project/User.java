import java.util.ArrayList;

public class User extends DataExporter {
    int userID;
    static ArrayList<User> Users = new ArrayList<>();
    PermissionManager.Permission permission;
    String userName;

    PermissionManager.Permission getUserPermission(){
        return permission;
    }

    static boolean static_displayUsers(){
        for (User user : Users) {
            user.export();
        }

        return true;
    }

    @Override
    boolean export() {
        System.out.println("UserID" + userID + "\nPermission: " + permission.toString() + "\nusername: " + userName);
        return true;
    }
}
