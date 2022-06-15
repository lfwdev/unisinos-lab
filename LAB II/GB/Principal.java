/*
Classe para testar as estruturas de dados apresentadas
*/

public class Principal {
	public static void main(String[] args) {
		int index =0 ;
		System.out.println(" ESTRUTURAS ESTATICAS ");
		StaticList<Integer> lista = new StaticList<Integer>(10);
		
		while (!lista.isFull()){
			lista.insert(index, index);
			index++;
		}

		//Remove os elementos da lista
		if(lista.isFull()) {System.out.println("A lista está cheia");}
        while (!lista.isEmpty()){
			lista.remove(0);
		}
        if(lista.isEmpty()) {System.out.println("A lista está vazia");}

		index = 0;
		StaticStack<Integer> stack_ = new StaticStack<Integer>(10);
		while(!stack_.isFull()){
			stack_.push(index++);
		}
		if(stack_.isFull()) {System.out.println("A pilha está cheia");}

		while(!stack_.isEmpty()){
			stack_.pop();
		}
		if(stack_.isEmpty()) {System.out.println("A pilha está vazia");}


		index = 0;
		StaticQueue<Integer> queue_ = new StaticQueue<Integer>(10);
		while(!queue_.isFull()){
			queue_.enqueue(index++);
		}
		if(queue_.isFull()) {System.out.println("A FILA está cheia");}

		
		while(!queue_.isEmpty()){
			queue_.dequeue();
		}
		if(queue_.isEmpty()) {System.out.println("A FILA está vazia");}







		

/*
		DoublyLinkedQueue<String> fila = new DoublyLinkedQueue<String>();
		fila.enqueue("Primeiro da FILA");
		fila.enqueue("Segundo da FILA");
		fila.enqueue("Terceiro da FILA");
		fila.enqueue("Quarto da FILA");
		fila.enqueue("Quinto da FILA");
		fila.enqueue("Sexto da FILA");
		fila.enqueue("Setimo da FILA");
		fila.enqueue("Oitavo da FILA");

	
		fila.dequeue();// remove 1º
		fila.dequeue();// remove 2º
		System.out.println("Resultado: ");
		fila.imprimirFila();


		DoublyLinkedStack<String> stack = new DoublyLinkedStack<String>();
		stack.push("Primeiro da PILHA");
		stack.push("Segundo da PILHA");
		stack.push("Terceiro da PILHA");
		stack.push("Quarto da PILHA");
		stack.push("Quinto da PILHA");
		System.out.println("Removido : " + stack.pop());
		System.out.println("O primeiro : " + stack.get(0));

		System.out.println("Removido : " + stack.pop());
		System.out.println("Removido : " + stack.get(0));

        DoublyLinkedList<Integer> list = new DoublyLinkedQueue<Integer>();

		list.insertFirst(0);
		list.insertFirst(9);
		list.insertFirst(1);
		list.insertFirst(3);
		list.insertFirst(2);
        list.removeMenorChave();

		System.out.println("value :>>" + list.numElements());


*/

	}
}
