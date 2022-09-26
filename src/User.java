
// Import libraries >:-)
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/* 
public class User {

    private String username;
    private String passhash;

    private User() {

    }

    private static ArrayList<User> userList = new ArrayList<User>();

    User(String name, String pass) {
        username = name;
        passhash = Hashing.MD5Hash(pass);
        userList.add(this);
    }

    private static void addUser(String name, String hash){
        User tempUser = new User();
        passhash = Hashing.MD5

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
        return result;
    }

    public static void SingleUserToFile(String name, String pass) {
        try {

            File myFile = new File("myFile.txt");
            if (!myFile.exists()) {
                myFile.createNewFile();
            }
            FileWriter myFileWriter = new FileWriter(myFile, true);
            BufferedWriter myWriter = new BufferedWriter(myFileWriter);

            myWriter.write("Hej med dig\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ReadUserFile() {
        try {
            File myFile = new File("myFile.txt");
            FileReader myFileReader = new FileReader(myFile);
            BufferedReader myReader = new BufferedReader(myFileReader);
            
            String user, pass;
            while ((user = myReader.readLine()) != null) {
                pass = myReader.readLine();
                User newUser = new User(user, pass);
                addUser()
            }


            myReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
*/
/*

//Check if to strings are anagrams 
private static int CHARACTER_RANGE= 256;

public boolean isAnagramCounting(String string1, String string2) {
    if (string1.length() != string2.length()) {
        return false;
    }
    int count[] = new int[CHARACTER_RANGE];
    for (int i = 0; i < string1.length(); i++) {
        count[string1.charAt(i)]++;
        count[string2.charAt(i)]--;
    }
    for (int i = 0; i < CHARACTER_RANGE; i++) {
        if (count[i] != 0) {
            return false;
        }
    }
    return true;
}

 */