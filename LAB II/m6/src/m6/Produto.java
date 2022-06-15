package m6;

import java.text.NumberFormat;

public class Produto {
	
	private String name;
	private double value;
	
	public Produto(String name, double value) {
		setName(name);
		setValue(value);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String toString() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String moneyString = formatter.format(value);
		return String.format("%s: %s", name, moneyString);
	}
}
