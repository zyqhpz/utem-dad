package week7.numberApp;

import java.util.Random;

/**
 * This class represent a task to generate a random number.
 * 
 * @author emalianakasmuri
 *
 */
public class RandomNumberTask implements Runnable {

	private Random random;
	private int min;
	private int max;

	public RandomNumberTask(int min, int max) {

		random = new Random();

		this.min = min;
		this.max = max;
	}

	/**
	 * This method gets a random number between min and max values
	 * 
	 * @return a random number
	 */
	public int getRandomNumber() {

		int number = random.nextInt(max - min) + min;

		return number;
	}

	@Override
	public void run() {

		Thread currentThread = Thread.currentThread();

		System.out.println("Thread " + currentThread.getName() + " starts");

		// print 10 random numbers
		for (int i = 0; i < 10; i++) {
			System.out.println(currentThread.getName() + "-> " + i + ". - " + getRandomNumber());
		}

		System.out.println("Thread " + currentThread.getName() + " ends");
	}

}
