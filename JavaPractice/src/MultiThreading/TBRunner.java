package MultiThreading;

class Task1 extends Thread{
    public void run(){ // It is the signature
        System.out.println("\n Task1 Started ");
        for (int i=101; i<199; i++){
            System.out.print(i + " ");
        }
        System.out.println("\n Task1 Done \n");

    }
}

class Task2 implements Runnable{
    public void run(){ // It is the signature
        System.out.println("\n Task2 Started ");
        for (int i=201; i<299; i++){
            System.out.print(i + " ");
        }
        System.out.println("\n Task2 Done \n");

    }
}

public class TBRunner {

    public static void main(String[] args) {
        System.out.println("\n Task1 Kicked OFF \n");

        Task1 task1 = new Task1();
        task1.start();

        System.out.println("\n Task2 Kicked OFF \n");
        Task2 task2 = new Task2();
        Thread task2Thread = new Thread(task2);
        task2Thread.start();



        System.out.println("\n Task3 Kicked OFF \n");
        for (int i=301; i<399; i++){
            System.out.print(i + " ");
        }
        System.out.println("\n Task3 Done \n");

        System.out.println(" Main completed");
    }
}
