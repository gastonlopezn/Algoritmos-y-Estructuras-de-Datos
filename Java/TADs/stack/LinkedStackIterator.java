package java.tads.stack;
import java.util.Iterator;

public class LinkedStackIterator<T> implements Iterator<T>{

        private Node<T> curr;
    
        public LinkedStackIterator(Node<T> top)
        {
            curr = top;
        }
    
        @Override
        public boolean hasNext()
        {
            return curr.next != null;
        }
    
        @Override
        public T next()
        {
            if(!hasNext()) throw new IllegalStateException("No more elements in the stack");
            T data = curr.data;
            curr = curr.next;
            return data;
        }
    
}
