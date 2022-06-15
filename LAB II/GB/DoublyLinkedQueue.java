public class DoublyLinkedQueue <E> extends DoublyLinkedList<E> implements Queue<E>{
    
    public DoublyLinkedQueue() {
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


    public void enqueue(E element) throws OverflowException{
        super.insertFirst(element);
    } 

    public E dequeue() throws UnderflowException{
       return super.removeLast();
    }
   
   public void imprimirFila() {
      System.out.println(super.toString());
      
   }

   @Override
   public E front() throws UnderflowException {
       // TODO Auto-generated method stub
       return null;
   }

   @Override
   public E back() throws UnderflowException {
       // TODO Auto-generated method stub
       return null;
   }

}
