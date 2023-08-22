package Collections;

import java.util.*;

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
            System.out.print(" " + s);
        }
        System.out.println("\n" + "*****************");
        Iterator<String> it = sal.iterator();

        while (it.hasNext()) {
            System.out.print(" " + it.next());
        }

        sal.get(1);
        sal.getClass();

        LinkedList<String> ll = new LinkedList<>();
        ll.add("Ravi");
        ll.add("Vijay");
        ll.add("Ravi");
        ll.add("Ajay");
        ll.add(null);
        ll.add("test");
        ll.add(null);
        System.out.println("\n" + "*****************");

        System.out.println("Linked List " + ll);
        System.out.println(ll.get(1));
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());
        System.out.println(ll.getClass());

        System.out.println("***************************");

        //OR we can use for each loop
        for (String item : ll) {
            System.out.print(" " + item);
        }
        //or we can use Iterator
        System.out.println("\n" + "***************************");
        Iterator<String> itr = ll.iterator();
        while (itr.hasNext()) {
            System.out.print(" " + itr.next());
        }


        //********************************
        System.out.println("\n" + "***************************");

        Vector<String> vc = new Vector<>();
        vc.add("Ravi");
        vc.add("Vijay");
        vc.add("Ravi");
        vc.add("Ajay");
        vc.add(null);
        vc.add("test");
        vc.add(null);

        System.out.println(vc);


        Iterator<String> it2 = vc.iterator(); //[Ravi, Vijay, Ravi, Ajay, null, test, null]
        it2.next(); //It returns the element and moves the cursor pointer to the next element.
        it2.next(); //It returns the element and moves the cursor pointer to the next element.
        it2.remove(); //It removes the last elements returned by the iterator. i.e. Vijay
        System.out.println(vc);         //[Ravi, Ravi, Ajay, null, test, null]

        //********************************
        System.out.println("\n" + "***************************");

        Stack<String> st = new Stack<>(); //Stack implements the last-in-first-out data structure
        st.add("sRavi");
        st.add("sVijay");
        st.add("sRavi");
        st.add("sAjay");
        st.add(null);
        st.add("stest");
        st.add(null);
        st.push("pushmethod");
        System.out.println(st);
        st.pop(); //It implements the last-in-first-out data structure

        System.out.println(st); // james clear

        System.out.println(System.nanoTime());
        System.out.println(System.nanoTime());
    }
}
