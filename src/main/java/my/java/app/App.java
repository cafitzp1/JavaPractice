package my.java.app;

public class App {

    public static void main(String[] args) {
        
        //ArrayStack stack = new ArrayStack(10);

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