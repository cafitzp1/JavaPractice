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

    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }

        // tree is empty
        return null;
    }

    public void delete(int value) {
        // pass root of subtree we want to search
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subtreeRoot, int value) {
        if (subtreeRoot == null)
            // essentially just returning null
            return subtreeRoot;

        // if value is in the left child of root
        if (value < subtreeRoot.getData()) {
            // set left tree subchild to whatever the result of the delete is
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        // if value is in right child of root
        } else if (value > subtreeRoot.getData()) {
            // set right tree subchild to result of delete
            // can return a new subchild or the same one
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
        // we have found the node we want to delete
        } else {
            // cases 1 & 2: node to delete has 0 or 1 child(ren)
            if (subtreeRoot.getLeftChild() == null) {
                // either only a rightchlid or no child at all (leaf)
                // returns right child or null (both cases are fine)
                return subtreeRoot.getRightChild();
            } else if (subtreeRoot.getRightChild() == null) {
                // same thing as with the leftchild
                return subtreeRoot.getLeftChild();
            }

            // handle case 3: node to delete has 2 children
            // replace subtreeRoot val with smallest val in right subtree
            subtreeRoot.setData(subtreeRoot.getRightChild().min());

            // delete node that has smallest val in right subtree
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
        }

        // return the same node if not the node we are deleting
        return subtreeRoot;
    }

    public int min() {
        if (root == null)
            return Integer.MIN_VALUE;

        return root.min();
    }

    public int max() {
        if (root == null)
            return Integer.MAX_VALUE;

        return root.max();
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    public void traversePreOrder() {
        if (root != null) {
            root.traversePreOrder();
        }
    }

    public void traversePostOrder() {
        if (root != null) {
            root.traversePostOrder();
        }
    }

    public void printListInOrder() {
        for (Integer num : root.addToListInOrder()) {
            System.out.print(num + " ");
        }
    }
}