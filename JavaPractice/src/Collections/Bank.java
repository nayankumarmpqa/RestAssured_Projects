package Collections;

interface Bank {
    float rateOfInterest();
}

class SBI implements Bank {
    public float rateOfInterest() {
        return 9.15f;
    }

    public String m1() {
        return "My SBI bank";
    }
}

class PNB implements Bank {
    public float rateOfInterest() {
        return 9.7f;
    }
}

class TestInterface2 {
    public static void main(String[] args) {
        Bank b = new SBI(); // Interface ref var and subclass object
        System.out.println("ROI: " + b.rateOfInterest());
        //System.out.println("ROI: "+b.m1()); // Cannot resolve method 'm1' in 'Bank'

        SBI s = new SBI(); // Subclass ref var and subclass object
        System.out.println("ROI: " + s.rateOfInterest());
        System.out.println("ROI: " + s.m1());


    }
}