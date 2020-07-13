
public class LinkedListDeque<T>
{
    private IntNode header;
    private IntNode trailer;
    private int size;
    private IntNode current;
    
    private class IntNode{
        private IntNode prev;
        private T item;
        private IntNode next;
        
        private IntNode(T i, IntNode m, IntNode n) {
            item = i;
            prev = m;
            next = n;
        }
        
    }
    
    public LinkedListDeque() {
        size = 0;
        header = new IntNode(null,null,null);
        trailer = new IntNode(null,header,null);
        header.next = trailer;
        current = header;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void addFirst(T item) {
        IntNode newNode = new IntNode(item, header, header.next);
        header.next.prev = newNode;
        header.next = newNode;
        size += 1;
    }
    
    public void addLast(T item) {
        IntNode newNode = new IntNode(item, trailer.prev, trailer);
        trailer.prev.next = newNode;
        trailer.prev = newNode;
        size += 1;
    }
    
    public T removeFirst() {
        T toRemove = header.next.item;
        header.next.next.prev = header;
        header.next = header.next.next;
        if (!isEmpty()){
            size -= 1;
        }
        return toRemove;       
    }
    
    public T removeLast() {
        T toRemove = trailer.prev.item;
        trailer.prev.prev.next = trailer;
        trailer.prev = trailer.prev.prev;
        if (!isEmpty()){
            size -= 1;
        }
        return toRemove;

    }
    
    public T get(int index) {
        IntNode toGet = header.next;
        for (int i=0; i< index; i++){
            toGet = toGet.next;
        }
        return toGet.item;
    }
    
    
    private T getRecursive(int index, IntNode curr) {

        if (index == 0) {
            return curr.item;
        }
        return getRecursive(index - 1, curr.next);
    }

    public T getRecursive(int index) {
        return getRecursive(index, header.next);
    }

    public void printDeque(){
        IntNode toPrint = header.next;
        for (int i = 0; i < size; i++){
            System.out.print(toPrint.item + " ");
            toPrint = toPrint.next;
        }
    }

}
