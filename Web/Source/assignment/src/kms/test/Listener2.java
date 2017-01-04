package kms.test;

public class Listener2 extends Observer {
	public Listener2(WeatherStatus weatherStatus) {
		this.weatherStatus = weatherStatus;
		this.attach();
	}

	@Override
	public void updateWeatherStatus() {
		System.out.println("Listener2: WeatherStatus change : " + weatherStatus.getStatus());
	}
}
