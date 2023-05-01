package ArrayAndArrayList;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class ArraysTest {

    public static void main(String[] args) {
        int[] m = {1,2,3,4,5};
        System.out.println(m[0]);

        int[] marks = new int[3];
        System.out.println(marks.length);
        System.out.println(marks);
        System.out.println(Arrays.toString(marks));

        int[] myMarks = {100,99,98,97,96,95};
        for(int item:myMarks){
            System.out.print(item + " ");
        }

        int[] tofill = new int[5];
        Arrays.fill(tofill, 100);
        for(int item:tofill){
            System.out.print(item + " ");
        }


        //Compare Arrays
        int[] a = {1,2,3};
        int[] b = {1,2,3};
        int[] c = {1,2,3,4};
        int[] d = {3,2,1,5,8,9,5};

        System.out.println(Arrays.equals(a,b));

        System.out.println(Arrays.equals(a,c));

        System.out.println(Arrays.toString(d));

        Arrays.sort(d);

        System.out.println(Arrays.toString(d));

        int sum=0;
        for(int item: d){
            sum = sum +item;
        }            System.out.println("sum is " + sum);

int maximum =Integer.MIN_VALUE;
        System.out.println("Integer.Min_Value" + maximum);
        for (int item: d){
            if (item>maximum){
                maximum=item;
            }
        }
        System.out.println(maximum);


        int minimum =Integer.MAX_VALUE;
        System.out.println("Integer.Max_Value" + minimum);
        for (int item: d){
            if (item<minimum){
                minimum=item;
            }
        }
        System.out.println(minimum);

        BigDecimal average = new BigDecimal(sum/d.length);
        System.out.println("average is = " + average);

        int deviser = d.length;
        BigDecimal average2 = new BigDecimal(sum).divide(new BigDecimal(deviser),3, RoundingMode.DOWN);
        System.out.println("average is = " + average2);
    }
}
