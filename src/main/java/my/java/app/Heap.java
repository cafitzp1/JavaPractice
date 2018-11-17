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

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        return heap[0];
    }

    // taking the index means we can do a binary search
    public int delete(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        // store parent and deleted value
        int parent = getParent(index);
        int deletedValue = heap[index];

        // right most value replaces whatever was in the index
        heap[index] = heap[size - 1];

        // tree is still complete but now we have to fix the heap
        // if dealing with the root or this is less than the parent
        // ie, we don't have to worry about anything above
        if (index == 0 || heap[index] < heap[parent]) {
            fixHeapBelow(index, size - 1);
        } else {
            // we do have to worry about elements above
            fixHeapAbove(index);
        }

        size--;

        return deletedValue;
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

    // we'll need lastHeapIndex for when we do the heap sort
    private void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;

        while (index <= lastHeapIndex) {
            // get two children where value we deleted was
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);

            // NOTE: heap can only have both or left at this point
            // if there is a left child
            if (leftChild <= lastHeapIndex) {
                // if there is NOT a right child
                if (rightChild > lastHeapIndex) {
                    // swap with left child by default
                    childToSwap = leftChild;
                } else {
                    // swap with the larger of the two
                    childToSwap = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
                }

                // if value at index is less than the child we'd swap with
                if (heap[index] < heap[childToSwap]) {
                    // we have to swap them
                    int tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                } else {
                    // we don't need to do anything; heap satisfies heap property
                    break;
                }

                // update index; compare replacement value with its new children
                index = childToSwap;
            } else {
                // there are no children, so there's nothing to do
                break;
            }
        }
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public int getChild(int index, boolean left) {
        return 2 * index + (left ? 1 : 2); 
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }
}