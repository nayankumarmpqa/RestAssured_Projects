package Pack1;

public class BookRunner {
    public static void main(StringConcepts[] args) {

        Book artOfComputerProgramming = new Book();
        Book effectiveJava = new Book();
        Book cleanCode = new Book();

        System.out.println(artOfComputerProgramming.getNumOfBookCopies());
        System.out.println(effectiveJava.getNumOfBookCopies());
        System.out.println(cleanCode.getNumOfBookCopies());

        artOfComputerProgramming.increaseNumberOfBookCopies(55);
        artOfComputerProgramming.decreaseNumberOfBookCopies(1);
            System.out.println(artOfComputerProgramming.getNumOfBookCopies());

        effectiveJava.increaseNumberOfBookCopies(65);
        effectiveJava.decreaseNumberOfBookCopies(2);
        System.out.println(effectiveJava.getNumOfBookCopies());

        cleanCode.increaseNumberOfBookCopies(75);
        cleanCode.decreaseNumberOfBookCopies(3);
            System.out.println(cleanCode.getNumOfBookCopies());
    }
}
