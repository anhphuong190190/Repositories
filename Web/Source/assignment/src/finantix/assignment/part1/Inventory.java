package finantix.assignment.part1;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<String> products = new ArrayList<String>();

	public List<String> getProducts() {
		return products;
	}

	public void addProduct(String product) {
		synchronized (product) {
			products.add(product);
			product.notifyAll();
		}
	}

	public int getSize() {
		return products.size();
	}
}
