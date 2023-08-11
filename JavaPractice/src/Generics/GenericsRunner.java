package Generics;

public class GenericsRunner {

    public static void main(String[] args) {

        MyCustomList<String> list = new MyCustomList<>();

        list.addElement("String1");
        list.addElement("String2");
        list.removeElement("String2");
        System.out.println(list);

       String s =  list.get(0);
        System.out.println(s);

        MyCustomList<Integer> list2 = new MyCustomList<>();
        list2.addElement(5);
        list2.addElement(6);
        System.out.println(list2);
        Integer i = list2.get(0);
        System.out.println(i);
    }
}
