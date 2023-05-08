public class SimpleQueue_Array<T> {
    private T[] array;
    private int rear,capacity;
    public SimpleQueue_Array(int Capacity) {
        capacity = Capacity;
        array= (T[]) new Object[capacity];
        rear=-1;
    }
    public boolean isFull(){
        return (rear+1)==capacity;
    }
    public boolean isEmpty(){
        return rear==-1;
    }
    //Enqueue
    public void enqueue(T value){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        rear++;
        array[rear]=value;
    }
    //dequeue
    public T dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        T value=array[0];
        for (int i = 0; i <(rear); i++) {
            array[i]=array[i+1];
        }
        rear--;
        return value;
    }
    //        private int min(){
//            T min=array[0];
//            int minIndex=-1;
//            for (int i = 0; i < size; i++) {
//                T read=array[(front + i) % capacity];
//                if(min > read){
//                    min=array[(front+i)%capacity];
//                    minIndex=
//                }
//            }
//            return -1;
//        }
    //peak
    public T peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        return array[0];
    }
    //size
    public int getSize(){
        return rear+1;
    }
    //print
    public void print(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue Elements: ");
        for(int i=0;i<=rear;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SimpleQueue_Array<Integer> queue = new SimpleQueue_Array<>(5);
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
        System.out.println(queue.isFull());
        System.out.println(queue.getSize());
    }
}
