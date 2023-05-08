public class Periority_Queue2{
    private int[] array;
    private int rear,capacity;
    public Periority_Queue2(int Capacity) {
        capacity = Capacity;
        array=new int[capacity];
        rear=-1;
    }
    public boolean isFull(){
        return (rear+1)==capacity;
    }
    public boolean isEmpty(){
        return rear==-1;
    }
    //Enqueue
    public void enqueue(int value){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        rear++;
        for (int i = 0; i <rear; i++) {
            if(value<array[i]){
                int t=array[i];
                array[i]=value;
                value=t;
            }
        }
        array[rear]=value;
    }
    //dequeue
    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int value=array[0];
        for (int i = 0; i <(rear); i++) {
            array[i]=array[i+1];
        }
        rear--;
        return value;
    }
    //peak
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
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
        Periority_Queue2 queue = new Periority_Queue2(5);
        queue.enqueue(1);
        queue.enqueue(4);
        queue.enqueue(2);
        queue.enqueue(2);
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
