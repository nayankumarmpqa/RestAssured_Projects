package Collections;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetInterface {

    public static void main(String[] args) {

        Set<String> set = Set.of("Apple", "Orange", "Banana", "Cat");

        System.out.println(set);


        Set<String> hs = new HashSet<>(set);
        System.out.println(hs);
        hs.add(null);
        System.out.println(hs.add(null));
        System.out.println(hs);


        TreeSet<Integer> ts = new TreeSet<>(List.of(78,98,54,78,65,54,135,31,12,48,54));
        System.out.println(ts);
        System.out.println(ts.floor(12));
        //floor Returns the greatest element less than or equal to e, or null if there is no such element
        System.out.println(ts.lower(12));
        //lower Returns the greatest element less than e, or null if there is no such element
        System.out.println(ts.ceiling(12));
        //Returns the least element greater than or equal to e, or null if there is no such element
        System.out.println(ts.higher(12));
        //Returns:
        //the least element greater than e, or null if there is no such element
        System.out.println(ts.subSet(12,78));

        System.out.println(ts.subSet(12,78));

        System.out.println(ts.subSet(10,true, 78, true));


        System.out.println(ts.headSet(54)); // before 54 excluding 54
        System.out.println(ts.tailSet(54)); // after 54 including 54
    }
}

/*
No insertion order in Set, HS, but LinkedHS retains insertion order
No duplicate allowed return false
Only one null can be added other return false but no error


TreeSet stores in sorted order
 */