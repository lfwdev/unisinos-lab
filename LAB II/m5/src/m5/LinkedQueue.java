package m5;
// A partir da classe Node e da interface Queue, crie uma classe chamada LinkedQueue, que implementa Queue, ou seja, é uma fila, porém, encadeada. 
public class LinkedQueue<E> implements Queue<E> {
	
	Node<E> front;
	Node<E> back;
	private static int numElements = 0;

	public static void main(String[] args) {
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
        numberQueue.front.setElement(666);
        System.out.println("Queue Front after changing node element: " + numberQueue.front());
        
        System.out.println("Queue Size : " + numberQueue.numElements());
	}

	public boolean isEmpty() {
		
        if (this.back == null) {
            return true;
        }
		
		return false;
	}

	public boolean isFull() {
		return false;
	}

	public int numElements() {
		return numElements;
	}

	public void enqueue(E element) throws UnderflowException {
        // Create a new LinkedQueue node
        Node<E> tempNode = new Node<E>(element);

        
        // If queue is empty, then new node is front and back
        if (isEmpty()) {
            this.front = this.back = (Node<E>) tempNode;
            numElements++;
            return;
        }
 
        // Add the new node at the end of queue and change back
        //this.tail.next = (Node<E>) tempNode;
        this.back.setNext(tempNode);
        this.back = (Node<E>) tempNode;
        
        numElements++;
	}

	public E dequeue() throws UnderflowException {
		// If queue is empty, return NULL.
        if (this.front == null)
        	//System.out.println("Queue Front : " + q.front.key);
            return null;
 
        // Store previous front and move front one node ahead
        Node<E> tempNode = this.front;
        this.front = this.front.next;
 
        // If front becomes NULL, then change rear also as NULL
        if (this.front == null)
            this.back = null;
        
        numElements--;
        
		return null;
	}

	public E front() throws UnderflowException {
		return front.getElement();
	}

	public E back() throws UnderflowException {
		return back.getElement();
	}

}
