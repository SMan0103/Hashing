
//import java library math
import java.lang.Math;

public class App {
    public static void main(String[] args) throws Exception {

        // define array
        int myList[];

        // define variable i as 0 for ease of use in later for loops
        int i = 0;

        // define variables for time
        long startTime, endTime;

        // fill array with 100001 random numbers with min value 1 and max value 100.001
        myList = new int[1000000];
        for (i = 0; i < 1000000; i++) {
            myList[i] = (int) (Math.random() * 100001 + 1);
            // if (myList[i] == 117){count++} // IDK if this would be faster? if yes then
            // add "int count = 0" before for loop
        }

        startTime = System.nanoTime();

        // count number of occurences of the number 117
        int count = 0;
        for (i = 0; i < 1000000; i++) {
            if (myList[i] == 117) {
                count++;
            }
        }
        // print number of occurences of 117
        System.out.println("Number of occurences of 117: " + count);

        endTime = System.nanoTime();
        System.out.println("Time taken," + ((endTime - startTime) / 100000d) + " ms.");
    }
}
