package my.java.app;

public class Heap {

    private int[] heap;
    private int size;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }

        heap[size] = value;

        // heapify
        fixHeapAbove(size++);
    }

    // for inserts, we have to fix the heap by travelling upwards
    private void fixHeapAbove(int index) {
        // store the value we've just inserted
        int newValue = heap[index];
        // while we haven't hit the root and new val is greater than its parent
        while (index > 0 && newValue > heap[getParent(index)]) {
            // shift the parent value down
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        // bubble new value up; only assign new value after the while completes
        heap[index] = newValue;
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }
}