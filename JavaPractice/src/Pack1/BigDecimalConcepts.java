package Pack1;

import java.math.BigDecimal;

public class BigDecimalConcepts {

    public static void main(StringConcepts[] args) {
        int a=5;
        BigDecimal num1 = new BigDecimal("11.5");
        BigDecimal num2 = new BigDecimal("20.123");

        System.out.println(num1.add(num2));
        System.out.println(num1.add(new BigDecimal(a)));


        SiCalc s = new SiCalc("1000.00", "5");

        System.out.println(s.calculateValue(2));
    }
}
