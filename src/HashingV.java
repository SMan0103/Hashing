
// Comments
// er jeg den eneste der føler at det her er på grænsen til nemt?
//import java library math
import java.lang.Math;

public class HashingV {

    public static void main(String[] args) throws Exception {
        String result = "";

        long startTime, endTime;
        int listSize = 2000000;
        int myList[] = new int[listSize];
        int number; // random number
        int numberPos; // position of random number in array

        for (int i = 0; i < 1000000; i++) {
            number = (int) (Math.random() * 100000 + 1);
            // Define number position?
            numberPos = (int) (((long) number * number) % listSize);

            // Check if number is already in array
            while (myList[numberPos] != 0) {

                numberPos = (numberPos + 1) % listSize;
            }
            myList[numberPos] = number;
        }

        startTime = System.nanoTime();
        // find and print all number in the list equal to 117
        number = 117;
        numberPos = (int) (((long) number * number) % listSize);
        while (myList[numberPos] != 0) {
            // vi mangler at angive result til et variabel
            if (myList[numberPos] == number)
                result += number + ", ";
            numberPos = (numberPos + 1) % listSize;

        }
        endTime = System.nanoTime();
        System.out.println(result);
        System.out.println("Time taken: " + ((endTime - startTime) / 100000d) + " ms");
    }
}