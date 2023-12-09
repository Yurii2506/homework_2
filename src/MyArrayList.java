import java.util.Arrays;

public class MyArrayList {
    private Object[] objects = new Object[3];
    private int size = 0;

    public void rebalance() {
        if (objects.length == size) {
            objects = Arrays.copyOf(objects, objects.length + 5);
        }
    }

    public void add(Object obj) {
        rebalance();
        objects[size] = obj;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Enter a valid index");
            return;
        }

        Object[] newArr = new Object[size - 1];

        System.arraycopy(objects, 0, newArr, 0, index);
        System.arraycopy(objects, index + 1, newArr, index, size - index - 1);
        size--;
        objects = Arrays.copyOf(newArr, size);
    }


    public void clear() {
        size = 0;
    }

    public int size(){
        return size;
    }

    public Object get(int index) {
        if(index < 0 || index >= size){
            return (Object) "enter the correct index";
        }
        return (Object) objects[index];
    }

    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList();

        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        arrayList.add("f");
        arrayList.add("gg");

        System.out.println(arrayList.get(2));

        System.out.println(arrayList.get(-3));

        System.out.println(arrayList.size());

        arrayList.remove(2);

        System.out.println(arrayList.get(2));

        arrayList.clear();

        System.out.println(arrayList.size());

    }
}