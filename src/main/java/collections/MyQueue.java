package collections;

public class MyQueue <N>{
    private Node<N> head;
    private int size;
    public MyQueue(){
        head = null;
        size = 0;
    }
    public void add(N data){
        Node<N> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
        }else{
            Node<N> current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    public N peek(){
        if(head == null){
            return null;
        }
        return head.data;
    }
    public N poll(){
        if(head == null){
            size = 0;
            return null;
        }
        N result = head.data;
        head = head.next;
        size--;
        return result;
    }

    public int size(){
        return size;
    }
    public void clear(){
        size = 0;
        head = null;
    }
}
