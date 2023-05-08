public class Queue_LinkedList <T extends Comparable>{
    private class Node<T extends Comparable>{
        T data;
        Node next;
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    int size,capacity;

    public Queue_LinkedList(int capacity) {
        head=null;
        this.capacity = capacity;
        size=0;
    }
    public boolean isFull(){
        return size==capacity;
    }
    public boolean isEmpty(){
        return head==null;
    }
    //Enqueue
    public void enqueue(T data){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        Node n=new Node(data);
        if(head==null){
            head=n;
            size++;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=n;
        size++;
    }
    //dequeue
    public T dequeue(){
        if(head==null){
            System.out.println("Queue is empty");
            return null;
        }
        T data= (T) head.data;
        head=head.next;
        size--;
        return data;
    }
    public T peek(){
        if(head==null){
            System.out.println("Queue is empty");
            return null;
        }
        return (T) head.data;
    }
    //print
    public void print(){
        if(head==null){
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue Elements: ");
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Queue_LinkedList<Integer> queue = new Queue_LinkedList<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.print(); // output: 1 2 3 4 5
        queue.enqueue(6); // output: Queue is full
        queue.dequeue();
        queue.dequeue();
        queue.print(); // output: 3 4 5
        System.out.println(queue.peek()); // output: 3
    }
}