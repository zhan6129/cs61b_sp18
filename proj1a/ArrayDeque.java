
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
    
    
    public void addFirst(T x) {
        if (size == items.length){
            resize(size + 1);
        }
        items[first] = x;
        if (first != 0) {
            first--;
        }
        else {
            first = items.length - 1;
        }
        size++;
             
    }
    
    public void addLast(T x) {
        if (size == items.length) {
            resize(size + 1);
        }
        items[last] = x;
        if (last != items.length - 1) {
            last++;
        }
        else {
            last = 0;
        }
        size++;
    }
    
    public T removeFirst() {
        T toRemove = items[first];
        if (items.length >= 16) {
            T[] a = (T[]) new Object[items.length - 1];
            for (int i = 0; i < first; i++) {
                a[i] = items[i];
            }
            for (int i = first; i < items.length - 1; i++) {
                a[i] = items[i + 1];
            }           
        }
        else {
            T[] a = (T[]) new Object[items.length];
            for (int i = 0; i < first; i++) {
                a[i] = items[i];
            }
            for (int i = first + 1; i < items.length; i++) {
                a[i] = items[i];
            }
            first++;        
        }
        if (!isEmpty()) {
            size -= 1;
        }
        return toRemove;             
    }
    
    public T removeLast() {
        T toRemove = items[last];
        if (items.length >= 16) {
            T[] a = (T[]) new Object[items.length - 1];
            for (int i = 0; i < last; i++) {
                a[i] = items[i];
            }
            for (int i = last; i < items.length - 1; i++) {
                a[i] = items[i + 1];
            }           
        }
        else {
            T[] a = (T[]) new Object[items.length];
            for (int i = 0; i < last; i++) {
                a[i] = items[i];
            }
            for (int i = last+1; i < items.length; i++) {
                a[i] = items[i];
            }
            last--;        
        }
        if (!isEmpty()) {
            size -= 1;
        }
        return toRemove;
                     
    }
    
    
    public T get(int i) {
        return items[i];
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
