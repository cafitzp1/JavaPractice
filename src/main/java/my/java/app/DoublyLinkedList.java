package my.java.app;

// capable of being used as a stack or queue
public class DoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public void addToFront(E item) {
        Node<E> node = new Node<>(item);
        node.setNext(head);

        if (head == null) {
            tail = node;
        } else {
            head.setPrevious(node);
        }

        head = node;
        size++;
    }

    public void addToEnd(E item) {
        Node<E> node = new Node<>(item);
        
        if (tail == null) {
            addToFront(item);
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
            size++;
        }
    }

    public Node<E> removeFromFront() {
        if (isEmpty())
            return null;

        Node<E> removedNode = head;

        if (head.getNext() == null) {
            tail = null;
        } else {
            head.getNext().setPrevious(null);
        }

        head = head.getNext();
        removedNode.setNext(null);
        size--;
        return removedNode;
    }

    public Node<E> removeFromEnd() {
        if (isEmpty())
            return null;

        Node<E> removedNode = tail;

        if (tail.getPrevious() == null) {
            head = null;
        } else {
            tail.getPrevious().setNext(null);
        }

        tail = tail.getPrevious();
        removedNode.setPrevious(null);
        size--;
        return removedNode;
    }

    public E peekFront() {
        return head.getItem();
    }

    public E peekEnd() {
        return tail.getItem();
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        Node<E> current = head;
        System.out.println("HEAD ->");
        while (current != null) {
            System.out.println(current + " <=>");
            current = current.getNext();
        }
        System.out.println("null");
    }
}