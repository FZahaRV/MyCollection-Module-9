package collections;

public class MyStack <N>{
    private Node<N> head;
    private int size;
    public MyStack(){
        this.head = null;
        size = 0;
    }
    public void push(N data){
        Node<N> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
        }else{
            Node<N> current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
            current.prev = current;
        }
        size++;
    }
    public void remove(int index){
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
    public void clear(){
        size = 0;
        head = null;
    }
    public int size(){
        return size;
    }
    public N peek() {
        if (head == null) {
            return null;
        } else {
            Node<N> current = head;
            while (current.next != null) {
                current = current.next;
            }
            return current.data;
        }
    }
    public N pop() {
        if (head == null) {
            return null;
        }
        if (head.next == null){
            N result = head.data;
            head = null;
            size = 0;
            return result;
        } else {
            Node<N> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            N result = current.next.data;
            current.next = null;
            size--;
            size++;
            return result;
        }
    }
}