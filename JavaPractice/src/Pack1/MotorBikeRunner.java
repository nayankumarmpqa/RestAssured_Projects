package Pack1;

public class MotorBikeRunner {
    public static void main(String[] args) {
        MotorBike ducati = new MotorBike();
        MotorBike honda = new MotorBike();
        ducati.start();
        honda.start();

        //speed = 100;  //I am changing the speed of ducati object
        // it is also accessing the variables of object which is not good for encapsulation
        // so we should make the var private
        //honda.speed = 80;

        ducati.setSpeed(100);

        //increasing the ducati speed
        //it is another benefit of encapsulation
        int ducatiSpeed = ducati.getSpeed();
        ducatiSpeed = ducatiSpeed+100;
        ducati.setSpeed(ducatiSpeed);


//        honda.setSpeed(80);


//        ducati.speed = 20;
//        honda.speed = 0;

//        ducati.setSpeed(20);
//        honda.setSpeed(0);

        System.out.println(ducati.getSpeed());




    }


}
