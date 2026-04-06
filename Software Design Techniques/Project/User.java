import java.time.LocalDate;
import java.util.ArrayList;

public class User extends DataExporter {
    int userID;
    static User currentUser = null;
    static ArrayList<User> Users = new ArrayList<>();
    PermissionManager.Permission permission;
    String userName;

    User(String username, PermissionManager.Permission permission, int id){
        this.userName = username;
        this.permission = permission;
        this.userID = id;
    }

    PermissionManager.Permission getUserPermission(){
        return permission;
    }

    static void setupDemo(){
        User user1 = new User("guest user",PermissionManager.Permission.GUEST , 0);
        User user2 = new User("regular user",PermissionManager.Permission.USER , 1);
        User user3 = new User("admin user",PermissionManager.Permission.ADMIN , 2);

        User.addUser(user1);
        User.addUser(user2);
        User.addUser(user3);

        setUser(user2);
    }

    static void setUser(User userToSet){
        DataExporter de = new DataExporter();
        de.exportable = true;
        de.log = "Switching user to " + userToSet.export();
        de.time = LocalDate.now();
        de.type = "User switch";
        de.status = true;

        if (User.currentUser == null){
            de.invokerID = -1;
        } else {
            de.invokerID = User.currentUser.userID;
        }


        AuditLogManager.addLog(de);

        User.currentUser = userToSet;
    }

    static boolean addUser(User userToAdd){
        return User.Users.add(userToAdd);
    }

    static boolean static_displayUsers(){
        for (User user : Users) {
            System.out.print(user.export());
        }
        System.out.println();
        return true;
    }

    @Override
    String export(String... dataToAdd) {
        String actualData = (dataToAdd.length > 0) ? dataToAdd[0] : "";
        StringBuilder sb = new StringBuilder(actualData);
        sb.append("\n---\nUserID: " + userID + "\nPermission: " + permission.toString() + "\nusername: " + userName);

        return sb.toString();
    }
}
