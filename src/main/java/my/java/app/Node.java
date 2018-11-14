package my.java.app;

public class Node<E> {

    private E item;
    private Node<E> next;
    private Node<E> previous;

    public Node(E item) {
        this.item = item;
    }

    public E getItem() { return this.item; }
    public void setItem(E item) { this.item = item; }
    public Node<E> getNext() { return this.next; }
    public void setNext(Node<E> next) { this.next = next; }
    public Node<E> getPrevious() { return this.previous; }
    public void setPrevious(Node<E> previous) { this.previous = previous; }

    @Override
    public String toString() {
        return item.toString();
    }
}