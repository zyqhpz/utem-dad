package week4.lecture.serverdate;

import java.util.Date;

public class DateGenerator {

	// generate current current date
	public String generateCurrentDate() {
		Date currentDate = new Date();
		return currentDate.toString();
	}
}
