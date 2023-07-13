package Collections;

interface Bank {
    float rateOfInterest();

    default void msg() {
        System.out.println("default method in interface");
    }
}

class SBI implements Bank {
    public float rateOfInterest() {
        return 9.15f;
    }

    public String m1() {
        return "My SBI bank";
    }

    public void msg() {
        System.out.println("overridden msg method");
    }
}

//class PNB implements Bank {
//    public float rateOfInterest() {
//        return 9.7f;
//    }
//}

class TestInterface2 {
    public static void main(String[] args) {
        Bank b = new SBI(); // Interface ref var and subclass object
        System.out.println("ROI: " + b.rateOfInterest()); //ROI: 9.15
        b.msg(); //Prints Overridden default msg method
        //System.out.println(b.m1()); // Cannot resolve method 'm1' in 'Bank'

        SBI s = new SBI(); // Subclass ref var and subclass object
        System.out.println("ROI: " + s.rateOfInterest()); //ROI: 9.15
        s.msg(); //Prints Overridden default msg method
        System.out.println(s.m1());  //My SBI bank

    }
}