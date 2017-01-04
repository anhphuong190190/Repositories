package kms.test;

public class Listener1 extends Observer {
	public Listener1(WeatherStatus weatherStatus) {
		this.weatherStatus = weatherStatus;
		this.attach();
	}

	@Override
	public void updateWeatherStatus() {
		System.out.println("Listener1: WeatherStatus change : " + weatherStatus.getStatus());
	}
}
