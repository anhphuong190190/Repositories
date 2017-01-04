package kms.test;

import java.util.ArrayList;
import java.util.List;

public class WeatherStatus {
	private List<Observer> observers = new ArrayList<>();
	private String status;

	public WeatherStatus() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		notifyToObservers();
	}

	private void notifyToObservers() {
		for (Observer observer : observers) {
			observer.updateWeatherStatus();
		}
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void detach(Observer observer) {
		observers.add(observer);
	}
}
