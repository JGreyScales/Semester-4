import java.util.ArrayList;

public class User extends DataExporter {
    int userID;
    static ArrayList<User> Users;
    PermissionManager.permission permission;
    String userName;

    PermissionManager.permission getUserPermission(){
        return permission;
    }

    @Override
    boolean export() {
        return super.export();
    }
}
