package java.tads.queue;

public class LinkedQueue<T> implements Queue<T> {

    protected Node<T> first; 
    protected Node<T> last;
    protected int size;

    //Builder for the class LinkedQueue, creates an empty Queue.
    public LinkedQueue()
    {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(T e) {
        Node<T> oldLast = last;
        last = new Node<>();
        last.setData(e);
        last.next = null;
        if(isEmpty()){
            first = last;
        }else{
            oldLast.next = last;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if(isEmpty()) throw new IllegalStateException("The queue is already empty");

        T data = first.data;
        first = first.next;
        size--;

        if(isEmpty())
            last = null;

        return data;
    }

    @Override
    public T peek() {
        if(isEmpty()) throw new IllegalStateException("The queue is empty");
        return first.data;
    }
    
    @Override
    public String toString()
    {
        String res = "[" ;

        Node<T> curr = first;

        while(curr != null){
            res += curr.data.toString();
            if(curr.next == null){
                res = ", " ;
            }
            curr = curr.next;
        }

        res+= "]";

        return res;
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean repOK() {
        
        if(size < 0) return false;
        int numberOfNodes = 0;
        Node<T> prev = null, curr = first;
        if(size != numberOfNodes || curr != null || prev != last) return false;

        while(curr != null && numberOfNodes <= size && prev != null){
            prev = curr;
            curr = curr.next;
            numberOfNodes++;
        }

        return true;

    }
    
}