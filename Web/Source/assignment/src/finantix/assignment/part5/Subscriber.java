package finantix.assignment.part5;

public class Subscriber extends Observer {

	public Subscriber(String title, Publisher publisher) {
		this.title = title;
		this.publisher = publisher;
		publisher.attach(this);
	}

	@Override
	public void updateState() {
		System.out.println(title + ": Consuming message from " + publisher.getTitle() + " : " + publisher.getState());
	}

}
