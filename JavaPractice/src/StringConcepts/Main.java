package StringConcepts;
// The Main class is public and has the main method to start the program
public class Main {

    // Public variable accessible from anywhere
    public static int publicVariable = 10;

    // Private variable can only be accessed within this class
    private static int privateVariable = 20;

    // Default (package-private) variable can be accessed within the same package
    static int defaultVariable = 30;

    // Protected variable can be accessed within the same package and by subclasses
    protected static int protectedVariable = 40;

    // Static method can be called without creating an instance of the class
    public static void main(String[] args) {
        System.out.println("Accessing variables:");

        // Accessing public variable
        System.out.println("Public Variable: " + publicVariable);

        // Accessing private variable (will cause an error because it's private)
        // System.out.println("Private Variable: " + privateVariable);

        // Accessing default (package-private) variable
        System.out.println("Default Variable: " + defaultVariable);

        // Accessing protected variable
        System.out.println("Protected Variable: " + protectedVariable);

        // Accessing methods with non-access modifiers
        System.out.println("\nAccessing methods:");

        // Calling static method
        displayMessage();

        // Creating an instance of the class to call instance method
        Main obj = new Main();
        obj.instanceMethod();
    }

    // Public static method
    public static void displayMessage() {
        System.out.println("This is a public static method.");
    }

    // Private instance method
    private void instanceMethod() {
        System.out.println("This is a private instance method.");
    }
}
