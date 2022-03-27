package demo.lab3;

/**
 * Read a file consists of rainfall data in sequence of array
 * using Reader
 * 
 * @author zyqq
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReadRainData5 {

	public static void main(String[] args) {

		// 1. Declaration of input source
		String targetStorage = "rainData5.txt";

		// 2. Declaration of input stream object
		System.out.println("Input from " + targetStorage + "\n");

		try {
			int numOfStation = 0;
			double totalRainDataEachStation = 0;
			int noOfRecordEachStation = 0;

			// 3. Create object
			var br = new BufferedReader(new InputStreamReader(
					new FileInputStream(targetStorage)));

			String stationId, stationName, districtName;

			// 4. Read values from the stream
			while ((stationId = br.readLine()) != null) {

				System.out.println("Station ID: " + stationId);

				numOfStation++;

				stationName = br.readLine();
				districtName = br.readLine();

				System.out.println("Station Name: " + stationName);
				System.out.println("District Name: " + districtName);

				totalRainDataEachStation = 0;
				noOfRecordEachStation = 0;

				for (int j = 0; j < 6; j++) {

					String date = br.readLine();
					double rainFall = Double.parseDouble(br.readLine());

					System.out.println(date + " - " + rainFall);

					totalRainDataEachStation += rainFall;
					noOfRecordEachStation++;

				}

				System.out.println("Average rain for station " + stationName + " in "
						+ districtName + " is " + totalRainDataEachStation / noOfRecordEachStation + "\n");

			}

			System.out.println("Number of station detected is " + numOfStation + " station(s).");

			// 5. Close stream
			br.close();

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		// Indicate end of program - Could be succcessful
		System.out.println("\nEnd of program");

	}
	// }

}
