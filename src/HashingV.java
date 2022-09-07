
// 2 minutter til at vi har fri ret poggers
//import java library math
import java.lang.Math;

public class HashingV {

    public static void main(String[] args) throws Exception {
        long startTime, endTime;
        int listSize = 2000000;
        int myList[] = new int[listSize];
        int number; // random number
        int numberPos; // position of random number in array

        for (int i = 0; i < 1000000; i++) {
            number = (int) (Math.random() * 100000 + 1);
            numberPos = (int) (((long) number * number) % listSize);

            // Check if number is already in array
            while (myList[numberPos] != 0) {
                if (numberPos == listSize - 1) {
                    numberPos = 0;
                }
            }
            myList[numberPos] = number;
        }

        startTime = System.nanoTime();
        // find and print all number in the list equal to 117
        number = 117;
        numberPos = (int) (((long) number * number) % listSize);
        while (myList[numberPos] != 0) {
            if (myList[numberPos] == number) {
                System.out.println("Number found at position " + number);
                numberPos = (numberPos + 1) % listSize;
                while (myList[numberPos] != 0) {
                    if (numberPos == listSize - 1) {
                        numberPos = 0;
                    }
                }

            }

            endTime = System.nanoTime();
            System.out.println("Time taken," + ((endTime - startTime) / 100000d) + " ms.");

        }
    }
}