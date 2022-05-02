public class DesafioModulo3 {

	public static void main(String[] args) {
		
		int valor = 0;
		int[] ordered = {1, 2, 3, 5, 6, 7};
		int[] unOrdered = {1, -2, 8, 5, 4, 9};

		// valor = pesquisaBinaria(ordered, 4,0,0);
		// outputResult(valor,"pesquisaBinaria para 4");
		// valor = pesquisaBinaria(ordered, 7,0,0);
		// outputResult(valor,"pesquisaBinaria para 7");

		// valor = pesquisaSequencial(unOrdered, 4,0);
		// outputResult(valor,"pesquisaSequencial para 4");
		// valor = pesquisaSequencial(unOrdered, 8,0);
		// outputResult(valor,"pesquisaSequencial para 8");

		// valor = pesquisaSequencialOrdenada(ordered, 4,0);
		// outputResult(valor,"pesquisaSequencial para 4");
		// valor = pesquisaSequencialOrdenada(ordered, 5,0);
		// outputResult(valor,"pesquisaSequencial para 5");


		// insertionSort(unOrdered, 0,0,0,true);
	}

	public static void outputResult(int valor,String label) {
		System.out.println(label);
		if (valor != -1)
			System.out.printf("Encontrou elemento no índice: %s \n", valor);
		else
			System.out.print("Não encontrou o valor. \n");
	}

	public static int pesquisaBinaria(int[] array, int valor,int inf,int sup) {
		if(sup == 0)	
			sup = array.length - 1;
		
		if(inf <= sup) {
			int med = (inf + sup) / 2;
			if (valor == array[med])
				return med;
			else if (valor < array[med])
				sup = med - 1; //irá procurar na primeira metade
			else
				inf = med + 1; //irá procurar na segunda metade
			return pesquisaBinaria(array,valor,inf,sup);
		}
		return -1;
		
	}
	
	public static int pesquisaSequencial(int[] array, int valor, int i) {
		if(i < array.length) {
			if(array[i] == valor){
				return i;
			}
			return pesquisaSequencial(array, valor, i + 1);
		}
		return -1;
	}
	
	public static int pesquisaSequencialOrdenada(int[] array, int valor, int i) {
		if((i < array.length) && (array[i] <= valor)) {
			if(array[i] == valor){
				return i;
			}
			return pesquisaSequencialOrdenada(array, valor, i + 1);
		}
		return -1;
	}
	
	public static void selectionSort(int [] a, int i, int j) {
		if(i < a.length-1) {
			int min = i;
			if(j == 0)
				j = i + 1;
			if(j < a.length) {
			    if(a[j] < a[min])
			    	min = j;
				j++;
				selectionSort(a, i + 1, j);
			}
			int aux = a[i];
			a[i] = a[min];
			a[min] = aux;
			selectionSort(a, i + 1, j);
		} 
	}

	public static void insertionSort(int[] a,int i,int j,int b, boolean p) {
		if(i == 0) i = 1;
		if(i < a.length) {
			if(p) { 
				j = i;
			 	b = a[i]; 
			}
			if((j>0 && (a[j-1] > b))) {
				p = false;
				a[j] = a[j-1];
				j--;
			} else {
				p = true;
				a[j] = b; 
				i++;
			}
			insertionSort(a,i,j,b,p);
		}
	}

	public static void bubbleSort(int[] a,int i,int l,int j) {
		if (i > 0) {
			if (j < i) {
				if (a[j] > a[j+1]) {
					int aux = a[j];
					a[j] = a[j+1];
					a[j+1] = aux;
					l = j;
				}
				bubbleSort(a,i,l,j+1);
			}
			i = l;
			bubbleSort(a, i,0,0);
		}
	}

}