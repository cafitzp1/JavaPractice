package my.java.app;

public class LinkedStack<E> {

    private DoublyLinkedList<E> stack;

    public LinkedStack() {
        stack = new DoublyLinkedList<>();
    }

    public void push(E item) {
        stack.addToFront(item);
    }

    public E pop() {
        E removedItem = stack.removeFromFront().getItem();
        return removedItem;
    }

    public E peek() {
        return stack.peekFront();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() {
        stack.printList();
    }

}