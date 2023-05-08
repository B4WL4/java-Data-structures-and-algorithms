public class CircularDoubleLinkedList <E extends Comparable>{
    private Node<E> head,tail;
    private int size;
    //------------------------------------ constructor ------------------------------------
    public CircularDoubleLinkedList() {
        head=tail=null;
        size=0;
    }

    //------------------------------------ print ------------------------------------
    public void print(){
        System.out.println(toString());
    }
    public void printReverse(){
        String s = "LinkedList: [";
        if(head==null){
            s+="NUll]";
        }
        else {
            Node<E> current = tail;
            do{
                s += current.getData() + " -> ";
                current = current.getPrev();
            }while (current != tail && current!=null);
            s+="Tail]";
        }
        System.out.println(s);
    }
    //to check linked list is circular printing list to Nth count number
    public void verify(int count){
        Node<E> temp=head;
        for (int i = 0; i < count; i++) {
            System.out.print(temp.getData()+" -> ");
            temp=temp.getNext();
        }
        System.out.println();
    }
    //------------------------------------- ADD -----------------------------------
    public void addStart(E data){
        add(0,data);
    }
    public void add(E data){ //addion at end
        add(size,data);
    }

    public void addAll(E ...d){
        for(E data:d){
            add(size,data);
        }
    }
    public void add(int index,E data){
        if(head==null) {
            tail = head = new Node<>(data, head, head);
            size++;
            return;
        }

        if(index<=0) {
            Node<E> temp = new Node<>(data, tail, head);
            head.setPrev(temp);
            tail.setNext(temp);
            head=temp;
            size++;
            return;
        }
        if(index>size)index=size;
        Node<E> temp=head;
        for (int i = 0; i <index-1; i++) {
            temp=temp.getNext();
        }
        Node n=new Node(data,temp,temp.getNext());
        if(temp.getNext()!=null) {
            temp.getNext().setPrev(n);
        }
        temp.setNext(n);
        setTail();
        size++;
    }
    //------------------------------------- delete -----------------------------------
    public void deleteStart(){
        delete(0);
    }
    public void deleteEnd(){
        delete(size-1);
    }
    public void deleteValue(E value){
        int index=search(value);
        if(index<0) {
            System.out.println("Value "+value+" which you want to delete not found..");
        }
        else
            delete(index);
    }
    public void delete(int index){
        if(head==null){
            System.out.println("Linked list is empty");
            return;
        }
        if(index>=size || index<0){
            System.out.println("Index "+index+" is out of bound of Linked list ");
            return;
        }
        if (index==0){
            head.getNext().setPrev(tail);
            head=head.getNext();
            tail.setNext(head);
            size--;
            return;
        }
        Node<E> temp=head;
        for (int i = 0; i < index-1; i++) {
            temp=temp.getNext();
        }
        temp.getNext().getNext().setPrev(temp);
        temp.setNext(temp.getNext().getNext());
        size--;
        setTail();
    }
    //------------------------------------- Search -----------------------------------
    public int search(E value){
        int index=-1;
        Node<E> temp=head;
        for (int i = 0; i < size; i++) {
            if(temp.getData().equals(value)){
                index=i;
                break;
            }
            temp=temp.getNext();
        }
        return index;
    }
    //-------------------------------------- Update ----------------------------------
    public void update(int index,E value){
        if(index>=size || index<0){
            System.out.println("Index "+index+" is out of bound of Linked list ");
            return;
        }
        Node<E> temp=head;
        for (int i = 0; i < index; i++) {
            temp=temp.getNext();
        }
        temp.setData(value);
    }
    public void updateValue(E value,E newValue){
        int index=search(value);
        if(index<0) {
            System.out.println("Value "+value+" which you want to update not found..");
        }
        else
            update(index,newValue);
    }
    //----------------------------------Sorting Method --------------------------------------
    public void sort(){
        if(head==null) return;
        E data;
        for (int i = 0; i < size; i++) {
            for (Node<E> temp = head; temp.getNext() != head; temp = temp.getNext()) {
                if (temp.getData().compareTo(temp.getNext().getData()) > 0) {
                    data = (E) temp.getData();
                    temp.setData((E) temp.getNext().getData());
                    temp.getNext().setData(data);
                }
            }
        }
    }
    //----------------------------------- Copy -------------------------------------
    public CircularDoubleLinkedList<E> copy(){
        if(head==null) {
            return null;
        }
        else {
            CircularDoubleLinkedList<E> list =new CircularDoubleLinkedList<>();
            Node<E> temp = head;
            do {
                list.add(temp.getData());
                temp = temp.getNext();
            } while (temp != head && temp != null);
            return list;
        }
    }
    //----------------------------------- check -------------------------------------
    //----------------------------------- reverse -------------------------------------
    public void reverse(){
        if(head==null || size==1)return;
        Node<E> temp=head,prev=tail;
        do{
            prev=temp.getPrev();
            temp.setPrev(temp.getNext());
            temp.setNext(prev);
            temp=temp.getPrev();
        }while (temp!=head&&temp!=null);
        tail=head;
        head=prev.getPrev();
    }
    //----------------------------------- merge -------------------------------------
    public void merge(CircularDoubleLinkedList<E> temp)
    {
        CircularDoubleLinkedList<E> list=temp.copy();
        if(list.head==null)
            return;
        else if(head==null)
        {
            head=list.head;
            tail=list.tail;
            size=list.Size();
            return;
        }
        tail.setNext(list.getHead());
        list.getTail().setNext(head);
        list.getHead().setPrev(tail);
        head.setPrev(list.getTail());
        tail=list.getTail();
        size+=list.Size();
    }
    //------------------------------------------------------------------------
    private void setTail(){
        Node<E> prev,temp=head;
        do{
            prev=temp;
            temp=temp.getNext();
        }while (temp!=head && temp!=null);
        tail=prev;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public int Size() {
        return size;
    }

    @Override
    public String toString() {
        String s = "LinkedList: [";
        if(head==null){
            s+="NUll]";
        }
        else {
            Node<E> current = head;
            do{
                s += current.getData() + " -> ";
                current = current.getNext();
            }while (current != head && current!=null);
            s+="Head]";
        }
        return s;
    }
}
