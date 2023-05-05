package ArrayAndArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraylistTest {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList();
        al.add("apple");
        al.add("1");

        al.remove(1);


        System.out.println(al);

        String s = "My Name is Nayan";
        System.out.println(s.contains("i"));
        System.out.println(s.substring(0,5));
        String newString = s.replace('N','T');
        System.out.println(newString);


        String[] sa = { "My name is Nayan","Lalu"};;
        System.out.println(sa);
        System.out.println(Arrays.toString(sa));

        Arrays.sort(sa);

        System.out.println( Arrays.toString(sa));
        String[] a2 = { "My name is Nayan","Lalu"};
        // comparing after sorting sa
        System.out.println(Arrays.equals(sa, a2));

    }


}
