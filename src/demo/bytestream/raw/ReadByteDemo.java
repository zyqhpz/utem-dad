package demo.bytestream.raw;

import java.io.FileInputStream;

/**
 * This program demonstrate reading data from a file using FileInputStream
 * 
 * @author emalianakasmuri
 *
 */
public class ReadByteDemo {
	
	public static void main (String args[]) {
		
		// 1. Declaration of input source
		String fileName = "outByteDemo.dat";
		
		// 2. Declaration of input stream object
		FileInputStream fisObject;
		
		System.out.println("Input from " + fileName + "\n");
		
		try {
			
			// 3. Create object
			fisObject = new FileInputStream(fileName);
			
			// 4. Read values from the stream
			// -1: read until end of file/stream
			int value = 0;
			value = fisObject.read();
			while (value != -1) {
				
				System.out.println(value);
				
				// Read next value
				value = fisObject.read();
				
			} 
			
			// 5. Close stream
			fisObject.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		// Indicate end of program - Could be succcessful
		System.out.println("\nEnd of program");  
		
		
	}
	

}
