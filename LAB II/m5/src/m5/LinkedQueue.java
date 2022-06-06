package m5;
// A partir da classe Node e da interface Queue, crie uma classe chamada LinkedQueue, que implementa Queue, ou seja, é uma fila, porém, encadeada. 
public class LinkedQueue<E> implements Queue<E> {
	
	Node<E> head;
	Node<E> tail;
	private int numElements;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numElements() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void enqueue(Object element) throws UnderflowException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E dequeue() throws UnderflowException {
		// TODO Auto-generated method stub
		return null;
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
