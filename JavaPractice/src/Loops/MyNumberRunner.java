package Loops;

public class MyNumberRunner {
    //Prime numbers are natural numbers that are divisible by only 1 and the number itself.
    // In other words, prime numbers are positive integers greater than 1 with exactly two factors, 1 and the number itself.
    // Some of the prime numbers include 2, 3, 5, 7, 11, 13, etc. Always remember that 1 is neither prime nor composite.

    public static void main(String[] args) {

        MyNumber n = new MyNumber(11);
        boolean isPrime = n.isPrime();
        System.out.println("isPrime = " + isPrime);
    }
}
