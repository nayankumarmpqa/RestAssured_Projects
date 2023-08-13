package FunctionalProg;

import java.util.List;

public class LamdbaRunner
{
    public static void main(String[] args) {

        List.of(23,43,45,48,36,72,66).stream()
                .filter(elements -> elements%2==0)
                .map(n-> n*10)
                //.forEach(item -> System.out.println(item))
                .forEach( System.out::println);


        List<Integer> numbers = List.of(4, 6, 8, 13, 3, 15);
        int sum = numbers.stream()
                .reduce(0, (num1, num2) -> num1 + num2);
        System.out.println(sum);
    }
}


/*
Question 9:
What does the Optional<T> class represent in stream operations?

The Optional class represents a container object that may or may not contain a value.
The Optional class can be used to represent null values in stream operations.
It can also be used to avoid NullPointerExceptions in stream operations.

Question 10:
What is the purpose of the map() operation in stream operations?

The map() operation is used to apply a function to each element
in a stream and produce a new stream with the results.
The function that is applied to each element is called a mapper.
The mapper can be a lambda expression, a method reference, or a method.

Question 11:
What are intermediate operations and terminal operations in streams?

The main difference between intermediate operations and terminal operations
is that intermediate operations return a new stream,
while terminal operations produce a result or side-effect.
Intermediate operations can be chained together, while terminal operations cannot be chained together.



 */