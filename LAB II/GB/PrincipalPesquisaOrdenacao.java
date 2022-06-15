public class PrincipalPesquisaOrdenacao {
	public static void main(String[] args) {

		int[] array1 = {8,2,12,6,22,18};
		int[] array2 = new int[6];
		
		int[] array3 = {8,2,12,6,22,18};
		int[] array4 = {8,2,12,6,22,18};
		
		int valor = 6;
		
		//imprimir array 1 não ordenado
		for (int i = 0; i < array1.length; i++) {
			System.out.println("Array não ordenado na posição " + (i+1) + ": " + array1[i]); //imprimindo o array
		}
		
		System.out.println("******");
		
		//imprimir array 2 ordenado
		for (int i = 0; i < array2.length; i++) { 
			array2[i] = i+4;//inserindo valor no array
			System.out.println("Array 2 ordenado na posição " + (i+1) + ": " + array2[i]); //imprimindo o array
		}
		
		System.out.println("******");
		
		//pesquisa sequencial
		if(pesquisaSequencial(array1, valor) == -1) {
			System.out.println("Pesquisa Sequencial não ordenada");
			System.out.println("Procurando no Array 1 o elemento: " + valor);
			System.out.println("Elemento não foi encontrado.");
		}
		else {
			System.out.println("Pesquisa Sequencial não ordenada");
			System.out.println("Procurando no Array 1 o elemento: " + valor);
			System.out.println("O elemento foi encontrado na posição " + (pesquisaSequencial(array1, valor)+1));
		}
		System.out.println("******");
		
		//pesquisa sequencial recursiva
		if(pesquisaSequencial_R(array1, 22, 0) == -1) {
			System.out.println("Pesquisa Sequencial recursiva não ordenada");
			System.out.println("Procurando no Array 1 o elemento: 22");
			System.out.println("Elemento não foi encontrado.");
		}
		else {
			System.out.println("Pesquisa Sequencial não ordenada");
			System.out.println("Procurando no Array 1 o elemento: 22");
			System.out.println("O elemento foi encontrado na posição " + (pesquisaSequencial_R(array1, 22, 0)+1));
		}
		System.out.println("******");
		
		//pesquisa sequencial ordenada
		if(pesquisaSequencialOrdenada(array2, valor) == -1) {
			System.out.println("Pesquisa Sequencial Ordenada");
			System.out.println("Procurando no Array 2 o elemento: " + valor);
			System.out.println("Elemento não foi encontrado.");
		}
		else {
			System.out.println("Pesquisa Sequencial Ordenada");
			System.out.println("Procurando no Array 2 o elemento: " + valor);
			System.out.println("O elemento foi encontrado na posição " + (pesquisaSequencialOrdenada(array2, valor)+1));
		}
		
		System.out.println("******");
		
		//pesquisa binária
		if(pesquisaBinaria(array2, valor) == -1) {
			System.out.println("Pesquisa Binária");
			System.out.println("Procurando no Array 2 o elemento: " + valor);
			System.out.println("Elemento não foi encontrado.");
		}
		else {
			System.out.println("Pesquisa Binária");
			System.out.println("Procurando no Array 2 o elemento: " + valor);
			System.out.println("O elemento foi encontrado na posição " + (pesquisaBinaria(array2, valor)+1));
		}
		
		System.out.println("******");
		
		//inserção direta
		insertionSort(array1);
		
		//imprimir array 1 ordenado
		for (int i = 0; i < array1.length; i++) {
			System.out.println("Array1 ordenado por inserção direta na posição " + (i+1) + ": " + array1[i]); //imprimindo o array
		}
		
		
		System.out.println("******");
		
		//bubble sort
		bubbleSort(array3);
		
		//imprimir array 3 ordenado
		for (int i = 0; i < array3.length; i++) {
			System.out.println("Array3 ordenado por bubble sort na posição " + (i+1) + ": " + array3[i]); //imprimindo o array
		}
		
		System.out.println("******");
		
		//seleção direta
		selectionSort(array4);
		
		//imprimir array 4 ordenado
		for (int i = 0; i < array4.length; i++) {
			System.out.println("Array4 ordenado por seleção na posição " + (i+1) + ": " + array4[i]); //imprimindo o array
		}
		
	}
	
	
	public static int pesquisaSequencial(int[] array, int valor) {
		for(int i=0; i < array.length; i++) {
			if(array[i] == valor){
				return i;
			}
		}
		return -1;
	}
	
	public static int pesquisaSequencial_R(int[] array, int valor, int i) {
		if (i >=array.length)
			return -1;
		
		if(array[i] == valor){
				return i;
		}
		else
			return pesquisaSequencial_R(array, valor, i+1);
	}
	
	public static int pesquisaSequencialOrdenada(int[] array, int valor) {
		for(int i=0; (i < array.length) && (array[i] <= valor); i++) {
			if(array[i] == valor){
				return i;
			}
		}
		return -1;
	}
	
	public static int pesquisaBinaria(int[] array, int valor) {
		int inf = 0;
		int sup = array.length - 1;
		
		while (inf <= sup) {
			int med = (inf +sup) /2;
			if (valor == array[med])
				return med;
			else if (valor < array[med])
				sup = med - 1; //irá procurar na primeira metade
			else
				inf = med + 1; //irá procurar na segunda metade
		}
		return -1;
		
	}
	
	public static void insertionSort (int[] a) {
		for (int i = 1; i < a.length; i++) {
			int j = i;
			int b = a[i];
			while ((j>0 && (a[j-1] > b))) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = b;
		}
	}
	
	public static void bubbleSort(int[] a) {
		int i = a.length - 1;
		while(i > 0) {
			int last = 0;
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j+1]) {
					int aux = a[j];
					a[j] = a[j+1];
					a[j+1] = aux;
					last = j;
				}
			}
			i = last;
		}
	}
	
	public static void selectionSort(int [] a) {
		int min = 0;
		for (int i = 0; i < a.length-1; i++) {
			min = i;
			for(int j=i+1; j < a.length; j++)
			if(a[j] < a[min])
				min = j;
			int aux = a[i];
			a[i] = a[min];
			a[min] = aux;
		}
	}
	
	
	
}
	
