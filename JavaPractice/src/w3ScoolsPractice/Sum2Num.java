package w3ScoolsPractice;

import java.util.Scanner;

public class Sum2Num
{
    public static void main(String[] r){
        System.out.println();
        int a, b, sum;
        Scanner sc = new Scanner(System.in);
        System.out.print("enter n1");
        a = sc.nextInt();
        System.out.print("Enter n2");
        b = sc.nextInt();
        sum = a+b;
        System.out.println("sum = " + sum);
       // sc.close();
        System.out.println("---------------------divide------------");

        int c, d , e;
        System.out.print("enter num");
        c = sc.nextInt();
        System.out.print("Enter num");
        d = sc.nextInt();

        e=c/d;
        System.out.println("After divideing it is = " + e);

        System.out.println("---------------------Print the result of the specified operations-----------------");

        int w = -5+8*6;
        int x = (55+9)%9;
        int y = 20+(-3*5/8);
        int z= 5+15/3*2-8%3;


        System.out.print(w + "\n" + x+ "\n" + y+ "\n" + z);



    }
}