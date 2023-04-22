package Pack1;

public class Bank_MethodOverriding {


    int getRateOfInterest() {
        return 0;
    }
}

//Creating child classes.
class SBI extends Bank_MethodOverriding {
    int getRateOfInterest() {
        return 8;
    }
}

class ICICI extends Bank_MethodOverriding {
    int getRateOfInterest() {
        return 7;
    }
}

class AXIS extends Bank_MethodOverriding {
    int getRateOfInterest() {
        return 9;
    }
}

//Test class to create objects and call the methods
class Test2 {
    public static void main(String args[]) {
        SBI s = new SBI();
        ICICI i = new ICICI();
        AXIS a = new AXIS();
        System.out.println("SBI Rate of Interest: " + s.getRateOfInterest());
        System.out.println("ICICI Rate of Interest: " + i.getRateOfInterest());
        System.out.println("AXIS Rate of Interest: " + a.getRateOfInterest());
    }
}

/*
If the superclass method does not declare an exception
If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception but it can declare unchecked exception.
If the superclass method declares an exception
If the superclass method declares an exception, subclass overridden method can declare same, subclass exception or no exception but cannot declare parent exception.
 */
