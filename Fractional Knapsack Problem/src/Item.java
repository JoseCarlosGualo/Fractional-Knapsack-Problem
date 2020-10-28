
public class Item {
	private double weight, benefit, ratio;
	private char letra;

	public Item(double weight, double benefit, char letra) {
		this.weight = weight;
		this.benefit = benefit;
		this.letra = letra;
		this.ratio = benefit / weight;
	}

	public double getRatio() {
		return ratio;
	}

	public double getWeight() {
		return weight;
	}

	public double getBenefit() {
		return benefit;
	}

	public String toString() {
		String string = "Element: " + letra + " weight: " + weight + " benefit: " + benefit;
		return string;
	}

}