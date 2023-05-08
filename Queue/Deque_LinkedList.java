public class Deque_LinkedList<T> {
    private class Node<T>{
        T data;
        Node next;
        public Node(T data) {
            this.data = data;
            next=null;
        }
    }

    private Node head,tail;
    private int size;
    public boolean isEmpty(){
        return head==null&&tail==null;
    }
    public void enqueueFirst(T data){
        size++;
        Node n=new Node(data);
        if(isEmpty()){
            head=tail=n;
            return;
        }
        n.next=head;
        head=n;
    }
    public void enqueueLast(T data){
        size++;
        Node n=new Node(data);
        if(isEmpty()){
            head=tail=n;
            return;
        }
        tail.next=n;
        tail=n;
    }
    //dequeue
    public T dequeueFirst(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        T data= (T) head.data;
        if(head==tail){
            head=tail=null;
            return data;
        }
        head=head.next;
        size--;
        return data;
    }
    //dequeue
    public T dequeueLast(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        T data= (T) tail.data;
        if(head==tail){
            head=tail=null;
            return data;
        }
        Node temp=head;
        while (temp.next!=tail){
            temp=temp.next;
        }
        tail=temp;
        tail.next=null;
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

    public int getSize() {
        return size;
    }
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
        Deque_LinkedList<Integer> queue=new Deque_LinkedList<>();
        queue.enqueueFirst(5);
        queue.enqueueFirst(7);
        queue.enqueueLast(4);
        queue.print();
        queue.dequeueFirst();
        queue.print();
        queue.enqueueFirst(1);
        queue.enqueueFirst(2);
        queue.print();
        queue.dequeueLast();
        queue.print();
        queue.enqueueFirst(3);
        queue.print();
        queue.enqueueLast(queue.dequeueFirst());
        queue.print();
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
        System.out.println(queue.getSize());
        queue.dequeueFirst();
        queue.dequeueFirst();
        queue.dequeueFirst();
        queue.dequeueFirst();
        queue.print();
        System.out.println(queue.dequeueFirst());
    }
}
