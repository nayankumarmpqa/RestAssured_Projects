package Loops;

public class WhileNumberPlayer {
    private int number;

    public WhileNumberPlayer(int limit) {
        this.number = limit;
    }

    public void printSquareUtoLimit() {
        int i = 1;
        while (i * i < number) {
            System.out.print(i * i + " ");
            i++;
        }
        System.out.println();
    }

    public void printCureUtoLimit() {

        int i = 1;
        while (i * i * i < number) {
            System.out.print(i * i * i + " ");
            i++;
        }
        System.out.println();
    }
}

