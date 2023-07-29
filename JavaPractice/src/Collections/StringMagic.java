package Collections;

import java.util.Arrays;

public class StringMagic {

    public boolean areAnagrams(String str1, String str2) {
        if(str1==null || str2==null){
            return false;
        }

        if(str1.length() != str2.length()){
            return false;
        }


        String s1 = str1.toLowerCase();
        String s2 = str2.toLowerCase();

        if (s1.length() == s2.length()) {
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);
            return Arrays.equals(c1, c2);

        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        StringMagic s = new StringMagic();
        System.out.println(s.areAnagrams(null, null));

    }
}

