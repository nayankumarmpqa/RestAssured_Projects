package StringConcepts;

public class AlphanumericSeparation {
    public static void main(String[] args) {
        String input = "a1b2c3d4e5f6g7h8i9";

        // Separate alphabets and numbers
        String alphabets = extractAlphabets(input);
        String numbers = extractNumbers(input);

        // Calculate sum of numbers
        int sumOfNumbers = calculateSum(numbers);

        System.out.println("Alphabets: " + alphabets);
        System.out.println("Numbers: " + numbers);
        System.out.println("Sum of Numbers: " + sumOfNumbers);
    }

    private static String extractAlphabets(String input) {
        StringBuilder alphabets = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (Character.isLetter(currentChar)) {
                // If the current character is an alphabet, append it to the alphabets string
                alphabets.append(currentChar);
            }
        }

        return alphabets.toString();
    }

    private static String extractNumbers(String input) {
        StringBuilder numbers = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (Character.isDigit(currentChar)) {
                // If the current character is a digit, append it to the numbers string
                numbers.append(currentChar);
            }
        }

        return numbers.toString();
    }

    private static int calculateSum(String input) {
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // Parse each digit and add to the sum
            sum += Character.getNumericValue(currentChar);
        }

        return sum;
    }
}
