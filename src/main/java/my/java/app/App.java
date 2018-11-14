package my.java.app;

import java.util.LinkedList;

public class App {

    public static void main(String[] args) {
        
    }

    public static boolean checkForPalindrome(String string) {

        // using JDK LinkedList without any wrapper class
        LinkedList<Character> stack = new LinkedList<Character>();
        LinkedList<Character> queue = new LinkedList<Character>();
        String lowerCase = string.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                queue.addLast(c);
                stack.push(c);
            }
        }

        while(!stack.isEmpty()) {
            if (!stack.pop().equals(queue.removeFirst())) {
                return false;
            }
        }

        return true;
    }

    public static void Test() {

        // for testing our own wrapper stack and queue classes
        Employee jane = new Employee("Jane", "Jones", 123);
        Employee john = new Employee("John", "Doe", 4567);
        Employee mary = new Employee("Mary", "Smith", 22);
        Employee mike = new Employee("Mike", "Wilson", 3245);
        Employee bill = new Employee("Bill", "End", 78);

        LinkedStack stack = new LinkedStack();
        stack.push(jane);
        stack.push(john);
        stack.push(mary);
        stack.push(mike);
        stack.push(bill);
        
        LinkedQueue queue = new LinkedQueue();
        queue.add(jane);
        queue.add(john);
        queue.add(mary);
        queue.add(mike);
        queue.add(bill);
        
        System.out.println("STACK:");
        stack.printStack();
        System.out.println("------------");
        System.out.println("Popped: " + stack.pop());
        System.out.println("------------");
        stack.printStack();
        System.out.println();
        
        System.out.println("QUEUE:");
        queue.printQueue();
        System.out.println("------------");
        System.out.println("Removed: " + queue.remove());
        System.out.println("------------");
        queue.printQueue();
    }
} 