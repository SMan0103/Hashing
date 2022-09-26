import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors


public class TPMain {
    public static void main(String[] args) {
        TrustpilotMD5.anagramToArray();
        //System.out.println(TrustpilotMD5.isAnagram("poultry outwits ants"));
        //System.out.println(TrustpilotMD5.lettersAvailable("poultryoutwitsants"));
        
        
        try {
          File myObj = new File("/Users/emilpedersen/Desktop/Hashing/wordlist.txt");
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            
            System.out.println(TrustpilotMD5.isAnagram(data));
            System.out.println(TrustpilotMD5.lettersAvailable(data));

          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
      
    }

}
