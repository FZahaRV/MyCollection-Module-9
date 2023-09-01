package collections;

public class Node<N>{
    N data;
    Node<N> next;
    Node<N> prev;

    public Node(N data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}