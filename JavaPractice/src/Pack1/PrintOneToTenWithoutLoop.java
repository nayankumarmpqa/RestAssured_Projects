package Pack1;

public class PrintOneToTenWithoutLoop {
    static void printNum(int num){
        if (num>1){
            printNum(num-1);
        }
        System.out.println(num);
    }

    public static void main(String[] args) {
        printNum(3);

    }
}

/*
Great understanding
https://youtu.be/yLaYW7dmsfo
 */