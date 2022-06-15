public class DoublyLinkedStack <E> extends DoublyLinkedList<E> implements Stack<E>{
    
    public DoublyLinkedStack() {
       super();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    public boolean isFull() {
        return super.isFull();
    }
    
    public int numElements() {
        return super.numElements();
    }

    @Override
    public void push(E element) throws OverflowException {
        super.insertFirst(element);
        
    }

    @Override
    public E pop() throws UnderflowException {
        return super.removeFirst();
    }

    @Override
    public E top() throws UnderflowException {
        
        return super.get(0);
    }

   

   

}
