package collections;

public class MyHashMap<K, V>{
    private NodePlus<K, V> head;
    private int size;
    public MyHashMap(){
        this.head = null;
        size = 0;
    }
    public void put(K key, V value){
        NodePlus<K, V> newNodePlus = new NodePlus<>(key, value);
        if(head == null){
            head = newNodePlus;
        }else{
            NodePlus<K, V> current = head;
            while(current.next != null){
                if(key.equals(current.key)){
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            current.next = newNodePlus;
        }
        size++;
    }
    public void remove(K key){
        if(key == head.key){
            head = head.next;
        }else {
            NodePlus<K, V> current = head;
            while(current.next != null) {
                if(key.equals(current.next.key)){
                    current.next = current.next.next;
                    size--;
                    return;
                }
                current = current.next;
            }
        }
    }
    public V get(K key){
        if(head == null){
            return null;
        }
        if(key.equals(head.key)){
            return head.value;
        }else{
            NodePlus<K, V> current = head;
            while(current.next != null) {
                if(key.equals(current.next.key)){
                    return current.next.value;
                }
                current = current.next;
            }
            return null;
        }
    }
    public void clear(){
        size = 0;
        head = null;
    }
    public int size(){
        return size;
    }
}