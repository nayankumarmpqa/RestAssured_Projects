package StringConcepts;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class Case2 {
    public static void main(String[] args) {

        String s1 = new String("Nayan");
        String s2= new String("Nayan");

        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

        System.out.println("-------------------------------");
        StringBuffer sb1 = new StringBuffer("Nayan");
        StringBuffer sb2= new StringBuffer("Nayan");

        System.out.println(sb1==sb2);
        System.out.println(sb1.equals(sb2));

        String s = "ababababab";
        System.out.println(s.replace("a",""));
        System.out.println(s);

        String ss2 = "abcdefg";
        System.out.println(ss2.substring(2));

        System.out.println(ss2.substring(2, 5));

        System.out.println(ss2.indexOf('c'));
        System.out.println(ss2.indexOf("de"));
        System.out.println(ss2.indexOf('g'));

        String uppercaseWord = "NAYAN";

        System.out.println(uppercaseWord.toLowerCase());

        String wordWithSpaces = "  Nayan Kumar "; // "**Nayan*Kumar*"

        System.out.println(wordWithSpaces.trim());
        System.out.println(wordWithSpaces);
        System.out.println(wordWithSpaces.length());
        System.out.println(wordWithSpaces.trim().length());

        String input = "programming teeest";
        boolean[] visited = new boolean[256]; // Assuming ASCII characters

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            System.out.print(visited[currentChar]+" ");

//            if (!visited[currentChar]) {
//                // If the character is not visited yet, append it to the result
//                result.append(currentChar);
//                visited[currentChar] = true;
//            }
    }
        String a= "nayan";
        StringBuffer sb = new StringBuffer(a);
        System.out.println(sb);
        sb.append(" test");
        System.out.println(sb);
        sb.substring(1, 3);
        System.out.println(sb);
}}
