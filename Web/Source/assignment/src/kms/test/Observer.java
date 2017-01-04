package kms.test;

public abstract class Observer {
	protected WeatherStatus weatherStatus;

	public abstract void updateWeatherStatus();

	public void attach() {
		weatherStatus.attach(this);
	}

	public void detach() {
		weatherStatus.detach(this);
	}
}
