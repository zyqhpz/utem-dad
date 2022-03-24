package demo.lab3;

/**
 * Read a file consists of rainfall data
 * using DataInputStream
 * 
 * @author zyqq
 */

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ReadRainData3 {

	public static void main(String[] args) {
		
		String targetStorage = "rainData.txt";
		
		// 2. Declaration of input stream object
		DataInputStream disObject;
		
		System.out.println("Input from " + targetStorage);
		
		
		try {
			double total = 0;
			int noOfRecord = 0;
			
			// 3. Create object
			disObject = new DataInputStream(new FileInputStream(targetStorage));
			
			// 4. Read values from the stream
			
			// check if any data is exist in the stream
			while (disObject.available() > 0) {
				
				
				// Read values from the stream
				String date = disObject.readUTF();
				double rainFall = disObject.readDouble();
				
				total += rainFall;
				noOfRecord++;
				
				// print the values
				System.out.println("\nRain on " + date + " is " + rainFall + ".");
			} 
			
			// 5. Close stream
			disObject.close();
			
			double averageRain = total/noOfRecord;		
			
			System.out.println("\nAverage rain is " + averageRain);
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		// Indicate end of program - Could be succcessful
		System.out.println("\nEnd of program");  
		
	}
	
}
