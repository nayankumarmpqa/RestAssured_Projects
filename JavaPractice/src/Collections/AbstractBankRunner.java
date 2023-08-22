package Collections;

abstract class AbstractBank {
    abstract float abstractRateOfInterest();
    void concreteMethod() {
        System.out.println("concrete method in abstract/Base class");
    }
}

class SBI2 extends AbstractBank {
    public float abstractRateOfInterest() {
        return 9.15f;
    }
    public void concreteMethod() {
        System.out.println("overridden concrete method");
    }
    public String childClassMethod() {        return "Child class method";    }
}

class AbstractBankRunner {
    public static void main(String[] args) {
        AbstractBank b = new SBI2(); // Abstract class ref var and subclass object
        System.out.println
                ("ROI: " + b.abstractRateOfInterest()); //implemented ROI: 9.15
        b.concreteMethod(); // prints overridden concrete method
        // b.childClassMethod();  //Cannot resolve method 'childClassMethod' in 'AbstractBank'

//-------------------------------------------------------------------------
        SBI2 s = new SBI2(); // Subclass ref var and subclass object
        System.out.println("ROI: " + s.abstractRateOfInterest()); //implemented ROI: 9.15
        s.concreteMethod(); // prints overridden concrete method
        System.out.println(s.childClassMethod()); // prints Child class method

    }
}