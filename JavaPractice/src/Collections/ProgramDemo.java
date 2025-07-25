package Collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProgramDemo {

    public static void main(String[] args) {

        int[] arr = {1,2,3,2,4,5,6,5,3,4,7,8,9,2};
        Set<Integer> set = new HashSet<>();
        for(int  arrItem : arr){
            if (!set.add(arrItem)){
                System.out.println("duplicate arr "+ arrItem);
            }
        }

        String s ="hello";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.reverse());


        //3. Palindrome Check
        String s1 = "madam";
        StringBuilder sb1 = new StringBuilder(s1).reverse();
        boolean b1 = s1.contentEquals(sb1);
        boolean b2 = s1.equals(sb1.toString());
        System.out.println(b1);
        System.out.println(b2);

        //4
        String s3 = "aabbcc";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s3.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);


        //5

        //        6. Swap Two Numbers Without Third Variable
        int a = 5, b = 10;
        System.out.println(a +" "+b);
        a = a + b; b = a - b; a = a - b;
        System.out.println(a +" "+b);

       // 7. Find Missing Number in Array

        int[] arrr = {1,2,4,5};
        int n = 5; // total numbers
        int sum = n*(n+1)/2;
        System.out.println("the value of sum is " + sum);
        for (int num : arrr)
            sum -= num;
        System.out.println("Missing number: " + sum);
    }
}
