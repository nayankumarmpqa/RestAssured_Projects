package Pack1;

import java.math.BigDecimal;

public class SiCalc {
    BigDecimal principal;
    BigDecimal interest;


    public SiCalc(String principal, String interest) {
        this.principal = new BigDecimal(principal);
        this.interest = new BigDecimal(interest).divide(new BigDecimal(100));
    }

    public BigDecimal calculateValue(int numOfYears){

        return principal.add(principal.multiply(interest).multiply(new BigDecimal(numOfYears)));
    }
}
