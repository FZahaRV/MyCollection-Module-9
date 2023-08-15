package org.example;

import java.util.Arrays;

class MyArrayList<V>{
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
class Node<N>{
    N data;
    Node<N> next;
    Node<N> prev;

    public Node(N data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
class MyLinkedList <N> {
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
class MyQueue <N>{
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
class MyStack <N>{
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
class NodePlus<K, V>{
    K key;
    V value;
    NodePlus<K, V> next;
    public NodePlus(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
class MyHashMap<K, V>{
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
class Test{
    public static void main(String[] args){
        testMyArrayList();
        testMyLinkedList();
        testMyQueue();
        testMyStack();
        testMyHashMap();
    }

    public static void testMyArrayList(){
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("MyArrayList:");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public static void testMyLinkedList(){
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("Hello");
        linkedList.add("World");
        linkedList.add("!");
        System.out.println("MyLinkedList:");
        for(int i = 0; i < linkedList.size(); i++){
            System.out.println(linkedList.get(i));
        }
    }

    public static void testMyQueue(){
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("MyQueue:");
        while(queue.size() > 0) {
            System.out.println(queue.poll());
        }
    }

    public static void testMyStack(){
        MyStack<Character> stack = new MyStack<>();
        stack.push('a');
        stack.push('b');
        stack.push('c');

        System.out.println("MyStack:");
        while(stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    public static void testMyHashMap(){
        MyHashMap<String, Integer> hashMap = new MyHashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);
        System.out.println("MyHashMap:");
        System.out.println("one: " + hashMap.get("one"));
        System.out.println("two: " + hashMap.get("two"));
        System.out.println("three: " + hashMap.get("three"));
        hashMap.remove("two");
        System.out.println("After removing 'two':");
        System.out.println("one: " + hashMap.get("one"));
        System.out.println("two: " + hashMap.get("two"));
        System.out.println("three: " + hashMap.get("three"));
    }
}
