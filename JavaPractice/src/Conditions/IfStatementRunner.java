package Conditions;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class IfStatementRunner {
    public static void main(String[] args) {
        System.out.print("Enter number 1:");
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        System.out.println("you entered: " + num1);

        System.out.print("Enter number 2:");
        int num2 = sc.nextInt();

        System.out.println("you entered: " + num2);

        System.out.println("Choices are follwoing : ");
        System.out.println("1 - Add");
        System.out.println("2 - Sub");
        System.out.println("3 - Divide");
        System.out.println("4 - Multiply");

        System.out.println("Make a choice Please!");
        int choice = sc.nextInt();

        System.out.println("1st num is = " + num1);
        System.out.println("2nd num is = " + num2);
        System.out.println("Your selected operation is = " + choice);


        //performOperationWithNestedIfElse(num1, num2, choice);
        performOperationWithSwitchCase(num1, num2, choice);


    }

    private static void performOperationWithNestedIfElse(int num1, int num2, int choice) {
        if (choice == 1) {
            System.out.println("Result is = " + (num1 + num2));
        } else if (choice == 2) {
            System.out.println("Result is = " + (num1 - num2));
        } else if (choice == 3) {
            System.out.println("Result is = " + (num1 / num2));
        } else if (choice == 4) {
            System.out.println("Result is = " + (num1 * num2));
        } else {
            System.out.println("Invalid operation/option " + choice);
        }
    }


    private static void performOperationWithSwitchCase(int num1, int num2, int choice) {

        switch (choice) {
            case 1:
                System.out.println("Result is = " + (num1 + num2));
                break;
            case 2:
                System.out.println("Result is = " + (num1 - num2));
                break;
            case 3:
                System.out.println("Result is = " + (num1 / num2));
                break;
            case 4:
                System.out.println("Result is = " + (num1 * num2));
                break;
            default:
                System.out.println("Invalid operation/option " + choice);
                break;
        }
    }
}
