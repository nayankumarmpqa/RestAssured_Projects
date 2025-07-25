package Collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {
    public static void main(String[] args) {

        Map<String, Integer> map = Map.of("A", 3,"b", 1,"C", 2 );
        System.out.println(map);


        HashMap<String, String> cities = new HashMap<>();
        cities.put("a", "b");
        cities.put("b", "old value");
        cities.put("a","b");
        System.out.println(cities.put(null, "old null key"));


        System.out.println("---------------1------------------");
        System.out.println(cities);
        // {null=old null key, a=b, b=old value}
        System.out.println("-----------22222----");

        System.out.println(cities.put("b","Nayan")); // prints old value
        System.out.println(cities.put(null, null)); // print old value of null key
        System.out.println(cities.put("z", null));  // old value of "z" key was null by defaul
        System.out.println(cities.put(null, "f"));
        System.out.println(cities.get("b"));

        System.out.println(cities);

        System.out.println(cities.remove(null, "test")); // Boolean answer false
        System.out.println(cities);


//  treemap test        ------------------------------------------

        TreeMap<String, String> capitalCities = new TreeMap<>();
        capitalCities.put("England", "London");
        capitalCities.put("India", "New Dehli");
        capitalCities.put("Austria", "Wien");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("Norway", "Oslo"); // Duplicate
        capitalCities.put("USA", "Washington DC");
        //capitalCities.put(null, "1nunll");
        //capitalCities.put(null, null);

        System.out.println(capitalCities);

        for (String eachKeyinKeySet : capitalCities.keySet()){
            System.out.println(eachKeyinKeySet+ "---" +capitalCities.get(eachKeyinKeySet));
            System.out.println("-----------");
        }

        for (String  eachValueInValueSet: capitalCities.values()){
            System.out.println(eachValueInValueSet +"--" + capitalCities.get(eachValueInValueSet));  //it will be null
            System.out.println("**************");

        }
        System.out.println(capitalCities.size());



        // LinkedHashMap

        LinkedHashMap<String, String> lhm = new LinkedHashMap<>();

        lhm.put("India", "Delhi");
        lhm.put("China", "Beijing");
        lhm.put("USA", "NY");
        lhm.put(null, "unkownCapital");
        lhm.put(null, null);

        System.out.println(lhm);

    }
}
