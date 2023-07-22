package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListInterfaceTest {

    public static void main(String[] args) {
        List<String> namesList = List.of("Nayan", "Rupali", "Myra");
        List<String> al = new ArrayList<>(namesList);
        System.out.println(al);


        ArrayList<String> sal = new ArrayList<>();
        sal.add("Nayan");
        sal.add("Nayan");
        sal.add(null);
        sal.add(null);
        sal.add("Rupali");
        sal.add("Myra");
        sal.add("Aaradhya");
        System.out.println(sal);

        System.out.println("*****************");

        for (String s : sal) {
            System.out.print(" "+s);
        }
        System.out.println("\n"+"*****************");
        Iterator<String> it = sal.iterator();

        while (it.hasNext()){
            System.out.print(" "+it.next());
        }


        LinkedList<String> ll = new LinkedList<>();
        ll.add("Ravi");
        ll.add("Vijay");
        ll.add("Ravi");
        ll.add("Ajay");
        ll.add(null);
        ll.add("test");
        ll.add(null);
        System.out.println("\n"+"*****************");

        System.out.println(ll);

        System.out.println("***************************");

        //OR we can use for each loop
        for(String item:ll){
            System.out.print(" "+item);
        }
        //or we can use Iterator
        System.out.println("\n"+"***************************");
        Iterator<String> itr = ll.iterator();
        while(itr.hasNext()){
            System.out.print(" "+itr.next());
        }
    }
}
