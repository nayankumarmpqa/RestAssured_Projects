package Pack1;

public class MyChar {
    private char ch;

    public MyChar(char c) {
        this.ch = c;
    }

    public boolean isVowel() {
//        if (ch == 'a' || ch == 'e'|| ch == 'i' || ch == 'o' || ch == 'u' ) {
//            return true;
//        } else
//            return false;
        if (ch == 'a' || ch == 'A')
            return true;
        if (ch == 'e' || ch == 'E')
            return true;
        if (ch == 'i' || ch == 'I')
            return true;
        if (ch == 'o' || ch == 'O')
            return true;
        if (ch == 'u' || ch == 'U')
            return true;

        return false;

    }

    public boolean isConsonent() {
        if (isAlphabet() && !isVowel()){
            return true;
        } return false;
    }
    public boolean isDigit() {
        if (ch >= 48 && ch <= 57) {
            return true;
        }
        return false;
    }

    public boolean isAlphabet() {

        if(ch>=97 && ch<=122){
            // between a to z
            return true;

        }

        if(ch>=65 && ch<=90){
            // between A to Z
            return true;

        }        return false;
    }


    public static void printLowerCaseAlphabets() {
        //print a to z

        for(char ch = 'a'; ch <='z'; ch++){
            System.out.print(ch);
        }
    }

    public static void printUpperCaseAlphabets() {

        for(char ch = 'A'; ch <='Z'; ch++){
            System.out.print(ch);
        }

    }
}
