package java.tads.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An Iterator implementation for CircularQueue
 */
public class ArrayIterator<T> implements Iterator<T> {

    @SuppressWarnings("FieldMayBeFinal")
    private CircularQueue<T> queue;

    /**
     * @post Creates an iterator for queue
     */
    public ArrayIterator(CircularQueue<T> queue) {
        this.queue = queue;
    }
    private int i = 0;

    /**
     * @post Returns true if and only if the iteration has more elements.
     */
    @Override
    public boolean hasNext() {
        return i < queue.size;
    }

    /**
     * @pre hasNext() (throws NoSuchElementException).
     * @post Returns the next element in the iteration.
     */
    @Override
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();

        T item = queue.queue[(i + queue.first) % queue.queue.length];
        i++;
        return item;
    }
}
