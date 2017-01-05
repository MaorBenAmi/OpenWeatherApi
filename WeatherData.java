package project.java.weather;

public class WeatherData {
	private String description;
	private int currentTemp;
	private int minTemp;
	private int maxTemp;
	private int windSpeed;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCurrentTemp() {
		return currentTemp;
	}

	public void setCurrentTemp(int currentTemp) {
		this.currentTemp = currentTemp;
	}

	public double getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(int minTemp) {
		this.minTemp = minTemp;
	}

	public double getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(int maxTemp) {
		this.maxTemp = maxTemp;
	}

	public int getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(int windSpeed) {
		this.windSpeed = windSpeed;
	}

	@Override
	public String toString() {
		return "Weather condition: " + description+ System.lineSeparator() + "Temperature: " + currentTemp + System.lineSeparator() + "Minimum Temperature: " + minTemp + System.lineSeparator()
				+ "Maximum Temperature: " + maxTemp + System.lineSeparator() + "Wind Speed=" + windSpeed;
	}

}
