import java.util.Scanner;

public class BinaryTree {
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        tree.insert();
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
    public BinaryTree(){
        root=null;
    }
    public void insert(){
        System.out.print("Enter the value for root Node: ");
        root=new Node(in.nextInt());
        insert(root);
    }
    private void insert(Node current){
        System.out.print("Add a left child for "+current.data+"? (y/n): ");
        String a=in.next();
        if(a.equals("y")){
            System.out.print("Enter data value for "+current.data+" left child: ");
            current.left=new Node(in.nextInt());
            insert(current.left);
        }
        System.out.print("Add a right child for "+current.data+"? (y/n): ");
        a=in.next();
        if(a.equals("y")){
            System.out.print("Enter data value for "+current.data+" right child: ");
            current.right=new Node(in.nextInt());
            insert(current.right);
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