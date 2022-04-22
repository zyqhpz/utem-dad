package week7.timeApp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This class represent a task to print current time
 * 
 * @author emalianakasmuri
 *
 */
public class CurrentTimeTask extends Thread {

	private DateFormat dateFormat;
	private Calendar calendar;

	public CurrentTimeTask() {

		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.ms");
		calendar = Calendar.getInstance();
	}

	/**
	 * This method gets a current time
	 * 
	 * @return a current time
	 */
	public String getCurrentTime() {

		return dateFormat.format(calendar.getTime());
	}

	@Override
	public void run() {
		// Print current time for 10 times
		for (int i = 0; i < 10; i++) {
			System.out.println(i + ". - " + getCurrentTime());
		}
	}

}
