package my.java.app;

public class Tree {

    private TreeNode root;

    // this is what the caller actually invokes to insert value into tree
    // Tree class will call the insert method with that value
    public void insert(int value) {
        if (root == null) {
            // inserting into first empty spot we find
            // if root is null, we insert into root
            root = new TreeNode(value);
        } else {
            // go to the left or the right
            root.insert(value);
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }
}