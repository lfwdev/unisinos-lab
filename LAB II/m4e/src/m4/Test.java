package m4;

public class Test {

	public static void main(String[] args) {
		StaticList list = new StaticList<Integer>(250);
        for(int i = 0; i<220;i++) {
        	if((i % 2 == 0))
        		list.insert(100,i);
        	else
        		list.insert(i * 2,i);
        }

		System.out.println(list.contaElementos(10));
	}

}
