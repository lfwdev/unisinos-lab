
public class DesafioModulo3 {

	public static void main(String[] args) {
		
		int[] array1 = {1, -2, 8, 4, 9, 5};
		
		int[] array2 = {1, -2, 8, 5, 4, 9};
		
		
		int valor = pesquisaSequencial(array1,5);
		
		System.out.println("Pesquisa Sequencial");
		if (valor != -1)
			System.out.println("Encontrou elemento no índice: " +valor);
		else
			System.out.println("Não encontrou o valor.");
		
		
		selectionSort(array2);
		System.out.println("Ordenação por Selection Sort:");
		System.out.println("Imprimindo o array: ");
		for(int i=0; i < array2.length; i++) {
			System.out.print(array2[i] + " | ");
		}
		System.out.println();
		
		valor = pesquisaSequencialOrdenada(array2,3);
		System.out.println("Pesquisa Sequencial Ordenada");
		if (valor != -1)
			System.out.println("Encontrou elemento no índice: " +valor);
		else
			System.out.println("Não encontrou o valor.");
		

	}
	
	public static int pesquisaSequencial(int[] array, int valor) {
		for(int i=0; i < array.length; i++) {
			if(array[i] == valor){
				return i;
			}
		}
		return -1;
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

}