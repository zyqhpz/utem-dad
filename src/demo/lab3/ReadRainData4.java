package demo.lab3;

/**
 * Read a file consists of rainfall data in sequence of array
 * using DataInputStream
 * 
 * @author zyqq
 */

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ReadRainData4 {

	public static void main(String[] args) {

		// 1. Read a source file
		String targetStorage = "rainData4.txt";

		// 2. Declaration of input stream object
		DataInputStream disObject;

		System.out.println("Input from " + targetStorage + "\n");

		try {
			int numOfStation = 0;
			double totalRainDataEachStation = 0;
			int noOfRecordEachStation = 0;

			// 3. Create object
			disObject = new DataInputStream(new FileInputStream(targetStorage));

			// check if any data is exist in the stream
			while (disObject.available() > 0) {

				totalRainDataEachStation = 0;
				noOfRecordEachStation = 0;

				// 4. Read values from the stream
				int stationId = disObject.readInt();
				String stationName = disObject.readUTF();
				String districtName = disObject.readUTF();

				numOfStation++;

				System.out.println("StationID: " + stationId);

				double rainFall = 0;

				for (int i = 0; i < 6; i++) {
					String date = disObject.readUTF();
					rainFall = disObject.readDouble();

					System.out.println("Date: " + date + " - " + rainFall);

					totalRainDataEachStation += rainFall;
					noOfRecordEachStation++;
				}

				System.out.println("Average rain for station " + stationName + " in "
						+ districtName + " is " + totalRainDataEachStation / noOfRecordEachStation + "\n");

			}
			
			System.out.println("Number of station detected is " + numOfStation + " station(s).");

			// 5. Close stream
			disObject.close();

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		// Indicate end of program - Could be succcessful
		System.out.println("\nEnd of program");

	}
	// }

}
