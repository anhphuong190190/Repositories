package finantix.assignment.part1;

public class main {
	public static void main(String[] args) {
		Inventory inventory = new Inventory();

		Thread producer = new Producer(1, inventory, 2000);
		producer.start();
		Thread producer2 = new Producer(2, inventory, 4000);
		producer2.start();

		Thread consumer = new Consumer(1, inventory, 4000);
		consumer.start();
		Thread consumer2 = new Consumer(2, inventory, 5000);
		consumer2.start();

	}
}
