package project.java.weather;

public class Location {
private String Country;
private String City;

public Location(String country, String city) {
		this.setCountry(country);
		this.setCity(city);
	}

public String getCountry() {
	return Country;
}
public void setCountry(String country) {
	Country = country;
}
public String getCity() {
	return City;
}
public void setCity(String city) {
	City = city;
}

}
