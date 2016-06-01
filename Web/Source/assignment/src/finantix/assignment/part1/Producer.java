package finantix.assignment.part1;

import java.util.Calendar;

public class Producer extends Thread {

	private Inventory inventory;
	/**
	 * the length of time to sleep in milliseconds
	 */
	private long delay;

	public Producer(Inventory inventory, long delay) {
		this.inventory = inventory;
		this.delay = delay;
	}

	@Override
	public void run() {
		System.out.println("Producer is starting...");
		while (true) {
			try {
				inventory.addProduct("Product" + Calendar.getInstance().get(Calendar.SECOND));
				Thread.sleep(delay);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
