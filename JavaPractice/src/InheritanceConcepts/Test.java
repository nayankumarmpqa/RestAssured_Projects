package InheritanceConcepts;

class TestBase {
    int a = 10;

    void testBasef1() {
        System.out.println("f1 in base class");
    }

    void tb2(){
        System.out.println("tb2 from base class");
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
        tb.tb2();
/*
10
f1 in child class
tb2 from base class
 */
        System.out.println("------------------");
        Test test = new Test();
        System.out.println(test.a);
        test.testBasef1();
        test.tb2();

        /*
20
f1 in child class
tb2 from base class
         */

        System.out.println("------------------");
        TestBase tb2 = new TestBase();
        System.out.println(tb2.a);
        tb2.testBasef1();
        tb2.tb2();

/*
10
f1 in base class
tb2 from base class
 */
    }
}
