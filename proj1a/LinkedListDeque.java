
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
    
    public void addFirst(Thing item) {
        IntNode newNode = new IntNode(item, header, header.next);
        header.next.prev = newNode;
        header.next = newNode;
        size += 1;
    }
    
    public void addLast(Thing item) {
        IntNode newNode = new IntNode(item, trailer.prev, trailer);
        trailer.prev.next = newNode;
        trailer.prev = newNode;
        size += 1;
    }
    
    public Thing removeFirst() {
        Thing toRemove = header.next.item;
        header.next.next.prev = header;
        header.next = header.next.next;
        if (!isEmpty()){
            size -= 1;
        }
        return toRemove;       
    }
    
    public Thing removeLast() {
        Thing toRemove = trailer.prev.item;
        trailer.prev.prev.next = trailer;
        trailer.prev = trailer.prev.prev;
        if (!isEmpty()){
            size -= 1;
        }
        return toRemove;

    }
    
    public Thing get(int index) {
        IntNode toGet = header.next;
        for (int i=0; i< index; i++){
            toGet = toGet.next;
        }
        return toGet.item;
    }
    
    
    private Thing getRecursive(int index, IntNode curr) {

        if (index == 0) {
            return curr.item;
        }
        return getRecursive(index - 1, curr.next);
    }

    public Thing getRecursive(int index) {
        return getRecursive(index, sentinel.next);
    }

}
