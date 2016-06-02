package finantix.assignment.part1;

import java.util.Arrays;

public class Consumer extends Thread {

	private Inventory inventory;
	/**
	 * the length of time to sleep in milliseconds
	 */
	private long delay;
	private int index;

	public Consumer(int index, Inventory inventory, long delay) {
		this.inventory = inventory;
		this.delay = delay;
		this.index = index;
	}

	@Override
	public void run() {
		System.out.println("Consumer " + index + " is starting...");
		while (inventory.getSize() >= 0) {
			try {
				if (inventory.getSize() > 0) {
					System.out.println("Consumer " + index + " " + Arrays.toString(inventory.getProducts().toArray()));
				}
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
