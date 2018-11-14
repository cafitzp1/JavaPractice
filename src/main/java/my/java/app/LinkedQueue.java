package my.java.app;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedQueue {

    private LinkedList<Employee> queue;

    public LinkedQueue() {
        queue = new LinkedList<Employee>();
    }

    public void add(Employee employee) {
        queue.add(employee);
    }

    public Employee remove() {
        return queue.remove();
    }

    public Employee peek() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void printQueue() {
        ListIterator<Employee> itr = queue.listIterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}