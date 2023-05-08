import java.util.Scanner;

public class BinaryTree {
    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the data value for the root node: ");
        root = new Node(sc.nextInt());
        insert(root, sc);
    }

    private void insert(Node current, Scanner sc) {
        System.out.print("Add a left child for " + current.data + "? (y/n) ");
        String ans = sc.next();
        if (ans.equals("y")) {
            System.out.print("Enter the data value for the left child: ");
            current.left = new Node(sc.nextInt());
            insert(current.left, sc);
        }
        System.out.print("Add a right child for " + current.data + "? (y/n) ");
        ans = sc.next();
        if (ans.equals("y")) {
            System.out.print("Enter the data value for the right child: ");
            current.right = new Node(sc.nextInt());
            insert(current.right, sc);
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node current) {
        if (current != null) {
            printInOrder(current.left);
            System.out.print(current.data + " ");
            printInOrder(current.right);
        }
    }
}