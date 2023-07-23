package Collections;

public class RecursionTest {

    public static void main(String[] args) {
        printnum(10);
    }

    private static void printnum(int i) {
        if(i>1){
            printnum(i-1);
        }
        System.out.println(i);
    }
}
