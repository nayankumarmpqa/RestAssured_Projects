package Pack1;

public class MotorBikeRunner {
    public static void main(StringConcepts[] args) {
        MotorBike ducati = new MotorBike();
        MotorBike honda = new MotorBike();
        ducati.start();
        honda.start();

        //speed = 100;  //I am changing the speed of ducati object
        // it is also accessing the variables of object which is not good for encapsulation
        // so we should make the var private
        //honda.speed = 80;
//        ducati.setSpeed(100);

        //increasing the ducati speed
        //it is another benefit of encapsulation
//        int ducatiSpeed = ducati.getSpeed();
//        ducatiSpeed = ducatiSpeed+100;
//        ducati.setSpeed(ducatiSpeed);
//
//        //increasing the honda speed
//        int hondaSpeed = ducati.getSpeed();
//        hondaSpeed = hondaSpeed+100;
//        ducati.setSpeed(hondaSpeed);

        System.out.println(ducati.getSpeed());
        System.out.println(honda.getSpeed());


        ducati.increaseSpeed(50);
        ducati.decreaseSpeed(5);

        System.out.println(ducati.getSpeed());

        honda.increaseSpeed(60);
        honda.decreaseSpeed(3);

        System.out.println(honda.getSpeed());


    }


}
