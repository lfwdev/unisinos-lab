import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rules {
	public ArrayList<List> winningCombinations = new ArrayList<List>();
	
	public Rules() {
		List<Integer> c1 = Arrays.asList(1,2,3);
		List<Integer> c2 = Arrays.asList(4,5,6);
		List<Integer> c3 = Arrays.asList(7,8,9);
		List<Integer> c4 = Arrays.asList(1,4,7);
		List<Integer> c5 = Arrays.asList(1,5,9);
		List<Integer> c6 = Arrays.asList(2,5,8);
		List<Integer> c7 = Arrays.asList(3,6,9);
		List<Integer> c8 = Arrays.asList(3,5,7);

		this.winningCombinations.add(c1);
		this.winningCombinations.add(c2);
		this.winningCombinations.add(c3);
		this.winningCombinations.add(c4);
		this.winningCombinations.add(c5);
		this.winningCombinations.add(c6);
		this.winningCombinations.add(c7);
		this.winningCombinations.add(c8);
	}
}
