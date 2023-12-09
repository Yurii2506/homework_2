import java.util.Arrays;

public class MyStack {
    private Object[] objects = new Object[2];
    private int size = 0;

    public void rebalance() {
        if (objects.length == size) {
            objects = Arrays.copyOf(objects, objects.length + 5);
        }
    }

    public void push(Object value) {
        rebalance();
        objects[size] = value;
        size++;
    }

    public void remove(int index){
        Object[] Arr = new Object[size - 1];

        System.arraycopy(objects, 0, Arr, 0, index);
        System.arraycopy(objects, index + 1, Arr, index, size - index - 1);
        size--;
        objects = Arrays.copyOf(Arr, size);
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
        return objects[size - 1];
    }

    public Object pop() {
        if (size == 0) {
            return null;
        }

        Object firstElement = objects[--size];
        objects[size] = null;
        return firstElement;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        System.out.println(stack.size());

        stack.remove(2);

        System.out.println(stack.size());

        System.out.println(stack.peek());

        System.out.println(stack.pop());

        System.out.println(stack.peek());

        stack.clear();

        System.out.println(stack.size());
    }
}