import java.util.Objects;

public class MyHashMap {
    private static final int CAPACITY = 16;
    private Node[] table;
    private int size;
    private static class Node {
        private final Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    public MyHashMap() {
        table = new Node[CAPACITY];
        size = 0;
    }

    public void put(Object key, Object value) {
        int hash = Objects.hashCode(key);
        int index = hash % table.length;

        Node node = new Node(key, value, null);

        if (table[index] == null) {
            table[index] = node;
            size++;
        } else {
            Node current = table[index];
            Node prev = null;

            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                prev = current;
                current = current.next;
            }

            prev.next = node;
            size++;
        }
    }

    public void remove(Object key) {
        int hash = Objects.hashCode(key);
        int index = hash % table.length;

        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        table = new Node[CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int hash = Objects.hashCode(key);
        int index = hash % table.length;

        Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);
        hashMap.put("four", 4);

        System.out.println(hashMap.get("two"));

        System.out.println(hashMap.size());

        hashMap.remove("two");

        System.out.println(hashMap.size());

        hashMap.clear();

        System.out.println(hashMap.size());

    }

}