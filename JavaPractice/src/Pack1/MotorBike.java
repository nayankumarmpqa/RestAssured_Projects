package Pack1;

public class MotorBike {
//state means variable
    private int speed; //instance variable or member variable
    //private is a access modifier
    // so create a method to set the speed value

    void setSpeed(int speed){ //local variable

        if(speed>0) {
            System.out.println("local variabel " + speed); //printing local variable
            this.speed = speed;
        }
        else{
            System.out.println("negaive number");
        }

    }

    public int getSpeed() {
        return this.speed;
    }

    void start(){
        System.out.println("Bike Started");

    }

    public void increaseSpeed(int howMuch) {

        setSpeed(this.speed + howMuch);

    }

    public void decreaseSpeed(int howMuch){

        setSpeed(this.speed - howMuch);

    }
}
