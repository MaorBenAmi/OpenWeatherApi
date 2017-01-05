package project.java.weather;

import javax.swing.SwingUtilities;

public class Program {

	public static void main(String[] args) {
	 try
	 {
		 SwingUtilities.invokeLater(new Runnable(){

				public void run() {
					GUIWeather demo = new GUIWeather();
					demo.start();
					
				}});
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	

	}

}
