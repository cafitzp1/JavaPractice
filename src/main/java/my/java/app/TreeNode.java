package my.java.app;

public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int value) {
        // we will not support duplicate values
        if (value == data)
            return;

        // we want to insert somewhere in the left
        if (value < data) {
            // if this subtree does not yet have a left child
            if (leftChild == null) {
                // we've found the insertion point
                leftChild = new TreeNode(value);
            } else {
                // subtree has a left child, so we compare
                leftChild.insert(value);
            }
        // we want to insert somewhere on the right
        } else {
            // same thing for the right
            if (rightChild == null) {
                rightChild = new TreeNode(value);
            } else {
                rightChild.insert(value);
            }
        }
    }

    public void traverseInOrder() {
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }
        System.out.print(data + ", ");
        if (rightChild != null) {
            rightChild.traverseInOrder();
        }
    }

    public int getData() {
        return this.data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public TreeNode getLeftChild() {
        return this.leftChild;
    }
    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }
    public TreeNode getRightChild() {
        return this.rightChild;
    }
    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}