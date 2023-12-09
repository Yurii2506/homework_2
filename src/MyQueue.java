import java.util.Arrays;

public class MyQueue {
    private Object[] objects = new Object[3];
    private int size = 0;

    public void rebalance() {
        if (objects.length == size) {
            objects = Arrays.copyOf(objects, objects.length + 5);
        }
    }

    public void add(Object value) {
        rebalance();
        objects[size] = value;
        size++;
    }

    public void clear() {
        size = 0;
    }

    public int size(){
        return size;
    }

    public Object peek() {
        if (size == 0) {
            return null;
        }
        return objects[0];
    }

    public Object poll() {
        if (size == 0) {
            return null;
        }

        Object firstElement = objects[0];

        System.arraycopy(objects, 1, objects, 0, size - 1);
        size--;

        return firstElement;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        queue.add("e");
        System.out.println(queue.peek());

        System.out.println(queue.poll());

        System.out.println(queue.peek());

        System.out.println(queue.size());

        queue.clear();

        System.out.println(queue.size());
    }
}