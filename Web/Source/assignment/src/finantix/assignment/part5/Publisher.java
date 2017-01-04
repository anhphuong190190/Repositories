package finantix.assignment.part5;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
	private String title;
	private String state;
	private List<Observer> observers;

	public Publisher(String title) {
		this.observers = new ArrayList<Observer>();
		this.title = title;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		notifyToObservers();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void notifyToObservers() {
		for (Observer observer : observers) {
			observer.updateState();
		}
	}
}
