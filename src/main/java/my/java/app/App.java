package my.java.app;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class App {
    public static void main(String[] args) {

        // test generic class
        Container<Integer, String> container = new Container<>(12, "Hello");
        int val1 = container.getItem1();
        String val2 = container.getItem2();

        System.out.println(val1);
        System.out.println(val2);
        System.out.println();

        // test generic method
        Set<String> mySet1 = new HashSet<>();
        mySet1.add("first");
        mySet1.add("second");
        mySet1.add("third");

        Set<String> mySet2 = new HashSet<>();
        mySet2.add("first");
        mySet2.add("second");
        mySet2.add("fourth");

        Set<String> resultSet = union(mySet1, mySet2);

        // another way of iterating over collections; every collection has it
        Iterator<String> itr = resultSet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    // generic method; union sets, store items together
    public static <E> Set<E> union(Set<E> set1, Set<E> set2) {
        Set<E> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }
}