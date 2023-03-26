package Pack1;

public class MyCharRunner {
    public static void main(String[] args) {

        MyChar m = new MyChar('b');

        System.out.println("m.isAlphabet() >>> " + m.isAlphabet());
        System.out.println("m.isVowel() >>> " + m.isVowel());
        System.out.println("m.isConsonent() >>> " + m.isConsonent());
        System.out.println("m.isDigit() >>> " + m.isDigit());

        //static methods test
        // when we are not using any data from the class object we should use static methods
        MyChar.printLowerCaseAlphabets();
        System.out.println();
        MyChar.printUpperCaseAlphabets();




    }
}
