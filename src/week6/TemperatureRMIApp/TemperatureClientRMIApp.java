package week6.TemperatureRMIApp;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import week6.TemperatureRMIApp.ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class represent the client-side of RMI application
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureClientRMIApp {

	public static void main(String[] args) {

		try {

			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();

			// Look-up for the remote object
			TemperatureSensor remoteSensorAyerKeroh = (TemperatureSensor) rmiRegistry.lookup("SensorAyerKeroh");

			// Invoke method from the remote object
			System.out.println(
					"Current temperature in Jasin is " + remoteSensorAyerKeroh.getTemperature() + " Celcius\n");

			Scanner sc = new Scanner(System.in);
			System.out.print("Enter day to get temperature by day: ");
			String day = sc.nextLine();

			// Invoke method from the remote object
			int currentTemperature = remoteSensorAyerKeroh.getTemperatureByDay(day);

			System.out.println("Current temperature on " + day + " in Ayer Keroh is "
					+ currentTemperature + " Celcius\n\n");

			// Invoke method from the remote object
			Map<String, Integer> temperatures = remoteSensorAyerKeroh.getTemperatures();
			displayTemperatureList(temperatures);

			// get average temperature
			double averageTemperature = remoteSensorAyerKeroh.getAverageTemperature();

			System.out.println("\n\nAverage temperature in Ayer Keroh is " + averageTemperature + " Celcius\n\n");

		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void displayTemperatureList(Map<String, Integer> temperatures) {
		for (Map.Entry<String, Integer> set : temperatures.entrySet()) {
			System.out.println(set.getKey() + " => " + set.getValue());
		}
	}

}
