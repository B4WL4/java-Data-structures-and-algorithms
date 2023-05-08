public class SingleLinkedList <E extends Comparable>{
    private Node<E> head,tail;
    private int size;
    //------------------------------------ constructor ------------------------------------
    public SingleLinkedList() {
        head=tail=null;
        size=0;
    }

    //------------------------------------ print ------------------------------------
    public void print(){
        System.out.println(toString());
    }

    //------------------------------------- ADD -----------------------------------
    public void addAtStart(E data){
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
        if (index<=0){
            head=new Node(data,head);
            size++;
            setTail();
            return;
        }
        Node<E> temp=head;
        for (int i = 0; i <index-1 && temp.getNext()!=null; i++) {
            temp=temp.getNext();
        }
        temp.setNext(new Node(data,temp.getNext()));
        size++;
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
            head=head.getNext();
            size--;
            setTail();
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
    public void copy(SingleLinkedList<E> list){
       Node<E> temp=list.getHead();
       while (temp!=null){
           add(temp.getData());
           temp=temp.getNext();
       }
    }
    //----------------------------------- check -------------------------------------
    //----------------------------------- reverse -------------------------------------
    public void reverse(){
        if(head==null || size==1)return;
        Node<E> prev=null,next=null,current=head;
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
//    public void reverse(){
        //        if(head==null || head.getNext()==null)return;
//        Node<E> prev=null,next=null;
//        Node<E> temp = head;
//        while (temp!=null){
//            next = temp.getNext();
//             temp.setNext(prev);
//             prev = temp;
//             temp=next;
//        }
//        tail=head;
//        head=prev;
//    }
    //----------------------------------- merge -------------------------------------
    public void merge(SingleLinkedList<E> temp)
    {
        SingleLinkedList<E> list=new SingleLinkedList<>();
        list.copy(temp);
        tail.setNext(list.getHead());
        setTail();
        size+=list.Size();
    }
    //------------------------------------------------------------------------
    private void setTail(){
        Node temp=head;
        while (temp.getNext()!=null){
            temp=temp.getNext();
        }
        tail=temp;
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
