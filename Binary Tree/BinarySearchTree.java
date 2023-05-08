import java.util.Scanner;
public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree tree=new BinarySearchTree();
        Scanner in=new Scanner(System.in);
        System.out.print("Enter number of values you want to add to tree: ");
        int count=in.nextInt();
        for (int i = 1; i <=count; i++) {
            System.out.print("Enter "+i+" value to insert: ");
            tree.insert(in.nextInt());
        }
        tree.print();
    }
    private class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left=null;
            right=null;
        }
    }

    Node root;
    Scanner in=new Scanner(System.in);
    public BinarySearchTree(){
        root=null;
    }
    public void insert(int value) {
        Node n= new Node(value);
        if (root == null) {
            root = n;
        } else {
            insertNode(root,n);
        }
    }
    private void insertNode(Node current, Node newNode) {
        if (newNode.data < current.data) {
            if (current.left == null) {
                current.left = newNode;
            } else {
                insertNode(current.left, newNode);
            }
        } else {
            if (current.right == null) {
                current.right = newNode;
            } else {
                insertNode(current.right, newNode);
            }
        }
    }
    public void print(){
        System.out.print("InOrder : ");
        InOrder(root);
        System.out.print("\nPreOrder : ");
        PreOrder(root);
        System.out.print("\nPostOrder : ");
        PostOrder(root);
    }
    private void InOrder(Node current){
        if(current==null){
            return;
        }
        InOrder(current.left);
        System.out.print(current.data+" ");
        InOrder(current.right);
    }
    private void PreOrder(Node current){
        if(current==null){
            return;
        }
        System.out.print(current.data+" ");
        PreOrder(current.left);
        PreOrder(current.right);
    }
    private void PostOrder(Node current){
        if(current==null){
            return;
        }
        PostOrder(current.left);
        PostOrder(current.right);
        System.out.print(current.data+" ");
    }
}
