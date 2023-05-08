public class CircularSingleLinkedList<E extends Comparable> {
    private Node<E> head,tail;
    private int size;
    //------------------------------------ constructor ------------------------------------
    public CircularSingleLinkedList() {
        head=tail=null;
        size=0;
    }

    //------------------------------------ print ------------------------------------
    public void print(){
        System.out.println(toString());
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
    public void addAtStart(E data){
        add(0,data);
    }
    public void add(E data){ //addion at end
        add(size,data);
    }

    public void addAll(E ...d){
        for (E data:d) {
            add(size,data);
        }
    }
    public void add(int index,E data){
        if(head==null){
            tail=head=new Node<>(data,head);
            size++;
            return;
        }
        if (index<=0){
            head=new Node(data,head);
            tail.setNext(head);
            size++;
            return;
        }
        if(index>size) index=size;
        Node<E> temp=head;
        for (int i = 0; i <index-1; i++) {
            temp=temp.getNext();
        }
        temp.setNext(new Node(data,temp.getNext()));
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
            head=head.getNext();
            tail.setNext(head);
            size--;
            return;
        }
        Node<E> temp=head;
        for (int i = 0; i < index-1; i++) {
            temp=temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
        setTail();
        size--;
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
    public void copy(CircularSingleLinkedList<E> list){
        if(list.head==null) return;
        Node<E> temp=list.getHead();
        do{
            add(temp.getData());
            temp=temp.getNext();
        }while (temp!=list.head && temp!=null);
    }
    //----------------------------------- check -------------------------------------
    //----------------------------------- reverse -------------------------------------
//    public void reverse(){
//        if(head==null)return;
//        Node<E> prev=null,next=null,current=head;
//        do{
//            if(current.getNext()!=null) {
//                next = current.getNext();
//            }
//            current.setNext(prev);
//            prev=current;
//            current=next;
//        }while (current!=head && current!=null);
//        head.setNext(prev);
//        head=prev;
//    }
    public void reverse(){
        if(head==null || size==1)return;
        Node<E> prev=tail,next=null,current=head;
        int count=0;
        while (count<size){
            next=current.getNext();
            current.setNext(prev);
            prev=current;
            current=next;
            count++;
        }
        head=prev;
        setTail();
    }
    //----------------------------------- merge -------------------------------------
    public void merge(CircularSingleLinkedList<E> temp)
    {
        CircularSingleLinkedList<E> list=new CircularSingleLinkedList<>();
        list.copy(temp);
        if(head==null){
            head=list.head;
            tail=list.tail;
            size=list.Size();
            return;
        }
        if (list.head==null){
            return;
        }
        tail.setNext(list.getHead());
        tail=list.getTail();
        tail.setNext(head);
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
