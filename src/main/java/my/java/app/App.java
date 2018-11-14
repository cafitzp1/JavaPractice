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

        //System.out.println(stack.peek());
        System.out.println("Popped: " + stack.pop());
        stack.printStack();
        // System.out.println(stack.peek());
    }
}