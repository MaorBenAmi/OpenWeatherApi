package project.java.weather;

public class WeatherDataServiceException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public WeatherDataServiceException() {
		super();
	}

	public WeatherDataServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public WeatherDataServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public WeatherDataServiceException(String message) {
		super(message);
	}

	public WeatherDataServiceException(Throwable cause) {
		super(cause);
	}

}
