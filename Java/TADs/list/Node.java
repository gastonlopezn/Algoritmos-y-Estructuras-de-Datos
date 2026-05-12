package java.tads.list;

    public class Node<T> {
        T item;
        Node prev;
        Node next;

        Node(Node<T> prev, T element, Node<T> next) {
          this.item = element;
          this.next = next;
          this.prev = prev;
        }
    }