public class QueueLinkedlist_Best <T>{
    private class Node<T>{
        T data;
        Node next;
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node head,tail;
    private int size;
    public boolean isEmpty(){
        return head==null&&tail==null;
    }
    //Enqueue
    public void enqueue(T data){
        size++;
        Node n=new Node<>(data);
        if(isEmpty()){
            head=tail=n;
            return;
        }
        tail.next=n;
        tail=n;
    }
    //dequeue
    public T dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        T data= (T) head.data;
        head=head.next;
        size--;
        return data;
    }
    public T peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        return (T) head.data;
    }
    //size

    public int getSize() {
        return size;
    }

    //print
    public void print(){
        if(isEmpty()){
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
        QueueLinkedlist_Best<Integer> queue = new QueueLinkedlist_Best<>();
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
        System.out.println(queue.isEmpty());
        System.out.println(queue.getSize());
    }
}