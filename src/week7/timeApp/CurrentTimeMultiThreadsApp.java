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

		// // Create thread objects
		// Thread thread1 = new CurrentTimeTask();
		// Thread thread2 = new CurrentTimeTask();

		// // Execute threads
		// thread1.start();
		// thread2.start();

		Runnable currentTime1 = new CurrentTimeTask();
		Runnable currentTime2 = new CurrentTimeTask();

		Thread printerThread1 = new Thread(currentTime1, "printerThread1");

		Thread printerThread2 = new Thread(currentTime2);
		printerThread2.setName("printerThread2");

		// Start threads
		printerThread1.start();
		printerThread2.start();

		System.out.println("Program ends");

	}

}
