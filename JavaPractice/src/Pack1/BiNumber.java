package Pack1;

public class BiNumber {
    int num1, num2;

    public BiNumber(int num1, int num2) {
        this.num1=num1;
        this.num2=num2;
    }


    public int add() {
            return num1+num2;
    }

    public int multiply() {
        return num1*num2;
    }

    public int doubleIt() {
        return 2*num1;

    }

    public void getNumber1() {
        System.out.println(num1);
    }

    public void getNumber2() {
        System.out.println(num2);
    }
}
