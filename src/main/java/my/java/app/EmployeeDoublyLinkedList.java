package my.java.app;

import java.awt.List;

public class EmployeeDoublyLinkedList {
  
    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;
  
    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);

        if (head == null) {
            tail = node;
        } else {
            head.setPrevious(node);
        }

        head = node;
        size++;
    }

    public boolean addBefore(Employee employeeToAdd, Employee srcEmployee) {

        EmployeeNode nodeToAdd = new EmployeeNode(employeeToAdd);
        EmployeeNode current = head;

        // iterate over items
        while (current != null) {
            System.out.println(current.getEmployee());

            // if the srcEmployee exists
            if (current.getEmployee() == srcEmployee) {
            
                // for the node we are adding after
                if (current == head) {
                    head = nodeToAdd;
                    current.setPrevious(nodeToAdd);
                } else {
                    current.getPrevious().setNext(nodeToAdd);
                }

                // for the node adding before
                current.setPrevious(nodeToAdd);

                // for the node we're adding
                nodeToAdd.setNext(current);
                nodeToAdd.setPrevious(current.getPrevious());
                

                size++;

                return true;
            }

            current = current.getNext();
        }

        // did not find the employee
        return false;
    }

    public void addToEnd(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        if (tail == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        size++;
    }

    public EmployeeNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = head;

        if (head.getNext() == null) {
            tail = null;
        } else {
            head.getNext().setPrevious(null);
        }

        head = head.getNext();
        size--;
        removedNode.setNext(null); // completely unlink the node (optional)
        return removedNode;
    }

    public EmployeeNode removeFromEnd() {
        if (isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = tail;

        if (tail.getPrevious() == null) {
            head = null;
        } else {
            tail.getPrevious().setNext(null);
        }

        tail = tail.getPrevious();
        size--;
        removedNode.setPrevious(null);
        return removedNode;
    }

    // keep a running count of size
    public int getSize() {
        return size;
    }

    // implement isEmpty by checking if head is null
    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        EmployeeNode current = head;
        System.out.print("HEAD -> \n");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <=> \n");
            current = current.getNext();
        }
        System.out.println("null");
    }
}