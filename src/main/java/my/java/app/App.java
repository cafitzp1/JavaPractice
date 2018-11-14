package my.java.app;

public class App {

    public static void main(String[] args) {

        Employee jane = new Employee("Jane", "Jones", 123);
        Employee john = new Employee("John", "Doe", 4567);
        Employee mary = new Employee("Mary", "Smith", 22);
        Employee mike = new Employee("Mike", "Wilson", 3245);
        Employee bill = new Employee("Bill", "End", 78);

        ArrayQueue queue = new ArrayQueue(10);
        queue.add(jane);
        queue.add(john);
        queue.add(mary);
        queue.add(mike);
        queue.add(bill);
        // queue.printQueue();

        queue.remove();
        queue.remove();
        // queue.printQueue();

        // System.out.println(queue.peek());
        queue.remove();
        queue.remove();
        queue.remove();
        // queue.remove();

        queue.add(mike);

        queue.printQueue();

        // stack.printStack();
        // System.out.println(stack.peek());
        // System.out.println("Popped: " + stack.pop());
        // System.out.println(stack.peek());
    }
}