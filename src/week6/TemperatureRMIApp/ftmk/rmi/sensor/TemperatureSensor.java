package week6.TemperatureRMIApp.ftmk.rmi.sensor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

/**
 * This interface represents temperature sensor
 * 
 * @author emalianakasmuri
 *
 */
public interface TemperatureSensor extends Remote {

	/**
	 * This method gets current temperature
	 * 
	 * @return current temperature
	 * 
	 * @throws RemoteException
	 */
	public int getTemperature() throws RemoteException;

	public int getTemperatureByDay(String day) throws RemoteException;

	public Map<String, Integer> getTemperatures() throws RemoteException;

	public double getAverageTemperature() throws RemoteException;

}
