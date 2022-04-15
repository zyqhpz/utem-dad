package week6.TemperatureRMIApp.ftmk.rmi.sensor.manager;

import java.util.HashMap;
import java.util.Map;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import week6.TemperatureRMIApp.ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class manage the value of temperature from the sensor.
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureSensorManager extends UnicastRemoteObject
		implements TemperatureSensor {

	private HashMap<String, Integer> temperatures;

	public TemperatureSensorManager() throws RemoteException {
		super();
		loadTemperatures();
	}

	@Override
	public int getTemperature() throws RemoteException {
		return 35;
	}

	@Override
	public int getTemperatureByDay(String day) throws RemoteException {
		return temperatures.get(day);
	}

	private void loadTemperatures() throws RemoteException {
		temperatures = new HashMap<String, Integer>();

		temperatures.put("Monday", 32);
		temperatures.put("Tuesday", 31);
		temperatures.put("Wednesday", 33);
		temperatures.put("Thursday", 35);
		temperatures.put("Friday", 36);
		temperatures.put("Saturday", 33);
		temperatures.put("Sunday", 33);
	}

	@Override
	public Map<String, Integer> getTemperatures() throws RemoteException {
		return temperatures;
	}

	public String getDay() throws RemoteException {
		System.out.println("Enter day: ");

		return "Monday";
	}

	public double getAverageTemperature() throws RemoteException {
		int total = 0;

		for (Map.Entry<String, Integer> temp : temperatures.entrySet()) {
			total += temp.getValue();
		}

		double average = total / temperatures.size();

		return average;
	}

}
