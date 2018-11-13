package my.java.app;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class App {
    public static void main(String[] args) {
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

    // union sets, store items together
    public static <E> Set<E> union(Set<E> set1, Set<E> set2) {
        Set<E> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }
}