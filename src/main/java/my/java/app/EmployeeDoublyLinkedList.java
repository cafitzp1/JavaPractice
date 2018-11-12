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

        // return if list is empty
        if (head == null) return false;

        EmployeeNode current = head;

        // iterate over items
        while (current != null && !current.getEmployee().equals(srcEmployee)) {
            current = current.getNext();
        }

        if (current == null) return false;

        // new node fields
        EmployeeNode newNode = new EmployeeNode(employeeToAdd);
        newNode.setPrevious(current.getPrevious());
        newNode.setNext(current);

        // node we are inserting before fields
        current.setPrevious(newNode);

        // node we are inserting after; could be head, so we have to test
        if (current == head) {
            head = newNode;
        } else {
            newNode.getPrevious().setNext(newNode);
        }

        size++;

        // did not find the employee
        return true;
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