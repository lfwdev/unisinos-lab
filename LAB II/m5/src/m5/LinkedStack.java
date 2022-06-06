package m5;
// A partir da classe Node e da interface Stack, crie uma classe chamada LinkedStack, que implementa Stack, ou seja, é uma pilha, porém, encadeada. 
public class LinkedStack<E> implements Stack<E> {

	Node<E> top;
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
	public void push(Object element) throws UnderflowException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E pop() throws UnderflowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E top() throws UnderflowException {
		// TODO Auto-generated method stub
		return null;
	}

}
