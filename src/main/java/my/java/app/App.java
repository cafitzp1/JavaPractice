package my.java.app;

public class App {
    public static void main(String[] args) {

        Employee jane = new Employee("Jane", "Jones", 123);
        Employee john = new Employee("John", "Doe", 4567);
        Employee mary = new Employee("Mary", "Smith", 22);
        Employee mike = new Employee("Mike", "Wilson", 3245);
        // Employee bill = new Employee("Bill", "End", 78);

        ChainedHashtable ht = new ChainedHashtable();
        ht.put("Jones", jane);
        ht.put("Doe", john);
        ht.put("Wilson", mike);
        ht.put("Smith", mary);

        // ht.printHashtable();

        System.out.println("Retrieve key Smith: " + ht.get("Smith"));
        
        ht.remove("Doe");
        ht.remove("Jones");
        ht.printHashtable();
        
        System.out.println("Retrieve key Smith: " + ht.get("Smith"));
    }
}