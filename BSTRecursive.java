import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BSTRecursive {

    // 🔹 Insert into BST (Recursive)
    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    // 🔹 Inorder Traversal
    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // 🔹 Preorder Traversal
    static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // 🔹 Postorder Traversal
    static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // 🔹 Search in BST
    static boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;

        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    // 🔹 Find Minimum
    static int findMin(Node root) {
        while (root.left != null)
            root = root.left;
        return root.data;
    }

    // 🔹 Height of Tree
    static int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // 🔹 Delete Node (Recursive)
    static Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else { // found the node
            // Case 1: No child
            if (root.left == null && root.right == null) return null;

            // Case 2: One child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: Two children
            root.data = findMin(root.right); // replace with inorder successor
            root.right = delete(root.right, root.data); // delete successor
        }
        return root;
    }

    // 🔹 MAIN METHOD
    public static void main(String[] args) {
        Node root = null;

        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values) root = insert(root, val);

        System.out.print("Inorder Traversal: ");
        inorder(root);
        System.out.println();

        System.out.print("Preorder Traversal: ");
        preorder(root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        postorder(root);
        System.out.println();

        int key = 60;
        System.out.println("Search " + key + ": " + search(root, key));

        System.out.println("Deleting 30...");
        root = delete(root, 30);

        System.out.print("Inorder After Deletion: ");
        inorder(root);
        System.out.println();

        System.out.println("Height of Tree: " + height(root));
    }
}
