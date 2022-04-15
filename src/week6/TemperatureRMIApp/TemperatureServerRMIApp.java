package week6.TemperatureRMIApp;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import week6.TemperatureRMIApp.ftmk.rmi.sensor.TemperatureSensor;
import week6.TemperatureRMIApp.ftmk.rmi.sensor.manager.TemperatureSensorManager;

/**
 * This class represent the server-side application using RMI
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureServerRMIApp {

	public static void main(String[] args) {

		try {

			// Create interface object
			TemperatureSensor sensorJasin = new TemperatureSensorManager();
			TemperatureSensor sensorAyerKeroh = new TemperatureSensorManager();

			// create and get a registry for the remote object
			Registry rmiRegistry = LocateRegistry.createRegistry(1099);

			// Register interface object as remote object
			rmiRegistry.rebind("SensorJasin", sensorJasin);
			rmiRegistry.rebind("SensorAyerKeroh", sensorAyerKeroh);

			System.out.println("SensorJasin is succesfully registered.");
			System.out.println("SensorAyerKeroh is succesfully registered.");

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
