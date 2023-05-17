package AbstractionConcepts;

//Example of an abstract class that has abstract and non-abstract methods
abstract class Bike{
    Bike(){System.out.println("bike is created - it is constructor method");}
    abstract void run();
    void changeGear(){System.out.println("gear changed is a parent class concrete method");}
}
//Creating a Child class which inherits Abstract class
class Honda extends Bike{
    void run(){System.out.println("running Honda safely..");}
}


class Hero extends Bike{
    void run(){System.out.println("running Hero safely..");}
}


//Creating a Test class which calls abstract and non-abstract methods
class TestAbstraction2{
    public static void main(String args[]){
        Bike obj = new Honda();
        obj.run();
        obj.changeGear();
        System.out.println("--------------------------------------\n");
        Bike hero = new Hero();
        hero.run();
        hero.changeGear();
    }
}