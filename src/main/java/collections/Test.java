package collections;

public class Test{
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