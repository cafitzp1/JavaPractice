package my.java.app;

public class App {

    public static void main(String[] args) {
        
        Employee jane = new Employee("Jane", "Jones", 123);
        Employee john = new Employee("John", "Doe", 4567);
        Employee mary = new Employee("Mary", "Smith", 22);
        Employee mike = new Employee("Mike", "Wilsone", 3245);
        Employee benBefore = new Employee("Ben", "Before", 012);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();

        // add employees to the list
        list.addToFront(jane);
        list.addToFront(john);
        list.addToFront(mary);
        list.addToFront(mike);

        list.printList();
        System.out.println(list.getSize());

        // add an employee before
        list.addBefore(benBefore, new Employee("fake", "employee", 000));

        list.printList();
        System.out.println(list.getSize());
    }
}