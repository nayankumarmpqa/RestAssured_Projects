package VipulYoutube;

import javax.sound.midi.Soundbank;

public class TestSrting {

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "Nayan";
           student1.address= "ynauna nager";

           student1.standard= 1;
           student1.rollNo= 1;

        System.out.println(student1.name);
        //VipulYoutube.Student@4dd8dc3


        String str = "Amar Panchal";
        String str2 = "amar Panchal";

        System.out.println(str.length());  // starts from 1 and including spaces and result is total 12
        System.out.println(str.charAt(3)); //starts from 0 and result is r

        System.out.println(str.equals(str2));  //true is "Amar Panchal" and "Amar Panchal"
        // flase if "Amar Panchal" and "amar Panchal";

        System.out.println(str.equalsIgnoreCase(str2)); // true if "Amar Panchal"; and "amar Panchal";

        System.out.println('A' +0);
        System.out.println('a' + 0);

        System.out.println(str.compareTo(str2)); // Compare ASCII value and result is -32 fro "Amar Panchal" and "amar Panchal";
        System.out.println(str.compareToIgnoreCase(str2)); // Compare ASCII value and result is 0 fro "Amar Panchal" and "amar Panchal";

        System.out.println(str.substring(5));  // from 0 to 5
        System.out.println(str.substring(5,8)); // only 'pan' from 5 to 7 (which is 8 - 1)

        System.out.println(str.toUpperCase());
        System.out.println(str2.toLowerCase());

        String spacedword = "   abc   ";
        System.out.println(spacedword.trim());

        System.out.println(str.replace("Panchal", "Sharma"));// will replace all occurrences
        System.out.println(str.replace('a', 'b')); // will replace all occurrences

        System.out.println(str.contains("Kumar"));  //false because it is "Amar Panchal";

        System.out.println(str.startsWith("A"));
        System.out.println(str2.startsWith("A"));


        System.out.println(str.isBlank());
        System.out.println(str.isEmpty());



        String space = " ";  // it is empty not blank
        String blank = ""; // it is emptly and blank

        System.out.println(space.isEmpty());  // false
        System.out.println(space.isBlank());   // true

        System.out.println(blank.isEmpty());  // true
        System.out.println(blank.isBlank());   //true

    }
}
