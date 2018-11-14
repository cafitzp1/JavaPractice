package my.java.app;

public class LinkedQueue<E> {

    private DoublyLinkedList<E> queue;

    public LinkedQueue() {
        queue = new DoublyLinkedList<>();
    }

    public void add(E item) {
        queue.addToEnd(item);
    }

    public E remove() {
        E removedItem = queue.removeFromFront().getItem();
        return removedItem;
    }

    public E peek() {
        return queue.peekFront();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void printQueue() {
        queue.printList();
    }

}