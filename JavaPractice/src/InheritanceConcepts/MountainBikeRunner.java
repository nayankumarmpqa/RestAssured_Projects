package InheritanceConcepts;

public class MountainBikeRunner {

    public static void main(String args[])
    {

        // using subclass reference( )
        // second approach
        MountainBike childToChild = new MountainBike(3, 100, 25);

        System.out.println("seat height of first bicycle before set height is "
                + childToChild.seatHeight);

        childToChild.setHeight(35);

        System.out.println("seat height of first bicycle after set height is "
                + childToChild.seatHeight+"\n" );

        // In case of overridden methods
        // always subclass
        // method will be executed
        System.out.println(childToChild.toString());
        System.out.println("-----------------------------");

        // using superclass reference
        // first approach
        Bicycle parentToChild = new MountainBike(4, 200, 20);

        // In case of overridden methods
        // always subclass
        // method will be executed
        System.out.println(parentToChild.toString());

        /* The following statement is invalid because Bicycle
        does not define a seatHeight.*/
       // System.out.println("seat height of second bicycle is "+ parentToChild.seatHeight);

        /* The following statement is invalid because Bicycle
        does not define setHeight() method.*/
        //parentToChild.setHeight(21);

        //https://www.geeksforgeeks.org/referencing-subclass-objects-subclass-vs-superclass-reference/

    }
}
