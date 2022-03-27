package demo.lab3;

/**
 * Generate a file consists of rainfall data
 * using DataOutputStream
 * 
 * @author zyqq
 */

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteRainData3 {
	public static void main(String[] args) {

		// 1. Declaration of target storage
		String targetStorage = "rainData.txt";

		// data declaration
		String date[] = { "18/03/2022", "19/03/2022", "20/03/2022", "21/03/2022", "22/03/2022", "24/04/2022" };
		double rainFall[] = { 7.0, 0.0, 0.0, 8.0, 0.0, 0.0 };

		try {

			// 2. Create stream to read data
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(targetStorage));

			// for-loop for data in array
			for (int i = 0; i < date.length; i++) {

				// 3. Write data into stream
				dos.writeUTF(date[i]);
				dos.writeDouble(rainFall[i]);

				// 4. Flush for each writing
				dos.flush();
			}

			// 5. Close stream
			dos.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

		// Indicate end of program - Could be succcessful
		System.out.println("End of program.");
	}
}
