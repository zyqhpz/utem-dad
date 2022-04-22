package week7.timeApp;

/**
 * This class demonstrate the application of multiple threads object in
 * a simple Java multithreaded application
 * 
 * @author emalianakasmuri
 *
 */
public class CurrentTimeMultiThreadsApp {

	public static void main(String[] args) {

		// Create thread objects
		Thread thread1 = new CurrentTimeTask();
		Thread thread2 = new CurrentTimeTask();

		// Execute threads
		thread1.start();
		thread2.start();

		System.out.println("Program ends");

	}

}
