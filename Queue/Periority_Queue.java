public class Periority_Queue{
        private int[] array;
        private int rear,capacity;
        public Periority_Queue(int Capacity) {
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
            array[rear]=value;
        }
        //dequeue
        public int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int index=min();
            int value=array[index];
            for (int i = index; i <(rear); i++) {
                array[i]=array[i+1];
            }
            rear--;
            return value;
        }
        private int min(){
            int min=array[0];
            int minIndex=0;
            for (int i = 0; i <=rear; i++) {
                if(min>array[i]){
                    min=array[i];
                    minIndex=i;
                }
            }
            return minIndex;
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
            Periority_Queue queue = new Periority_Queue(5);
            queue.enqueue(1);
            queue.enqueue(4);
            queue.enqueue(3);
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
