public class Queue_Array<T>
{
    private T[] array;
    private int size,front,rear,capacity;
    public Queue_Array(int Capacity) {
        capacity = Capacity;
        array= (T[]) new Object[capacity];
        front=0;
        rear=-1;
        size=0;
    }
    public boolean isFull(){
        return size==capacity;
    }
    public boolean isEmpty(){
        return size==0;
    }
    //Enqueue
    public void enqueue(T value){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        rear=(rear+1)%capacity;
        array[rear]=value;
        size++;
    }
    //dequeue
    public T dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        T value=array[front];
        front=(front+1)%capacity;
        size--;
        return value;
    }
    //peak
    public T peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        return array[front];
    }
    //size
    public int getSize(){
        return size;
    }
    //print
    public void print(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue Elements: ");
        for(int i=0;i<size;i++){
            System.out.print(array[(front+i)%capacity]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue_Array<Integer> queue = new Queue_Array<>(5);
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
