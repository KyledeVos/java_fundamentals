package labs_examples.datastructures.hashmap.labs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *  HashMaps Exercise_01
 *
 *  Demonstrate you're mastery of using Java's built-in HashMap class below.
 *
 *  Using a HashMap demonstrate the use of the following methods:
 *
 *  put()
 *  get()
 *  putAll()
 *  size()
 *  contains()
 *  keySet()
 *  entrySet()
 *  putIfAbsent()
 *  remove()
 *  replace()
 *  forEach()
 *  clear()
 *
 */

public class Exercise_01 {

    public static void main(String[] args) {

        HashMap<String, Integer> bikeMap = new HashMap<>();

        //put()
        bikeMap.put("GSXR600", 600);
        bikeMap.put("GSXR1000", 1000);
        bikeMap.put("S1000RR", 1000);
        bikeMap.put("H2R", 900);
        bikeMap.put("Hayabusa", 1300);

        //get()
        System.out.println("Size of H2R is: " + bikeMap.get("H2R"));

        //putAll()
        HashMap<String, Integer> bikeCopyMap = new HashMap<>();
        bikeCopyMap.putAll(bikeMap);

        //size()
        System.out.println("Size of Copy HashMap after using putAll(): " + bikeCopyMap.size());

        //contains()
        System.out.println("Checking for Key: Hayabusa: " + bikeMap.containsKey("Hayabusa"));
        System.out.println("Checking for value of 600: " + bikeCopyMap.containsValue(600));

        //keySet()
        System.out.println("The set of the bikeMap is: " + bikeMap.keySet());

        //entrySet()
        System.out.println("The Keys and Values are the bikeMap is: " + bikeMap.entrySet());

        //putIfAbsent()
        //returns null if element is not in map, otherwise returns value of key if
        System.out.println(bikeMap.putIfAbsent("Panigalli", 1300));
        System.out.println(bikeMap.putIfAbsent("GSXR600", 600));

        //remove()
        System.out.println("Bike removed from map GSXR1000: " + bikeMap.remove("GSXR1000"));

        //replace()
        bikeMap.replace("H2R", 900, 950);
        System.out.println("H2R engine increased from 900 to: " + bikeMap.get("H2R"));

        //forEach()
        for(Map.Entry<String, Integer> element : bikeMap.entrySet()){
            System.out.println("Key: " + element.getKey() + " value: " + element.getValue());
        }

        //clear()
        bikeMap.clear();
        System.out.println("Size of bikeMap After Clear: " + bikeMap.size());
        
    }
}
