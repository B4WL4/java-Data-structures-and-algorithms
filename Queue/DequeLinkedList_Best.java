public class DequeLinkedList_Best<T>
{
    private class Node {
        T data;
        Node prev;
        Node next;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;
    public boolean isEmpty() {
        return head==null&&tail==null;
    }
    public int size() {
        return size;
    }
    public void enqueueFirst(T data) {
        size++;
        Node n = new Node(data);
        if (isEmpty()) {
            head=tail=n;
            return;
        }
        n.next = head;
        head.prev = n;
        head = n;
    }

    public void enqueueLast(T data) {
        size++;
        Node n = new Node(data);
        if (isEmpty()) {
            head=tail=n;
            return;
        }
        tail.next = n;
        n.prev = tail;
        tail = n;
    }

    public T DequeLinkedList_BestueFirst() {
        if (isEmpty()) {
            System.out.println("DequeLinkedList_Best is empty");
            return null;
        }
        T data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return data;
    }

    public T DequeLinkedList_BestueLast() {
        if (isEmpty()) {
            System.out.println("DequeLinkedList_Best is empty");
            return null;
        }
        T data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return data;
    }
    public T peekFirst() {
        if (isEmpty()) {
            System.out.println("DequeLinkedList_Best is empty");
            return null;
        }
        return head.data;
    }
    public T peekLast() {
        if (isEmpty()) {
            System.out.println("DequeLinkedList_Best is empty");
            return null;
        }
        return tail.data;
    }
    public void print() {
        if (isEmpty()) {
            System.out.println("DequeLinkedList_Best is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DequeLinkedList_Best<Integer> queue=new DequeLinkedList_Best<>();
        queue.enqueueFirst(5);
        queue.enqueueFirst(7);
        queue.enqueueLast(4);
        queue.print();
        queue.DequeLinkedList_BestueFirst();
        queue.print();
        queue.enqueueFirst(1);
        queue.enqueueFirst(2);
        queue.print();
        queue.DequeLinkedList_BestueLast();
        queue.print();
        queue.enqueueFirst(3);
        queue.print();
        queue.enqueueLast(queue.DequeLinkedList_BestueFirst());
        queue.print();
        System.out.println(queue.peekFirst());
        System.out.println(queue.peekLast());
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        queue.DequeLinkedList_BestueFirst();
        queue.DequeLinkedList_BestueFirst();
        queue.DequeLinkedList_BestueFirst();
        queue.DequeLinkedList_BestueFirst();
        queue.print();
        System.out.println(queue.DequeLinkedList_BestueFirst());
    }
}