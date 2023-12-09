public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        Object data;
        Node next;
        Node prev;

        public Node(Object data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public void add(Object value){
        Node Node = new Node(value);
        if(size == 0){
            head = tail = Node;
        } else {
            Node.prev = tail;
            tail.next = Node;
            tail = Node;
        }
        size++;
    }

    public void remove(int index) {

        Node value = head;
        for (int i = 0; i < index; i++) {
            value = value.next;
        }

        if (value.prev != null) {
            value.prev.next = value.next;
        } else {
            head = value.next;
        }

        if (value.next != null) {
            value.next.prev = value.prev;
        } else {
            tail = value.prev;
        }

        if (index == size - 1) {
            tail = value.prev;
        }

        size--;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index){
        if(index < 0 || index >= size) {
            return (Object) "enter the correct index";
        }
        Node value = head;
        for(int i = 0; i < index; i++){
            value = value.next;
        }
        return value.data;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");

        System.out.println(linkedList.get(1));

        System.out.println(linkedList.get(9));

        linkedList.remove(1);

        System.out.println(linkedList.get(1));

        System.out.println(linkedList.size());

        linkedList.clear();

        System.out.println(linkedList.size());

    }

}