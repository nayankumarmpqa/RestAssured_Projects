package Collections;

class BaseBank {
        void concreteMethod() {
        System.out.println("concrete method in Base class");
    }
}

class SBI3 extends BaseBank {
    public void concreteMethod() {
        System.out.println("overridden concrete method");
    }
    public String childClassMethod() {        return "Child class method";    }
}

class ExtendedBankRunner {
    public static void main(String[] args) {
        BaseBank b = new SBI3(); // Abstract class ref var and subclass object

        b.concreteMethod(); // prints overridden concrete method
        //b.childClassMethod();  //Cannot resolve method 'childClassMethod' in 'AbstractBank'

//-------------------------------------------------------------------------
        SBI3 s = new SBI3(); // Subclass ref var and subclass object

        s.concreteMethod(); // prints overridden concrete method
        System.out.println(s.childClassMethod()); // prints Child class method

    }
}