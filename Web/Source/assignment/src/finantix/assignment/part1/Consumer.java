package finantix.assignment.part1;

import java.util.Arrays;

public class Consumer extends Thread {

	private Inventory inventory;
	/**
	 * the length of time to sleep in milliseconds
	 */
	private long delay;

	public Consumer(Inventory inventory, long delay) {
		this.inventory = inventory;
		this.delay = delay;
	}

	@Override
	public void run() {
		System.out.println("Consumer is starting...");
		while (inventory.getSize() >= 0) {
			try {
				inventory.getProducts().wait();
				System.out.println(Arrays.toString(inventory.getProducts().toArray()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
