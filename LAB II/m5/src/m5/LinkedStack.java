package m5;
// A partir da classe Node e da interface Stack, crie uma classe chamada LinkedStack, que implementa Stack, ou seja, é uma pilha, porém, encadeada. 
public class LinkedStack<E> implements Stack<E> {

	Node<E> top;
	private static int numElements = 0;
	
	public static void main(String[] args) {
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

	public boolean isEmpty() {
		return numElements == 0;
	}

	public boolean isFull() {
		return false;
	}

	public int numElements() {
		return numElements;
	}

	public void push(E element) throws UnderflowException {
		Node<E> oldHead = top;
		top = (Node<E>) new Node<E>(element);
		top.setNext(oldHead);	
	    numElements++;
	}

	public E pop() throws UnderflowException {
	    if (top() == null) { return null; }
	    E item = top();
	    top = top.getNext();
	    numElements--;
	    return item;
	}

	public E top() throws UnderflowException {
		return top.getElement();
	}

}
