package collections;

public class NodePlus<K, V>{
    K key;
    V value;
    NodePlus<K, V> next;
    public NodePlus(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}