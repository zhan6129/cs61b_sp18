public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    private void resize(int capacity) {
        T[] newDeque = (T[]) new Object[capacity];
        int oldIndex = plusOne(nextFirst);
        for (int newIndex = 0; newIndex < size; newIndex++) {
            newDeque[newIndex] = items[oldIndex];
            oldIndex = plusOne(oldIndex);
        }
        items = newDeque;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == items.length;
    }

    private boolean isSparse() {
        return items.length >= 16 && size < (items.length / 4);
    }

    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    private void upSize() {
        resize(size * 2);
    }

    private void downSize() {
        resize(items.length / 2);
    }

    public void addFirst(T x) {
        if (isFull()) {
            upSize();
        }
        items[nextFirst] = x;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    public void addLast(T x) {
        if (isFull()) {
            upSize();
        }
        items[nextLast] = x;
        nextLast = plusOne(nextLast);
        size++;
    }

    public T removeFirst() {
        if (isSparse()) {
            downSize();
        }
        nextFirst = plusOne(nextFirst);
        T toRemove = items[nextFirst];
        items[nextFirst] = null; 
        if (!isEmpty()) {
            size -= 1;
        }
        return toRemove;
    }

    public T removeLast() {
        if (isSparse()) {
            downSize();
        }
        nextLast = minusOne(nextLast);
        T toRemove = items[nextLast];
        items[nextLast] = null;
        if (!isEmpty()) {
            size -= 1;
        }
        return toRemove;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return items[(nextFirst + 1 + index) % items.length];
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = plusOne(nextFirst); i != nextLast; i = plusOne(i)) {
            System.out.println(items[i] + " ");
        }
    }

}
