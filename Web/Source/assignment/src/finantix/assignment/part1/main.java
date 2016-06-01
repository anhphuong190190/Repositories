package finantix.assignment.part1;

public class main {
	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		
		Thread producer = new Producer(inventory, 3000);
		producer.start();
		
		Thread consumer = new Consumer(inventory, 5000);
		consumer.start();
		
//		Thread consumer2 = new Consumer(inventory, 6000);
//		consumer2.start();
		
	}
}
