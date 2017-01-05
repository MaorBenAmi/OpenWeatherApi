package project.java.weather;

import javax.swing.*;

import project.java.weather.WeatherDataServiceFactory.service;

import java.awt.*;
import java.awt.event.*;

public class GUIWeather {

	JFrame frame;
	JButton btSearch;
	JTextField tfCity, tfCountry, tfSearchResult;
	JPanel panelTextFields, panelButtons;
	ActionListener listener;
	Location location = null;
	IWeatherDataService dataService = null;
	WeatherData data = null;
	JTextArea textArea;

	public GUIWeather() {
		panelButtons = new JPanel();
		panelTextFields = new JPanel();
		frame = new JFrame("Weather Data Service");
		btSearch = new JButton("Search");
		tfCity = new JTextField(10);
		tfCountry = new JTextField(10);
		textArea = new JTextArea();
		;
		listener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String city = tfCity.getText().trim();
				String country = tfCountry.getText().trim();
				Object source = e.getSource();
				if (btSearch == source) {
					location = new Location(country, city);
					dataService = WeatherDataServiceFactory.getWeatherDataService(service.OPEN_WEATHER_MAP);
					try {
						data = dataService.getWeatherData(location);
						textArea.setText(data.toString());
					} catch (WeatherDataServiceException ex) {
						ex.printStackTrace();
					}
				}

			}

		};
	}

	public void start() {

		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
			}

		});

		btSearch.addActionListener(listener);
		frame.setLayout(new BorderLayout());
		// frame.add(tf1,BorderLayout.EAST);
		// frame.add(tf2,BorderLayout.WEST);
		panelTextFields.add(tfCity);
		panelTextFields.add(tfCountry);
		panelTextFields.add(textArea);
		panelTextFields.setBackground(Color.GREEN);
		frame.add(panelTextFields, BorderLayout.NORTH);
		frame.add(btSearch);
		panelButtons.add(btSearch);
		panelButtons.setBackground(Color.MAGENTA);
		frame.add(panelButtons, BorderLayout.SOUTH);
		frame.add(textArea);
		frame.setSize(400, 300);
		frame.setVisible(true);
	}

}
