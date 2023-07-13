package Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

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

// List.of() method creates a immutable list
        // We can use Arraylist, LinkedList, Vector subclass
        List<String> wordsArrayList = new ArrayList<>(words);
        List<String> wordsLinkedList = new LinkedList<>(words);
        List<String> wordsVector = new Vector<>(words);

        wordsArrayList.add("Orange"); // true
        System.out.println(wordsArrayList); // adding at the end [Apple, Bat, Cat, Orange]

wordsArrayList.add("Cat");
        System.out.println(wordsArrayList);
        wordsArrayList.remove("Cat"); // removes only one cat from the left
        System.out.println(wordsArrayList);
    }
}
