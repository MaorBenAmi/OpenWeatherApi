package project.java.weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class OpenWeatherMap implements IWeatherDataService {

	private static OpenWeatherMap instance = null;
	private static Object lockObj = new Object();
	private WeatherData weatherData = new WeatherData();
	private InputStream in = null;
	private URL url = null;

	public static OpenWeatherMap getInstance() {

		if (instance == null) {
			synchronized (lockObj) {
				if (instance == null) {
					instance = new OpenWeatherMap();
				}
			}
		}

		return instance;
	}

	private OpenWeatherMap() {
	}

	public WeatherData getWeatherData(Location location) throws WeatherDataServiceException {

		try {
			url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + location.getCity() + ","
					+ location.getCountry() + "&appid=a7c3e69ea45b30e242d81cf36da2df48&units=metric");
			in = url.openStream();
			JsonReader rdr = Json.createReader(in);
			JsonObject currentJson;
			int temp;
			JsonObject bigJsonObject = rdr.readObject();
			JsonArray weather = bigJsonObject.getJsonArray("weather");
			currentJson = weather.getJsonObject(0);
			weatherData.setDescription(currentJson.getString("description"));
			currentJson = bigJsonObject.getJsonObject("main");
			temp = currentJson.getInt("temp");
			weatherData.setCurrentTemp(temp);
			temp = currentJson.getInt("temp_min");
			weatherData.setMinTemp(temp);
			temp = currentJson.getInt("temp_max");
			weatherData.setMaxTemp(temp);
			currentJson = bigJsonObject.getJsonObject("wind");
			weatherData.setWindSpeed(currentJson.getInt("speed"));
			return weatherData;
		}

		catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}

		return null;
	}

}
