package collections;

import java.util.Arrays;

public class MyArrayList<V>{
    private static final int DEFAULT_SIZE = 5;
    private V[] elements;
    private int size;
    public MyArrayList(){
        this(DEFAULT_SIZE);
    }
    public MyArrayList(int initialCapacity){
        if (initialCapacity < 0){
            throw new IllegalArgumentException("Capacity cannot be lover than 0");
        }
        elements = (V[]) new Object[initialCapacity];
        size = 0;
    }
    public void add(V element){
        capacity(size + 1);
        elements[size++] = element;
    }
    public void remove(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("Ihe index must be no less than 0 and no more than " + size);
        }
        for(int i = index; i < size - 1; i++){
            elements[i] = elements[i+1];
        }
    }
    public void clear(){
        size = 0;
        elements = (V[]) new Object[DEFAULT_SIZE];
    }
    public V get(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("Ihe index must be no less than 0 and no more than " + size);
        }
        return (V) elements[index];
    }
    public int size() {
        return size;
    }
    public void capacity(int size){
        if(size > elements.length){
            elements = Arrays.copyOf(elements, size);
        }
    }
}