package finantix.assignment.part1;

import java.util.Calendar;

public class Producer extends Thread {

	private Inventory inventory;
	/**
	 * the length of time to sleep in milliseconds
	 */
	private long delay;
	private int index;

	public Producer(int index, Inventory inventory, long delay) {
		this.inventory = inventory;
		this.delay = delay;
		this.index = index;
	}

	@Override
	public void run() {
		System.out.println("Producer " + index + " is starting...");
		while (true) {
			try {
				synchronized (inventory.getProducts()) {
					System.out.println("------Producer " + index + " is waiting at "
							+ Calendar.getInstance().get(Calendar.SECOND));
					inventory.getProducts().wait(delay);
					inventory.addProduct("Product " + index + "-" + Calendar.getInstance().get(Calendar.SECOND));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
