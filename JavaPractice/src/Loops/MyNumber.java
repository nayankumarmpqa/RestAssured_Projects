package Loops;

public class MyNumber {
    private int number;

    public MyNumber(int givenNumber) {
        this.number = givenNumber;
    }


    public boolean isPrime() {

        //Guard check - because 1 is neither prime nor composite
        if(number<2){
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
