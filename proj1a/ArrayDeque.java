
public class ArrayDeque<Item>
{
    private Item[] items;
    private int size;
    private int first;
    private int last;
    
    public ArrayDeque() {
        items = (Item[])new Object[8];
        size = 0;
        first = 1;
        last = 2;
    }
    
    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        if (last == first - 1) {          
            for (int i = 0; i <= last; i++) {
                a[i] = items[i];
            }
            for (int i = first; i <= items.length-1; i++) {
                a[i + 1] = items[i];
            }
            first ++;
        }
        if (first == 0 && last == items.length-1) {
            for (int i = 0; i <= last; i++) {
                a[i] = items[i];
            }
        }
    }
    
    
    public void addFirst(Item x) {
        if (size == items.length){
            resize(size + 1);
        }
        items[first] = x;
        if (first != 0) {
            first --;
        }
        else {
            first = items.length-1;
        }
        size ++;
             
    }
    
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size + 1);
        }
        items[last] = x;
        if (last != items.length-1) {
            last ++;
        }
        else {
            last = 0;
        }
        size ++;
    }
    
    public void removeFirst() {
        if (items.length >= 16) {
            Item[] a = (Item[]) new Object[items.length-1];
            for (int i = 0; i < first; i++) {
                a[i] = items[i];
            }
            for (int i = first; i < items.length-1; i++) {
                a[i] = items[i+1];
            }           
        }
        else {
            Item[] a = (Item[]) new Object[items.length];
            for (int i = 0; i < first; i++) {
                a[i] = items[i];
            }
            for (int i = first+1; i < items.length; i++) {
                a[i] = items[i];
            }
            first ++;        
        }
                     
    }
    
    public void removeLast() {
        if (items.length >= 16) {
            Item[] a = (Item[]) new Object[items.length-1];
            for (int i = 0; i < last; i++) {
                a[i] = items[i];
            }
            for (int i = last; i < items.length-1; i++) {
                a[i] = items[i+1];
            }           
        }
        else {
            Item[] a = (Item[]) new Object[items.length];
            for (int i = 0; i < last; i++) {
                a[i] = items[i];
            }
            for (int i = last+1; i < items.length; i++) {
                a[i] = items[i];
            }
            last --;        
        }
                     
    }
    
    public Item getFirst() {
        return items[first];
    }
    
    public Item getLast() {
        return items[last];
    }
    
    public Item get(int i) {
        return items[i];
    }
    
    public int size() {
        return size;
    }
    

}
