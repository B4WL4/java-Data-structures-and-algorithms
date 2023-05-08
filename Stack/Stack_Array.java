public class Stack_Array<G extends Comparable> {
    G[] stackArray;
    int top,capacity;

    public Stack_Array(int size) {
        capacity=size;
        top=-1;
        stackArray= (G[]) new Comparable[capacity];
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==capacity-1;
    }
    public void push(String data){
        if(isFull()){
            System.out.println("Stack is already full...");
            return;
        }
        top++;
        stackArray[top]= (G) data;
    }
    public G pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack underFlow..");
        }else {
            G element= stackArray[top];
            top--;
            return element;
        }
    }
    public G peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty..");
        }
        return stackArray[top];
    }
    public int size(){
        return (top+1);
    }
}
