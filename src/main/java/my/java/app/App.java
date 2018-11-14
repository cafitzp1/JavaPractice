package my.java.app;

public class App {

    public static void main(String[] args) {

        Employee jane = new Employee("Jane", "Jones", 123);
        Employee john = new Employee("John", "Doe", 4567);
        Employee mary = new Employee("Mary", "Smith", 22);
        Employee mike = new Employee("Mike", "Wilson", 3245);
        Employee bill = new Employee("Bill", "End", 78);

        ArrayQueue queue = new ArrayQueue(5);

        // queue.add(jane);
        // queue.add(john);
        // queue.remove();
        // queue.add(mary);
        // queue.remove();
        // queue.add(mike);
        // queue.remove();
        // queue.add(bill);
        // queue.remove();
        // queue.add(jane);

        queue.add(jane);
        queue.add(john);
        queue.add(mary);
        queue.add(mike);
        queue.add(bill);
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.add(mike);
        
        queue.printQueue();
        // System.out.println(queue.peek());
    }
}