package my.java.app;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        Employee jane = new Employee("Jane", "Jones", 123);
        Employee john = new Employee("John", "Doe", 4567);
        Employee mary = new Employee("Mary", "Smith", 22);
        Employee mike = new Employee("Mike", "Wilson", 3245);

        Map<String, Employee> hashMap = new HashMap<>();

        // put into map; will overwrite existing keys' values
        hashMap.put("Jones", jane);
        hashMap.put("Doe", john);
        hashMap.put("Smith", mary);
        hashMap.put("Doe", mary);

        // put if absent (returns exisiting val if not absent)
        System.out.println(hashMap.putIfAbsent("Doe", mike));

        // remove employees; returns removed employee
        System.out.println(hashMap.remove("Jones"));

        // get an employee
        System.out.println(hashMap.get("Smith"));
        System.out.println(hashMap.get("Smithxxx"));
        System.out.println(hashMap.getOrDefault("Smithxxx", mike));

        // see if map contains a key or value
        System.out.println(hashMap.containsKey("Doe"));
        System.out.println(hashMap.containsValue(jane));

        // loop the map
        Iterator<Employee> itr = hashMap.values().iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // alternative way to loop
        hashMap.forEach((k, v) -> System.out.println("Key = " + k + ", Employee = " + v));
    }
}