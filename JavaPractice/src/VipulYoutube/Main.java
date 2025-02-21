package VipulYoutube;

class Parent {

    int a = 10;
    void parentMethod() {
        System.out.println("Parent class method");
    }

    void f1() {
        System.out.println("Parent class F1 method");
    }
}

class Child extends Parent {
    int a = 20;

    void childMethod() {
        System.out.println("Child class method");
    }
    @Override
    void f1() {
        System.out.println("Child class F1 overridden method");
    }
}

public class Main {
    public static void main(String[] args) {
        // ✅ It is Upcasting in polymorphism
        Parent p = new Child();  // It is Upcasting
        p.f1();                     // Calls child's overridden method
        p.parentMethod();           // Calls Parent's method (as it's not overridden)
        System.out.println(p.a);    // prints Parent's int a

        //------------------------------------
        // ✅ it is down-casting
        Child c = (Child) p; // it is down-casting
        System.out.println(c.a); // used down casting and prints Child's int a


    }
}
