package m6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class APIsJava {

	public static void main(String[] args) {
		// Listas Dinâmicas, Filas e Pilhas -> inserção, remoção, impressões estrutura
		
		// Queue/LL
		Queue<Produto> produtosLL = new LinkedList<Produto>();
		produtosLL.add(new Produto("ProdutoA",500.8));
		produtosLL.add(new Produto("ProdutoF",926.14));
		System.out.printf("Product Queue: %s \n", produtosLL.toString());
		produtosLL.remove();
		System.out.printf("Product Queue: %s \n", produtosLL.toString());
		
		// S
		Stack<Produto> produtosS = new Stack<Produto>();
		produtosS.push(new Produto("ProdutoB",343.3));
		produtosS.push(new Produto("ProdutoE",127.14));
		System.out.printf("Product stack: %s \n", produtosS.toString());
		produtosS.pop();
		System.out.printf("Product stack: %s \n", produtosS.toString());
		
		// L/AL
		List<Produto> produtosL = new ArrayList<Produto>();
		produtosL.add(new Produto("ProdutoC",725.99));
		produtosL.add(new Produto("ProdutoD",483.72));
		System.out.printf("Product List: %s \n", produtosL.toString());
		produtosL.remove(1);
		System.out.printf("Product List: %s \n", produtosL.toString());
	    
	}

}
