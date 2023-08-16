package Exceptioandaling;

import javax.print.attribute.standard.OrientationRequested;

public class ExceptionRunner2 {

    public static void main(String[] args) {
        method1();
        method3();
        System.out.println("main ended");

    }

    private static void method1() {
        method2();
        System.out.println("m1 ended");
    }

    private static void method2() {
        try {
            String string = null;
            string.length();
            System.out.println("m2 ended");// will not execute
        } catch (NullPointerException e) {
            //not doing anything
            //OR
            System.out.println("NullPointerException itis");
            e.printStackTrace();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private static void method3() {
        try {
            int[] a = {1, 2};
            int num = a[2];
            System.out.println("m3 ended");// will not execute
        } catch (NullPointerException e) {
            //not doing anything
            //OR
            System.out.println("NullPointerException itis");
            e.printStackTrace();

        }catch (ArrayIndexOutOfBoundsException aex) {
            System.out.println("Matched ArrayIndexOutOfBoundsException class for method3");
            aex.printStackTrace();
        }
        catch (Exception ex) {
            System.out.println("Matched Exception class for method3");
            ex.printStackTrace();
        }

    }
}


/*
Output

Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "string" is null
	at Exceptioandaling.ExceptionRunner.method2(ExceptionRunner.java:15)
	at Exceptioandaling.ExceptionRunner.method1(ExceptionRunner.java:10)
	at Exceptioandaling.ExceptionRunner.main(ExceptionRunner.java:6)
 */