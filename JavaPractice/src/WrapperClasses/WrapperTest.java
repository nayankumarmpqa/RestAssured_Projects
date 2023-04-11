package WrapperClasses;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class WrapperTest {

    public static void main(String[] args) {

        Integer a = new Integer(5); // using constructor

        Integer b = Integer.valueOf(5); // using valueOf method

        Integer c = new Integer("123400"); // using constructor with String input

        System.out.println();


        // autoboxing

        Integer d = 5;
        System.out.println(d);

        System.out.println("LocalDate.now() " + LocalDate.now());
        System.out.println("LocalDateTime.now() " + LocalDateTime.now());
        System.out.println("LocalTime.now() " + LocalTime.now());

        System.out.println(LocalDate.now().getDayOfYear());
        System.out.println(LocalDate.now().getDayOfWeek());
        System.out.println(LocalDate.now().getDayOfMonth());
        System.out.println(LocalDate.now().getMonth());
        System.out.println(LocalDate.now().getMonthValue());
        System.out.println(LocalDate.now().getYear());
        System.out.println(LocalDate.now().isLeapYear());
        System.out.println(LocalDate.now().lengthOfMonth());
        System.out.println(LocalDate.now().lengthOfYear());
        System.out.println(LocalDate.now().plusDays(100));
        System.out.println(LocalDate.now().plusMonths(10));

        System.out.println(LocalDate.of(2023, 01, 31));
        System.out.println(LocalDate.now().minusWeeks(10));
        System.out.println(LocalDate.now().minusDays(100));


    }
}
