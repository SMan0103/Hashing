import java.util.Scanner;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.io.File; // Import the File class
import java.io.IOException; // Import the IOException class to handle errors
import java.io.FileWriter; // Import the FileWriter class
import java.io.BufferedWriter; // Import BufferedWriter who would've guessed
import java.io.BufferedReader; // Import BufferedReader who would've guessed

public class Login {
    // Create user login

    // define MD5 Hashing method

    public static String MD5Hash(String s) {
        String result = "";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());
            result = new BigInteger(1, md.digest()).toString(16);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String password = "";
        String username = "";

        System.out.println("Create user or login\n");
        System.out.println("1. Create user\n");
        System.out.println("2. Login\n");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) { // if a user wants to create a new user
            System.out.println("You have chosen to create a user");

            System.out.println("Enter username");
            username = input.next();

            System.out.println("Enter password");
            password = Login.MD5Hash(input.next());

            System.out.println("Enter password again");
            String password2 = Login.MD5Hash(input.next());

            if (password.equals(password2)) {
                System.out.println("User created");
                System.out.println(password + "\n" + password2);
            } else {
                System.out.println("Passwords do not match");
            }

        } else if (choice == 2) { // if a user want to login with an existing user
            System.out.println("Login");

            System.out.println("Enter username");
            username = input.next();

            System.out.println("Enter password");
            password = input.next();

            System.out.println("Login successful");
        } else { // if a user enters a number that is not 1 or 2
            System.out.println("Invalid input");
        }

        // System.out.println("test");
        try {
            File myObj = new File("savePasswordsDemo.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }

        try {
            FileWriter myWriter = new FileWriter("savePasswordsDemo.txt");
            BufferedWriter passwordWriter = new BufferedWriter(myWriter);

            passwordWriter.write(username + "\n");
            passwordWriter.write(password + "\n");

            passwordWriter.close();

            // myWriter.write(username + "\n" + password + "\n");
            // https://www.guru99.com/buffered-reader-in-java.html
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
