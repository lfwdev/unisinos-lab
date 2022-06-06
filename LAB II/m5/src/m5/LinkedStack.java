package m5;
// A partir da classe Node e da interface Stack, crie uma classe chamada LinkedStack, que implementa Stack, ou seja, é uma pilha, porém, encadeada. 
public class LinkedStack<E> implements Stack<E> {

	Node<E> head;
	Node<E> tail;
	private static int numElements;
	private static int maxNumElements = 5;
	
	public static void main(String[] args) {
		numElements = 0;
		
		LinkedStack<Integer> numberStack = new LinkedStack<Integer>();

		numberStack.push(5);
		numberStack.push(4);
		numberStack.push(3);
		numberStack.push(2);
		numberStack.push(1);
		
		
        System.out.println("Stack Top : " + numberStack.top());
		numberStack.pop();
		numberStack.pop();
        System.out.println("Stack Top : " +  numberStack.top());
	}

	@Override
	public boolean isEmpty() {
		return numElements == 0;
	}

	@Override
	public boolean isFull() {
		return numElements >= maxNumElements;
	}

	@Override
	public int numElements() {
		return numElements;
	}

	@Override
	public void push(E element) throws UnderflowException {
		Node<E> oldHead = head;
		head = (Node<E>) new Node<E>(element);
		head.setNext(oldHead);	

	    numElements++;
	    return;
		
	}

	@Override
	public E pop() throws UnderflowException {
	    if (top() == null) { return null; }
	    E item = top();
	    head = head.getNext();
	    numElements--;
	    return item;
	}

	@Override
	public E top() throws UnderflowException {
		// TODO Auto-generated method stub
		return head.getElement();
	}

}
