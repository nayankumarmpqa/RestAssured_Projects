package StringConcepts;

public class FirstCharAndRemainingString {
    public static void main(String[] args) {
        String input = "Hello World, how are you?";

        // Call the method to print the first character and remaining string
        printFirstCharAndRemainingString(input);
    }

    private static void printFirstCharAndRemainingString(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("The input string is empty.");
            return;
        }

        // Trim the input string to remove leading and trailing spaces
        input = input.trim();

        // Find the index of the first space to determine the end of the first word
        int firstSpaceIndex = input.indexOf(' ');

        if (firstSpaceIndex == -1) {
            // If there is no space, the entire string is considered as the first word
            System.out.println("First Character: " + input.charAt(0));
            System.out.println("Remaining String: " + input.substring(1));
        } else {
            // Print the first character and remaining string
            System.out.println("First Character: " + input.charAt(0) + " " + input.substring(firstSpaceIndex));
        }
    }
}
