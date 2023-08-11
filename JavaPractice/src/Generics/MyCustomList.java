package Generics;

import javax.swing.*;
import java.util.ArrayList;

public class MyCustomList <T>{

    ArrayList<T> al = new ArrayList<>();

    public void addElement(T element){
        al.add(element);
    }


    public void removeElement(T element){
        al.remove(element);
    }


    @Override
    public String toString() {
        return al.toString();
    }

    public T get(int i) {
        return al.get(i);
    }
}
