package week6.TemperatureRMIApp;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;

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

			// HashMap<String, Integer> temperatures =
			// remoteSensorAyerKeroh.getTemperatureByDay();

			// Hashtemperatures = remoteSensorAyerKeroh.getTemperatureByDay();

			// Invoke method from the remote object
			// int currentTemperature = remoteSensorJasin.getTemperature();

			int currentTemperature = remoteSensorAyerKeroh.getTemperatureByDay("Tuesday");

			Map<String, Integer> temperatures = remoteSensorAyerKeroh.getTemperatures();

			displayTemperatureList(temperatures);

			System.out.println("Current temperature in Jasin is "
					+ currentTemperature + " Celcius");

			String day = "Tuesday";

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
