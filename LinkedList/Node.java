public class Node <E extends Comparable>
{
    private E data;
    private Node prev,next;

    public Node() {
    }

    public Node(E data) {
        this.data = data;
    }

    public Node(E data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(E data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
