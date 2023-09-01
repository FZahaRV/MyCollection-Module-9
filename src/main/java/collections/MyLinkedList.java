package collections;

public class MyLinkedList <N> {
    private Node<N> head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(N data) {
        Node<N> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<N> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            current.prev = current;
        }
        size++;
    }

    public N get(int index) {
        if (head == null){
            return null;
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<N> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        return size ;
    }

    public void clear() {
        Node<N> current = head;
        while(current != null){
            Node<N> next = current.next;
            current.next = null;
            current.prev = null;
            current = next;
        }
        size = 0;
        head = null;
    }

    public void remove(int index){
        if(head == null){
            return;
        }
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if(index == 0){
            head = head.next;
            if(head != null){
                head.prev = null;
            }
        }else {
            Node<N> current = head;
            for(int i = 0; i < index - 1; i++){
                current = current.next;
            }
            current.prev.next = current.next;
            if(current.next != null){
                current.next.prev = current.prev;
            }
        }
        size--;
    }
}