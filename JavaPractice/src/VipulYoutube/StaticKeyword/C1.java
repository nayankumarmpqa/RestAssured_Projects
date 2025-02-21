package VipulYoutube.StaticKeyword;


class C{
    public int i;

    public static int a;  //static variable

    public C(){        // constructor

        a++;
    }

    public void m1(){       /// normal method
        System.out.println("normal public method");
    }

    public static void m2(){
        // static mehtod
        System.out.println("it is a static method");
    }

    static {
        // it is a static block
        System.out.println("I am a static block");
    }


}

public class C1 {

    public static void main(String[] args) {
        C c1 = new C();
        C c2 = new C();
        C c3 = new C();
        C c4 = new C();
        C c5 = new C();
        System.out.println("number of objects are = " + C.a);  // counting objects using statis variable
        C.m2();  // Calling static mehod

        System.out.println(c5.i);
        c5.m1();
    }


}
