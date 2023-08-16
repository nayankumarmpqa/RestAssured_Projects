package Exceptioandaling;

public class ExceptionRunner {

    public static void main(String[] args) {
        method1();
        System.out.println("main ended");// will not execute
    }
    private static void method1() {
        method2();
        System.out.println("m1 ended"); // will not execute
    }
    private static void method2() {
        String string = null;
        string.length();
        System.out.println("m2 ended");// will not execute
    }
}


/*
Output

Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "string" is null
	at Exceptioandaling.ExceptionRunner.method2(ExceptionRunner.java:15)
	at Exceptioandaling.ExceptionRunner.method1(ExceptionRunner.java:10)
	at Exceptioandaling.ExceptionRunner.main(ExceptionRunner.java:6)
 */