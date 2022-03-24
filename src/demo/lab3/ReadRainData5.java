package demo.lab3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReadRainData5 {

	public static void main(String[] args) {
		String targetStorage = "rainData5.txt";
		
		// 2. Declaration of input stream object
//		DataInputStream disObject;
		
		System.out.println("Input from " + targetStorage + "\n");
		
		try {
			int numOfStation = 0;
			double totalRainDataEachStation = 0;
			int noOfRecordEachStation = 0;
			
			// 3. Create object
//			disObject = new DataInputStream(new FileInputStream(targetStorage));
			Reader reader;
			
			reader = new InputStreamReader(new FileInputStream(targetStorage));
			
			var br = new BufferedReader(new InputStreamReader(
	                new FileInputStream(targetStorage)));
			
			// 4. Read values from the stream
			
			// check if any data is exist in the stream
//			while (reader. > 0) {
			
//			int stationId = reader.read();
			
            String line;

            while ((line = br.readLine()) != null) {

                System.out.println("\n" + line);
            }

				
//				int stationId = disObject.readInt();
//				String stationName = reader.read(null);
//				String districtName = reader.read();
//				
//				System.out.println("StationID: " + stationId);
//				
//				for (int i = 0; i < 6; i++) {
//					String date = disObject.readUTF();
//					double rainFall = disObject.readDouble();
//					
//					System.out.println("Date: " + date + " - " + rainFall);
//					
//					totalRainDataEachStation += rainFall;
//					noOfRecordEachStation++;
//				}
//				
//				System.out.println("Average rain for station " + stationName + " in "
//						+ districtName + " is " + totalRainDataEachStation/noOfRecordEachStation + "\n");
				
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
//			} 
			
			// 5. Close stream
			reader.close();
			
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
