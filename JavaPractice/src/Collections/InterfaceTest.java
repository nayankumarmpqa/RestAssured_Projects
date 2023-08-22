package Collections;

interface DemoInterfaceclass {
    void m1();

    void m2();

    default void f1() {
        System.out.println("I am default method in interface");
    }
}


class InterfaceTestChild implements DemoInterfaceclass {

    @Override
    public void m1() {
        System.out.println("I am overridden m1");

    }

    @Override
    public void m2() {
        System.out.println("I am overridden m2");
    }

    public void m3() {
        System.out.println("I am child class m3 non overridden");
    }

}


public class InterfaceTest {
    public static void main(String[] args) {

        DemoInterfaceclass d = new InterfaceTestChild();

        d.m1();
        d.m2();
        d.f1(); // It ia a default method in interface
//       d.m3(); //Cannot resolve method 'm3' in 'DemoInterfaceclass'

//===================================================================
        InterfaceTestChild i = new InterfaceTestChild();

        i.m1();
        i.m2();
        i.f1(); // It ia a default method in interface
        i.m3();


    }

}


