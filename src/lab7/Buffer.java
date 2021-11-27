package lab7;

import java.util.LinkedList;
import java.util.List;


public class Buffer<T> {
    private final int maxSize;
    private final List<T> buffer = new LinkedList<>();

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(T item) {
        if (this.isFull()) throw new IllegalStateException("lab7.Buffer full");
        this.buffer.add(item);
    }

    public T remove() {
        if (this.isEmpty()) throw new IllegalStateException("lab7.Buffer is empty!");
        return buffer.remove(0);
    }

    public boolean isFull() {
        return buffer.size() == maxSize;
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }
}
