package Exceptioandaling;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class FinallyRunner {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);

            int[] numbers = {12, 1, 5, 4};
            int number = numbers[5];

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catched ArrayIndexOutOfBoundsException in the try block");

        } finally { // this code will always executed
            System.out.println("Before Scanner close");
            //to be safe that all the objects of scanner are closed
            if (scanner != null) {
                scanner.close();
            }
        }

        System.out.println("Just before closing main");


    }

}


/*
Output

java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 4
	at Exceptioandaling.FinallyRunner.main(FinallyRunner.java:14)
catched ArrayIndexOutOfBoundsException in the try block
Before Scanner close
Just before closing main
 */