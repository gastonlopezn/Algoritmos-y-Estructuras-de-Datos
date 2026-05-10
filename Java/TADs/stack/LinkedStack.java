package Java.TADs.stack;

public class LinkedStack<T> implements Stack<T>{
    
    protected int size; // Stack's size
    protected Node<T> top; // Stack's top
    protected String abstraccion; // Stack´s abstraction

    /*
    * Builder for the class StackLinkedList
     */
    public LinkedStack()
    {
        size = 0;
        top = null;
        abstraccion = "[";
    }

    /*
    * @post Returns the size of the stack.
     */
    @Override
    public int size()
    {
        return size;
    }

    /*
    * @post Returns true if the stack is empty, false if not
     */
    @Override
    public boolean isEmpty()
    {
        return top == null;
    }

    /*
    *  @post Adds data to the top of the stack
     */
    @Override
    public void push(T data)
    {
        Node<T> oldTop = top;
        top = new Node<>();
        top.data = data;
        top.next = oldTop;
        abstraccion = abstraccion + data;
        size++;
    }

    /*
    * @post Returns the top of the stack
     */
    @Override
    public T top()
    {
        if(isEmpty()) throw new IllegalStateException("The stack is empty");
        return top.data;
    }

    @Override
    public T pop()
    {
        if(isEmpty()) throw new IllegalStateException("The stack is empty");
        T data = top.data; 
        top = top.next;
        size--;
        return data;
    }

    @Override
    public String toString()
    {
        Node<T> n = top; 
        String toString = "";
        while (n != null) {
            if (toString.length() == 0) {
                toString = n.data + "]";
            } else {
                toString = n.data + ", " + toString;
            }
            n = n.getNext();
        }
        toString = "[" + toString;
        return toString;
    }
        

    @Override
    public LinkedStackIterator<T> iterator()
    {
        return new LinkedStackIterator<>(top);
    }
  
    @Override
    public boolean repOK() {
        if(size < 0) return false;

        int numberOfNodes = 0;
        Node<T> curr = top;

        while(curr != null && numberOfNodes <= size){
            numberOfNodes++;
            curr = curr.next;
        }
        return !(numberOfNodes != size || curr != null);
    }

    

}




