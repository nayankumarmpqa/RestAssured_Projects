package Pack1;

public class BiNumberRunner {
    public static void main(String[] args) {
        BiNumber nums= new BiNumber(2,3);

        System.out.println(nums.add());
        System.out.println(nums.multiply());
        System.out.println(nums.doubleIt());
        nums.getNumber1();
        nums.getNumber2();

    }
}
