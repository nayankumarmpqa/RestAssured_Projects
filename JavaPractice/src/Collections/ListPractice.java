package Collections;

import java.util.List;

public class ListPractice {

    public static void main(String[] args) {
        List<String> words = List.of("Apple", "Bat", "Cat");
        System.out.println(words); // [Apple, Bat, Cat]
        System.out.println(words.size()); //3
        System.out.println(words.isEmpty()); //false
        System.out.println(words.get(1)); // Bat
        System.out.println(words.contains("Dog")); // false
        System.out.println(words.contains("Cat")); // True
        System.out.println(words.indexOf("Cat")); // 2
        System.out.println(words.indexOf("Dog")); // -1 if not present




    }
}
