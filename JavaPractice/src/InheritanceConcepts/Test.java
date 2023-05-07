package InheritanceConcepts;

class TestBase {
    int a = 10;

    void testBasef1() {
        System.out.println("f1 in base class");
    }
}

public class Test extends TestBase {

    int a = 20;
    void testBasef1() {
        System.out.println("f1 in child class");
    }

    public static void main(String[] args) {
        TestBase tb = new Test();
        System.out.println(tb.a);
        tb.testBasef1();

        System.out.println("------------------");
        Test test = new Test();
        System.out.println(test.a);
        test.testBasef1();


        System.out.println("------------------");
        TestBase tb2 = new TestBase();
        System.out.println(tb2.a);
        tb2.testBasef1();



    }
}


