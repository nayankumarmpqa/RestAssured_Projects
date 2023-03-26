package Pack1;

public class BiNumber {
    int num1;
    int num2;
    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }



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

    public void doubleIt() {
        this.num1 *=2;
        this.num2*=2;

    }

}
