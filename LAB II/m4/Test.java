import java.util.List;
import StaticList;

public class Test {

    public static void main(String[] args) {
        StaticList list = new StaticList<Integer>(11);
        for(int i = 0; i<10;i++) {
            list.insert((i + 1 * 100),i);
        }

		System.out.println(list.contaElementos(list));
	}
}
