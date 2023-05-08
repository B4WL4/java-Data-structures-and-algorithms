public class DoubleLinkedList <E extends Comparable>{
    private Node<E> head,tail;
    private int size;
    //------------------------------------ constructor ------------------------------------
    public DoubleLinkedList() {
        head=tail=null;
        size=0;
    }

    //------------------------------------ print ------------------------------------
    public void print(){
        System.out.println(toString());
    }
    public void printReverse(){
        String s = "LinkedList: [";
        Node<E> current=tail;
        while (current!=null){
            s+=current.getData()+" -> ";
            current=current.getPrev();
        }
        s+="NULL]";
        System.out.println(s);
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
        size++;
        if(head==null) {
            head = new Node<>(data, null, null);
            tail=head;
            return;
        }
        Node<E> temp;
        if(index<=0) {
            temp = new Node<>(data, null, head);
            head.setPrev(temp);
            head = temp;
            return;
        }
        temp=head;
        for (int i = 0; i <index-1 && temp.getNext()!=null; i++) {
            temp=temp.getNext();
        }
        Node n=new Node(data,temp,temp.getNext());
        if(n.getNext()!=null){
            n.getNext().setPrev(n);
        }
        temp.setNext(n);
        setTail();
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
            head.getNext().setPrev(null);
            head=head.getNext();
            size--;
            return;
        }
        Node<E> temp=head;
        for (int i = 0; i < index-1; i++) {
            temp=temp.getNext();
        }
        if(temp.getNext().getNext()!=null) {
            temp.getNext().getNext().setPrev(temp);
        }
        temp.setNext(temp.getNext().getNext());
        size--;
        setTail();
    }
    //------------------------------------- Search -----------------------------------
    public int search(E value){
        int index=-1;
        Node<E> temp=head;
        int count=0;
        while (temp!=null){
            if(temp.getData().equals(value)){
                index=count;
                break;
            }
            temp=temp.getNext();
            count++;
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
            for (Node<E> temp = head; temp.getNext() != null; temp = temp.getNext()) {
                if (temp.getData().compareTo(temp.getNext().getData()) > 0) {
                    data = (E) temp.getData();
                    temp.setData((E) temp.getNext().getData());
                    temp.getNext().setData(data);
                }
            }
        }
    }
    //----------------------------------- Copy -------------------------------------
    public void copy(DoubleLinkedList<E> list){
        Node<E> temp=list.getHead();
        while (temp!=null){
            add(temp.getData());
            temp=temp.getNext();
        }
    }
    //----------------------------------- check -------------------------------------
    //----------------------------------- reverse -------------------------------------
    public void reverse(){
        if(head==null || head.getNext()==null)return;
        Node<E> temp=head,prev=null;
        while (temp!=null){
            prev=temp.getPrev();
            temp.setPrev(temp.getNext());
            temp.setNext(prev);
            temp=temp.getPrev();
        }
        tail=head;
        head=prev.getPrev();
    }
    //----------------------------------- merge -------------------------------------
    public void merge(DoubleLinkedList<E> temp)
    {
        DoubleLinkedList<E> list=new DoubleLinkedList<>();
        list.copy(temp);
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
        list.getHead().setPrev(tail);
        tail=list.getTail();
        size+=list.Size();
    }
    //------------------------------------------------------------------------
    private void setTail(){
        if(head!=null) {
            Node<E> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            tail = temp;
        }
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
        Node<E> current=head;
        while (current!=null){
            s+=current.getData()+" -> ";
            current=current.getNext();
        }
        s+="NULL]";
        return s;
    }
}
