package finantix.assignment.part5;

public class main {
	public static void main(String[] args) {
		Publisher publisher = new Publisher("Publisher");
		Observer subcriber1 = new Subscriber("Subcriber 1", publisher);
		Observer subcriber2 = new Subscriber("Subcriber 2", publisher);

		System.out.println("First state change: START");
		publisher.setState("START");
		System.out.println("Second state change: RUNNING");
		publisher.setState("RUNNING");
		System.out.println("Last state change: STOP");
		publisher.setState("STOP");
	}
}
