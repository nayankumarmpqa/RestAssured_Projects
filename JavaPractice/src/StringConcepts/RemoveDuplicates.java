package StringConcepts;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String input = "programming";

        // Call the method to remove duplicate characters
        String result = removeDuplicates(input);

        System.out.println("Original String: " + input);
        System.out.println("String after removing duplicates: " + result);
    }

    private static String removeDuplicates(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        boolean[] visited = new boolean[256]; // Assuming ASCII characters

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (!visited[currentChar]) {
                // If the character is not visited yet, append it to the result
                result.append(currentChar);
                visited[currentChar] = true;
            }
        }

        return result.toString();
    }
}
