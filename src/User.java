import java.util.ArrayList;

public class User {
    private String username;
    private String passhash;
    private static ArrayList<User> userList = new ArrayList<User>();

    User(String name, String pass) {
        username = name;
        passhash = Hashing.MD5Hash(pass);
        userList.add(this);
    }

    public static boolean UserExists(String name) {
        int length = userList.size();

        for (int i = 0; i < length; i++) {
            if (userList.get(i).username.equals(name)) {
                return true;
            } // if user not found

        }
        return false;
    }

    public static boolean HashMatch(String name, String pass) {
        String hash = Hashing.MD5Hash(pass);
        boolean result = false;
        int length = userList.size();
        int i = 0;
        for (i = 0; i < length; i++) {
            if (userList.get(i).username.equals(name)) {
                if (userList.get(i).passhash.equals(hash)) {
                    return true;
                } else {
                    return false;
                }
            }

        }
        return false;
    }
}
