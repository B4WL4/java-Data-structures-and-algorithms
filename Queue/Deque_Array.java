public class Deque_Array<T> {
    private int front, rear, size;
    private int capacity;
    private T[] deque;

    public Deque_Array(int capacity) {
        this.capacity = capacity;
        this.front = -1;
        this.rear = 0;
        this.size = 0;
        this.deque = (T[]) new Object[this.capacity];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public void insertFront(T data) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }
        if (this.front == -1) {
            this.front = 0;
            this.rear = 0;
        } else if (this.front == 0) {
            this.front = this.capacity - 1;
        } else {
            this.front--;
        }
        this.deque[this.front] = data;
        this.size++;
    }

    public void insertRear(T data) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }
        if (this.front == -1) {
            this.front = 0;
            this.rear = 0;
        } else if (this.rear == this.capacity - 1) {
            this.rear = 0;
        } else {
            this.rear++;
        }
        this.deque[this.rear] = data;
        this.size++;
    }

    public T deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return null;
        }
        T data = this.deque[this.front];
        if (this.front == this.rear) {
            this.front = -1;
            this.rear = -1;
        } else if (this.front == this.capacity - 1) {
            this.front = 0;
        } else {
            this.front++;
        }
        this.size--;
        return data;
    }

    public T deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return null;
        }
        T data = this.deque[this.rear];
        if (this.front == this.rear) {
            this.front = -1;
            this.rear = -1;
        } else if (this.rear == 0) {
            this.rear = this.capacity - 1;
        } else {
            this.rear--;
        }
        this.size--;
        return data;
    }

    public T getFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return null;
        }
        return this.deque[this.front];
    }

    public T getRear() {
        if (isEmpty() || this.rear < 0) {
            System.out.println("Deque is empty");
            return null;
        }
        return this.deque[this.rear];
    }

    public int getSize() {
        return this.size;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }
        System.out.print("Deque Elements: ");
        int i = this.front;
        while (i != this.rear) {
            System.out.print(this.deque[i] + " ");
            i = (i + 1) % this.capacity;
        }
        System.out.print(this.deque[this.rear]);
        System.out.println();
    }
}