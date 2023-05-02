package ArrayAndArrayList;

import java.util.Arrays;

public class VarargsTest {

    static void sum(int... marks) {
        System.out.println(Arrays.toString(marks));
    }

    static int sumArray(int... marks) {
        int sum = 0;
        for (int mark : marks) {
            sum = sum + mark;
        }
        sum(marks);
        return sum;
    }

    public static void main(String[] args) {
        sum(1, 2, 3, 4);
        int i = sumArray(45, 5, 4, 87, 978, 45);
        System.out.println(i);


    }
}
