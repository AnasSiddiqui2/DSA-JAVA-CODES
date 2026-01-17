import java.util.*;

class Node {
    int value;
    Node leftChild;
    Node rightChild;

    Node(int value) {
        this.value = value;
        leftChild = null;
        rightChild = null;
    }
}

public class BST { // class name must match filename: BST.java
    private Node root;

    // Insert Iteratively
    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = new Node(value);
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = new Node(value);
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    // Search Iteratively
    public boolean search(int value) {
        Node current = root;
        while (current != null) {
            if (value == current.value) return true;
            if (value < current.value) current = current.leftChild;
            else current = current.rightChild;
        }
        return false;
    }

    // Inorder Traversal Iterative
    public void inorder() {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.leftChild;
            }
            curr = stack.pop();
            System.out.print(curr.value + " ");
            curr = curr.rightChild;
        }
        System.out.println();
    }

    // Preorder Traversal Iterative
    public void preorder() {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.value + " ");
            if (curr.rightChild != null) stack.push(curr.rightChild);
            if (curr.leftChild != null) stack.push(curr.leftChild);
        }
        System.out.println();
    }

    // Postorder Traversal Iterative
    public void postorder() {
        if (root == null) return;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            Node curr = s1.pop();
            s2.push(curr);
            if (curr.leftChild != null) s1.push(curr.leftChild);
            if (curr.rightChild != null) s1.push(curr.rightChild);
        }
        while (!s2.isEmpty()) System.out.print(s2.pop().value + " ");
        System.out.println();
    }

    // Find Min Iterative
    public int findMin() {
        if (root == null) throw new RuntimeException("BST is empty");
        Node curr = root;
        while (curr.leftChild != null) curr = curr.leftChild;
        return curr.value;
    }

    // Find Max Iterative
    public int findMax() {
        if (root == null) throw new RuntimeException("BST is empty");
        Node curr = root;
        while (curr.rightChild != null) curr = curr.rightChild;
        return curr.value;
    }

    // Height Iterative (level-order)
    public int height() {
        if (root == null) return 0;
        Queue<Node> q = new LinkedList();
        q.add(root);
        int height = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (curr.leftChild != null) q.add(curr.leftChild);
                if (curr.rightChild != null) q.add(curr.rightChild);
            }
            height++;
        }
        return height;
    }

    // Delete Node Iteratively
    public void delete(int key) {
        Node curr = root, parent = null;

        // Search for node to delete
        while (curr != null && curr.value != key) {
            parent = curr;
            if (key < curr.value) curr = curr.leftChild;
            else curr = curr.rightChild;
        }

        if (curr == null) return; // Node not found

        // Node with two children
        if (curr.leftChild != null && curr.rightChild != null) {
            Node successorParent = curr;
            Node successor = curr.rightChild;
            while (successor.leftChild != null) {
                successorParent = successor;
                successor = successor.leftChild;
            }
            curr.value = successor.value; // Replace value
            curr = successor;
            parent = successorParent;
        }

        // Node with 0 or 1 child
        Node child = (curr.leftChild != null) ? curr.leftChild : curr.rightChild;
        if (parent == null) root = child; // deleting root
        else if (parent.leftChild == curr) parent.leftChild = child;
        else parent.rightChild = child;
    }

    // MAIN METHOD
    public static void main(String[] args) {
        BST tree = new BST();

        int[] values = {50, 30, 70, 20, 40, 60, 90};
        for (int val : values) tree.insert(val);

        System.out.print("Inorder: ");
        tree.inorder();

        System.out.print("Preorder: ");
        tree.preorder();

        System.out.print("Postorder: ");
        tree.postorder();

        System.out.println("Search 40: " + tree.search(40));
        System.out.println("Min: " + tree.findMin());
        System.out.println("Max: " + tree.findMax());
        System.out.println("Height: " + tree.height());

        System.out.println("Deleting 70...");
        tree.delete(70);

        System.out.print("After Deletion (Inorder): ");
        tree.inorder();
    }
}
