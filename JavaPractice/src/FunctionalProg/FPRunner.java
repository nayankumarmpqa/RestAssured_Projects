package FunctionalProg;

import java.util.List;
import java.util.stream.IntStream;

public class FPRunner {

    public static void printBasic(List<String> list) {

        for (String item : list) {
            System.out.println(item);
        }

    }

    public static void FPPrint(List<String> list) {
        list.stream().forEach(
                item -> System.out.println("Element is = " + item)
        );
    }

    static int sum = 0;

    public static int normalSum(List<Integer> numbers) {

        for (int item : numbers) {
            sum = sum + item;
        }
        return sum;
    }


    public static void FPNumbersSum(List<Integer> numbers) {
        int sum = numbers.stream()
                .reduce(0, (num1, num2) -> num1 + num2);
        System.out.println(sum);
    }

    public static void main(String[] args) {

        List<String> list = List.of("Apple", "Banana", "Cat0", "Dog");
        printBasic(list);
        FPPrint(list);
        List<Integer> numbers = List.of(1, 4, 7);

        System.out.println(normalSum(numbers));

        FPNumbersSum(numbers);

        System.out.println("==========================");

        IntStream.range(1, 11).map(e -> e * e).forEach(value -> System.out.print(value + " "));
        System.out.println();
        System.out.println("==========================");

        List.of("Apple", "Andt", "Bat").stream().map(element -> element.toUpperCase())
                .forEach(value -> System.out.print(value + " "));

        System.out.println();
        System.out.println("==========================");

        List.of("Apple", "Andt", "Bat").stream().map(element -> element.toLowerCase())
                .forEach(value -> System.out.print(value + " "));

        System.out.println();
        System.out.println("==========================");

        List.of("Apple", "Andt", "Bat").stream().map(element -> element.length())
                .forEach(value -> System.out.print(value + " "));
    }


}
