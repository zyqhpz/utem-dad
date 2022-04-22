package week7.numberApp;

/**
 * This class demonstrate execution of multiple threads object
 * from the same class.
 * 
 * @author emalianakasmuri
 *
 */
public class RandomNumberMultiThreadsApp {

	public static void main(String[] args) {

		// Create Runnable object
		Runnable randomNumberTask1 = new RandomNumberTask(1, 100);
		Runnable randomNumberTask2 = new RandomNumberTask(5, 50);

		// Create thread objects
		Thread thread1 = new Thread(randomNumberTask1);
		Thread thread2 = new Thread(randomNumberTask2);

		// Execute threads
		thread1.start();
		thread2.start();

		System.out.println("Program ends");

	}

}
