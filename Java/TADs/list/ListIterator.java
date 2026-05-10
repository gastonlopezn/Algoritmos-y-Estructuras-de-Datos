package Java.TADs.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An Iterator implementation for ListDoublyLinked
 */
public class ListIterator<T> implements Iterator<T> {
  private Node<T> current;

  /**
   * @post Creates an iterator for stack
   */
  public ListIterator(DoublyLinkedList<T> doublyList)
  {
    this.current = doublyList.head;
  }

  /**
   * @post Returns true if and only if the iteration has more elements.
   */
  public boolean hasNext()
  {
    return current != null;
  }

  /**
   * @pre hasNext() (throws NoSuchElementException).
   * @post Returns the next element in the iteration.
   */
  public T next()
  {
    if (!hasNext())
      throw new NoSuchElementException();

    T item = current.item;
    current = current.next;
    return item;
  }
}
