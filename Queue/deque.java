import java.util.Arrays;

public class Deque<E> {

    private E[] array;
    private int head;
    private int tail;
    private int size;

    public Deque() {
        array = new E[16];
        head = 0;
        tail = 0;
        size = 0;
    }

    public void addFirst(E e) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[head] = e;
        head = (head - 1 + array.length) % array.length;
        size++;
    }

    public void addLast(E e) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[tail] = e;
        tail = (tail + 1) % array.length;
        size++;
    }

    public E removeFirst() {
        if (size == 0) {
            throw new IllegalStateException("Deque is empty");
        }
        E e = array[head];
        array[head] = null;
        head = (head + 1) % array.length;
        size--;
        return e;
    }

    public E removeLast() {
        if (size == 0) {
            throw new IllegalStateException("Deque is empty");
        }
        E e = array[tail];
        array[tail] = null;
        tail = (tail - 1 + array.length) % array.length;
        size--;
        return e;
    }

    public E peekFirst() {
        if (size == 0) {
            throw new IllegalStateException("Deque is empty");
        }
        return array[head];
    }

    public E peekLast() {
        if (size == 0) {
            throw new IllegalStateException("Deque is empty");
        }
        return array[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(array, null);
        head = 0;
        tail = 0;
        size = 0;
    }
}
