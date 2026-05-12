package java.tads.stack;

public class Node<T>{
    
    protected Node<T> next;
    protected T data;


    public Node<T> getNext()
    {
        return next;
    }

    public T getData(Node<T> node)
    {
        return data;
    }
    
    public void setRef(Node<T> next)
    {   
        this.next = next;
    }

    public void setData(T data)
    {
        this.data = data;
    }
}
