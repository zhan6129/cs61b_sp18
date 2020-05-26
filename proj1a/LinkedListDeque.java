
public class LinkedListDeque<Thing>
{
    private IntNode header;
    private IntNode trailer;
    private int size;
    private IntNode current;
    
    public class IntNode{
        public IntNode prev;
        public Thing item;
        public IntNode next;
        
        public IntNode(Thing i, IntNode m, IntNode n) {
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
    
    public void addFirst(IntNode x) {
        header.next.prev = x;
        x.next = header.next;
        x.prev = header;
        header.next = x;
    }
    
    public void addLast(IntNode x) {
        trailer.prev.next = x;
        x.prev =trailer.prev;
        x.next = trailer;
        trailer.prev = x;
    }
    
    public void removeFirst() {
        header.next.next.prev = header;
        header.next = header.next.next;       
    }
    
    public void removeLast() {
        trailer.prev.prev.next = trailer;
        trailer.prev = trailer.prev.prev;
    }
    
    public IntNode getFirst() {
        return header.next;
    }
    
    public IntNode getLast() {
        return trailer.prev;
    }
    
    public IntNode getRecursive(int index) {
        IntNode x = getRecursiveHelper(index);
        current = header;
        return x;
    }
    
    public IntNode getRecursiveHelper(int index) {
        if (index == 0) {
            return current.next;
        }
        else if(current != null){
            current = current.next;
            return getRecursive(index - 1);
        }
        else return null;
    }

}
