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
		String targetStorage = "rainData4.txt";
		
		// 2. Declaration of input stream object
		DataInputStream disObject;
		
		System.out.println("Input from " + targetStorage + "\n");
		
		try {
			int numOfStation = 0;
			double totalRainDataEachStation = 0;
			int noOfRecordEachStation = 0;
			
//			String stationName[] = {};
//			double data
			
			// 3. Create object
			disObject = new DataInputStream(new FileInputStream(targetStorage));
			
			// 4. Read values from the stream
			
			// check if any data is exist in the stream
			while (disObject.available() > 0) {
				
//				numOfStation = disObject.readInt();
				
//				System.out.print(numOfStation);
				
				int stationId = disObject.readInt();
				String stationName = disObject.readUTF();
				String districtName = disObject.readUTF();
				
				System.out.println("StationID: " + stationId);
				
				for (int i = 0; i < 6; i++) {
					String date = disObject.readUTF();
					double rainFall = disObject.readDouble();
					
					System.out.println("Date: " + date + " - " + rainFall);
					
					totalRainDataEachStation += rainFall;
					noOfRecordEachStation++;
				}
				
				System.out.println("Average rain for station " + stationName + " in "
						+ districtName + " is " + totalRainDataEachStation/noOfRecordEachStation + "\n");
				
//				for (int i = 0; i < )
				
				// Read values from the stream
//				String date = disObject.readUTF();
//				double rainFall = disObject.readDouble();
//				
//				totalRainDataEachStation += rainFall;
//				noOfRecordEachStation++;
//				
//				// print the values
//				System.out.println("\nRain on " + date + " is " + rainFall + ".");
			} 
			
			// 5. Close stream
			disObject.close();
			
//			double averageRain = total/noOfRecord;		
			
//			System.out.println("\nAverage rain is " + averageRain);
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		// Indicate end of program - Could be succcessful
		System.out.println("\nEnd of program");  
		
	}
//	}
	
}
