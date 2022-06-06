package m5;
// A partir da classe Node e da interface Queue, crie uma classe chamada LinkedQueue, que implementa Queue, ou seja, é uma fila, porém, encadeada. 
public class LinkedQueue<E> implements Queue<E> {
	
	Node<E> head;
	Node<E> tail;
	private static int numElements;
	private static int maxNumElements = 5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numElements = 0;
		
		LinkedQueue<Integer> numberQueue = new LinkedQueue<Integer>();
        numberQueue.enqueue(1);
        numberQueue.enqueue(89);       
        numberQueue.enqueue(13);
        numberQueue.enqueue(120);
        
        numberQueue.dequeue();
        numberQueue.enqueue(34);
        numberQueue.enqueue(344);
        numberQueue.enqueue(234);
        numberQueue.dequeue();
        
 
        
        System.out.println("Queue Front : " + numberQueue.front());
        System.out.println("Queue Back : " + numberQueue.back());
        
        //Change Node Element Value
        numberQueue.head.setElement(666);
        System.out.println("Queue Front after changing node element: " + numberQueue.front());
        
        System.out.println("Queue Size : " + numberQueue.numElements());
	}

	@Override
	public boolean isEmpty() {
		
        if (this.tail == null) {
            return true;
        }
		
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return numElements >= maxNumElements;
	}

	@Override
	public int numElements() {
		return numElements;
	}


	@Override
	public void enqueue(E element) throws UnderflowException {
        // Create a new LinkedQueue node
        Node<E> tempNode = new Node<E>(element);

        
        // If queue is empty, then new node is front and back
        if (isEmpty()) {
            this.head = this.tail = (Node<E>) tempNode;
            numElements++;
            return;
        }
 
        // Add the new node at the end of queue and change back
        //this.tail.next = (Node<E>) tempNode;
        this.tail.setNext(tempNode);
        this.tail = (Node<E>) tempNode;
        
        numElements++;
	}

	@Override
	public E dequeue() throws UnderflowException {
		// If queue is empty, return NULL.
        if (this.head == null)
        	//System.out.println("Queue Front : " + q.front.key);
            return null;
 
        // Store previous front and move front one node ahead
        Node<E> tempNode = this.head;
        this.head = this.head.next;
 
        // If front becomes NULL, then change rear also as NULL
        if (this.head == null)
            this.tail = null;
        
        numElements--;
        
		return null;
	}

	@Override
	public E front() throws UnderflowException {
		// TODO Auto-generated method stub
		return head.getElement();
	}

	@Override
	public E back() throws UnderflowException {
		// TODO Auto-generated method stub
		return tail.getElement();
	}

}
