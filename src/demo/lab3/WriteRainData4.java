package demo.lab3;

/**
 * Generate a file consists of rainfall data in sequence of array
 * using DataOutputStream
 * 
 * @author zyqq
 */

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteRainData4 {

	public static void main(String[] args) {
		
		String targetStorage = "rainData4.txt";
		
		// data declaration
		int stationId[] = { 2222006, 2421003 };
		String stationName[] = { "Cheng (Taman Merdeka)", "Simpang Ampat" };
		String districtName[] = { "Melaka Tengah", "Alor Gajah" };
		String date[] = {"18/03/2022", "19/03/2022", "20/03/2022", "21/03/2022", "22/03/2022", "24/04/2022" };
		double rainFall[][] = { { 7.0, 0.0, 0.0, 8.0, 0.0, 0.0 },
								{ 3.0, 0.0, 0.0, 0.0, 0.0, 14.0 } };

		try {
			// 2. Create stream to read data
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(targetStorage));
			
			// for-loop for data in array
			
			for (int i = 0; i < stationId.length; i++) {
				
//				dos.writeInt(stationId.length);
//				dos.writeByte(stationId[i]);
				dos.writeInt(stationId[i]);
				dos.writeUTF(stationName[i]);
				dos.writeUTF(districtName[i]);
				
				for (int j = 0; j < date.length; j++) {
					
//					byte date = (byte) date[i];
//					byte stationN = (byte) stationName;
					// 3. Write data into stream
//					dos.writeByte(stationId[i]);
//					dos.writeUTF(stationName[i]);
//					dos.writeUTF(districtName[i]);
					dos.writeUTF(date[j]);
					dos.writeDouble(rainFall[i][j]);

					// 4. Flush for each writing
					dos.flush();
				}
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
