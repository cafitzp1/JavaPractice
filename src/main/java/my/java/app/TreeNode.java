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

    public TreeNode get(int value) {
        // check value against value of the node
        if (value == data) {
            // return 'this' tree node
            return this;
        }

        if (value < data) {
            if (leftChild != null)
                // call recursively to search the left subtree
                return leftChild.get(value);
            // value is not in the left
        } else {
            if (rightChild != null) {
                // call recursively to search the right subtree
                return rightChild.get(value);
            }
        }

        // we coulnd't find the value we were looking for
        return null;
    }

    public int min() {
        if (leftChild == null)
            return data;

        return leftChild.min();
    }

    public int max() {
        if (rightChild == null)
            return data;

        return rightChild.max();
    }

    public void traverseInOrder() {
        // left, root, right
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }
        System.out.print(data + ", ");
        if (rightChild != null) {
            rightChild.traverseInOrder();
        }
    }

    public void traversePreOrder() {
        // right, left, right
        System.out.print(data + ", ");
        if (leftChild != null) {
            leftChild.traversePreOrder();
        }
        if (rightChild != null) {
            rightChild.traversePreOrder();
        }
    }

    public void traversePostOrder() {
        // left, right, root
        if (leftChild != null) {
            leftChild.traversePostOrder();
        }
        if (rightChild != null) {
            rightChild.traversePostOrder();
        }
        System.out.print(data + ", ");
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

    public String toString() {
        return "Data = " + this.data;
    }
}