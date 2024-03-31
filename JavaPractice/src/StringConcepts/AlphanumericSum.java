package StringConcepts;

public class AlphanumericSum {
    public static void main(String[] args) {
        String input = "a1b2c3d4e5f6g7h8i9";

        int sum = calculateSum(input);

        System.out.println("Sum of numbers in the alphanumeric string: " + sum);
    }

    private static int calculateSum(String input) {
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (Character.isDigit(currentChar)) {
                // If the current character is a digit, parse it and add to the sum
                sum += Character.getNumericValue(currentChar);
            }
        }

        return sum;
    }
}
