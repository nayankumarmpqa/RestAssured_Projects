package Loops;

public class BreakAndContinue {
    public static void main(String[] args) {

        for(int i=1;i<=10; i++){
            if(i==5){
                break;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        // break example
        for(int i=1;i<=10; i++){
            if(i%2==0){
                break;
            }
            System.out.print(i + " ");
        }
        System.out.println();


        // continue example for Odd numbers printing
        for(int i=1;i<=10; i++){
            if(i%2==0){
                System.out.print("_");
                continue;
            }
            System.out.print(i);
        }
        System.out.println();
        // continue example for Even  numbers printing
        for(int i=1;i<=10; i++){
            if(i%2!=0){
                System.out.print("_");
                continue;
            }
            System.out.print(i);
        }
    }
}
