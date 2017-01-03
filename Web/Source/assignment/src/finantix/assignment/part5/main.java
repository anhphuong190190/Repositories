package finantix.assignment.part5;

public class main {
	public static void main(String[] args) {
		Subject subject = new Subject();
		Observer topic1 = new Subscribe("Topic 1", subject);
		Observer topic2 = new Subscribe("Topic 2", subject);

		System.out.println("First state change: START");
		subject.setState("START");
		System.out.println("Second state change: RUNNING");
		subject.setState("RUNNING");
		System.out.println("Last state change: STOP");
		subject.setState("STOP");
	}
}
