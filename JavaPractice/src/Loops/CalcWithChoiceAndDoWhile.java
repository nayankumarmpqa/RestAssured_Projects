package Loops;

import java.util.Scanner;

public class CalcWithChoiceAndDoWhile {
    public static void main(String[] args) {
        int choice=-1;
        do{
            Scanner sc = new Scanner(System.in);

            if (!(choice<0)){
                System.out.println("Your selected operation is = " + choice);

                System.out.print("Enter number 1:");
                int num1 = sc.nextInt();
                System.out.println("you entered: " + num1);

                System.out.print("Enter number 2:");
                int num2 = sc.nextInt();
                System.out.println("you entered: " + num2);

                //performOperationWithNestedIfElse(num1, num2, choice);
                performOperationWithSwitchCase(num1, num2, choice);
            }
            System.out.println("Choices are following : ");
            System.out.println("1 - Add");
            System.out.println("2 - Sub");
            System.out.println("3 - Divide");
            System.out.println("4 - Multiply");

            System.out.println("Make a choice Please!");
            choice = sc.nextInt();

        }while(choice>0&&choice<4);

        System.out.println("Invalid choice, Thank you!");

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


//Turnary Operator Syntax
// result = (condition ? expression-if-condition-true : expression:if-condition-false);