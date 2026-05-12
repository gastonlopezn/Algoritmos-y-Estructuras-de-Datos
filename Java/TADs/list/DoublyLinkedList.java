package java.tads.list;

import java.util.Iterator;
/**
 * LinkedList is an implementation of the TAD List, based
 * on doubly-linked lists. List represents unbounded
 * sequences of objects of type T.
 * A typical List is a sequence [o1, o2,..., on]; we
 * denote this by: this = [o1, o2,..., on].
 * The methods use equals to determine equality of elements.
 */
public class DoublyLinkedList<T> implements List<T>, Iterable<T> {
    protected Node<T> head;
    protected Node<T> last;
    protected int size;

    /**
     * @post Creates an empty List.
     *   More formally, it satisfies: this = [].
     */
    public DoublyLinkedList()
    {
        head = null;
        last = null;
        size = 0;
    }

    /**
     * @post Returns an iterator for the list that iterates through
     *   the items in forward order.
     */
    public Iterator<T> iterator() {
        return new ListIterator<T>(this);
    }

    /**
     * @post Returns the number of elements in the list.
     *   More formally, it satisfies: result = #this.
     */
    public int size() {
        return size;
    }

    /**
     * @post Returns true iff the list contains no elements.
     *   More formally, it satisfies: result = #this = 0.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @post Returns true iff the list contains element e.
     *   More formally, it satisfies:
     *   result = exists o | o in this && e.equals(o).
     */
    public boolean contains(T e) {
        for(T item : this) {
            if(item.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @post Appends element e to the end of this list.
     *   More formally, it satisfies: this = old(this) ++ [e].
     */
    public void add(T e) {
        addLast(e);
    }

    /**
     * @post  This method is equivalent to add(E).
     *   More formally, it satisfies: this = old(this) ++ [e].
     */
    private void addLast(T e) {
        Node<T> newNode = new Node<>(null,e,null);
        if (last == null) {
            head = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
        }
        last = newNode;
        size++;
    }

    /**
     * @post Appends element e to the beginning of this list.
     *   More formally, it satisfies: this = [e] ++ old(this).
     */
    public void addFirst(T e) {
        Node<T> newNode = new Node<>(null,e,null);
        if (isEmpty()) {
            head = last = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * @post Removes all the elements from the list,
     *   More formally, it satisfies: #this = 0.
     */
    public void clear() {
        head = null;
        last = null;
        size = 0;
    }

    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Returns the element at position index in the list,
     *   More formally, it satisfies: result = this[index].
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> res = nodeAtIndex(index);
        return res.item;
    }

    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Returns the Node at the specified element index.
     */
    private Node<T> nodeAtIndex(int index)
    {
        if( index < 0 || index > size() )
            throw new IndexOutOfBoundsException("Index out of bounds");
        Node<T> current;
        if(index <= size() / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = last;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Replaces the element at position index with e, and returns
     *   the element that was replaced.
     *   More formally, it satisfies:
     *     this[index].equals(e) && #this = #old(this) &&
     *     result.equals(o) && old(this).indexOf(o) == index .
     */
    public T set(int index, T e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        T old = null;
        Node<T> found = nodeAtIndex(index);
        if(found!= null) {
            old = found.item;
            found.item = e;
        }
        return old;

    }

    /**
     * @pre 0 <= index <= size() (throws an IndexOutOfBoundsException)
     * @post Inserts the element at position index with e.
     *   More formally, it satisfies:
     *   this[index].equals(e) && #this = #old(this) +1.
     */
    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else {
            Node<T> temp = new Node<>(null,e,null);
            Node<T> current = nodeAtIndex(index);
            temp.next = current;
            temp.prev = current.prev;
            current.prev.next = temp;
            current.prev = temp;
            size++;
        }
    }

    /**
     * @post Removes the first occurrence of e from this list.
     *   If e is not in the list it does not modify the list.
     *   Returns true iff e is removed (result = e in old(list)).
     */
    public boolean remove(T e) {
        int index = indexOf(e);
        if (index == -1)
            return false;

        remove(index);
        return true;
    }

    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Removes the element at position index.
     *   More formally, it satisfies:
     *   result = old(this)[index] && #this = #old(this) -1.
     */
    public T remove(int index) {
        // TODO: Implement
        throw new UnsupportedOperationException("method not yet implemented");
    }

    /**
     * @post  Removes the element at position 0.
     */
    private T removeAtFirst() {
        Node<T> temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
        return temp.item;
    }
    /**
     * @post Removes the element at position size - 1
     */
    private T removeAtLast() {
        Node<T> temp = last;
        last = last.prev;
        last.next = null;
        temp.prev = null;
        return temp.item;
    }

    /**
     * @post Returns the index of the first occurrence of e
     *   in the list, or -1 if this list does not contain e.
     *   More formally, it satisfies:
     *     result = -1 -> !(e in this) &&
     *     result != -1 -> this[result].equals(e).
     */
    public int indexOf(T e) {
        // TODO: Implement
        throw new UnsupportedOperationException("method not yet implemented");
    }

    /**
     * @post Returns a string representation of the stack. Implements
     *   the abstraction function. Hence, it represents the stack as a
     *   sequence "[o1, o2,..., on]".
     */
    public String toString() {
        // TODO: Implement
        throw new UnsupportedOperationException("method not yet implemented");
    }

    /**
     * @post Returns true if and only if list is a
     *   valid doubly linked list.
     */
    public static boolean repOK() {
        // TODO: Implement
        throw new UnsupportedOperationException("method not yet implemented");
    }


}
