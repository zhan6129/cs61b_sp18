
public class ArrayDeque<T>{
    private T[] items;
    private int size;
    private int first;
    private int last;
    
    public ArrayDeque() {
        items = (T[])new Object[8];
        size = 0;
        first = 1;
        last = 2;
    }
    
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if (last == first - 1) {          
            for (int i = 0; i <= last; i++) {
                a[i] = items[i];
            }
            for (int i = first; i <= items.length - 1; i++) {
                a[i + 1] = items[i];
            }
            first ++;
        }
        if (first == 0 && last == items.length - 1) {
            for (int i = 0; i <= last; i++) {
                a[i] = items[i];
            }
        }
    }

    public boolean isEmpty(){
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
        items[first] = x;
        first = minusOne(first);
        size++;           
    }
    
    public void addLast(T x) {
        if (isFull()) {
            upSize();
        }
        items[last] = x;
        last = plusOne(last);
        size++;
    }
    
    public T removeFirst() {
        if (isSparse()) {
            downSize();
        }
        T toRemove = items[first];
        items[first] = null;
        first = plusOne(first);
        if (!isEmpty()) {
            size -= 1;
        }
        return toRemove;             
    }
    
    public T removeLast() {
        if (isSparse()) {
            downSize();
        }
        T toRemove = items[last];
        items[last] = null;
        last = minusOne(last);
        if (!isEmpty()) {
            size -= 1;
        }
        return toRemove;                     
    }
    
    
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return items[(first + index) % items.length];
    }
    
    public int size() {
        return size;
    }

    public void printDeque(){
        for (int i = first; i != last; i++){
            System.out.println(items[i] + " ");
        }
    }
    

}
