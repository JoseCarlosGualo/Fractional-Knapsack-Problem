import java.util.*;

public class Fractional_Knapsack_Problem_GualoCejudo_JoseCarlos {

	public static void main(String[] args) {
		int[] wt = { 3, 1, 6, 4, 2, 4, 8, 9 };
		int[] val = { 14, 5, 10, 12, 8, 10, 16, 9 };
		char[] letras = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
		Item[] items = new Item[wt.length];
		double[] sol;
		double resultado = 0;
		int capacity = 15;
		initialize(val, wt, items, letras);
		sort_by_ratio(items);
		sol = fractional_knapsack(items, capacity);
		resultado = calculate_result(sol, items);
		for (int i = 0; i < sol.length; i++) {
			if (sol[i] != 0) {
				System.out.println(sol[i] + " portion of " +items[i].toString());
			}
		}
		System.out.println("Final benefit: "+resultado+"\nTotal capactity: "+ capacity);
	}

	// This method is used to initialize the array of objects of type Item
	public static void initialize(int[] val, int[] wt, Item items[], char[] letras) {
		for (int i = 0; i < items.length; i++) {
			items[i] = new Item(wt[i], val[i], letras[i]);
		}
	}

	// This is a sorting method using bubble method, but could have been done using
	// other sorting algorithm
	public static void sort_by_ratio(Item[] items) {
		Item aux;
		for (int i = 0; i < items.length - 1; i++) {
			for (int j = 0; j < items.length - i - 1; j++) {
				if (items[j + 1].getRatio() > items[j].getRatio()) {
					aux = items[j + 1];
					items[j + 1] = items[j];
					items[j] = aux;
				}
			}
		}
	}

	public static double[] fractional_knapsack(Item[] items, int capacity) {
		double[] solution = new double[items.length];
		int n = 0;
		for (int j = 0; j < solution.length; j++) {
			solution[j] = 0;
		}
		while ((n < items.length) && (items[n].getWeight() <= capacity)) {
			solution[n] = 1;
			capacity = (int) (capacity - items[n].getWeight());
			n++;
		}

		if (n < items.length) {
			solution[n] = capacity / items[n].getWeight();
		}
		return solution;

	}

	public static double calculate_result(double[] fracciones, Item[] items) {
		double result = 0;
		for (int i = 0; i < items.length; i++) {
			result += (items[i].getBenefit() * fracciones[i]);
		}
		return result;
	}
}
