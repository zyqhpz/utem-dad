package demo.lab3;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class WriteRainData5 {
	public static void main(String[] args) {
		
		String targetStorage = "rainData5.txt";
		
		// data declaration
		int stationId[] = { 2222006, 2421003 };
		String stationName[] = { "Cheng (Taman Merdeka)", "Simpang Ampat" };
		String districtName[] = { "Melaka Tengah", "Alor Gajah" };
		String date[] = {"18/03/2022", "19/03/2022", "20/03/2022", "21/03/2022", "22/03/2022", "24/04/2022" };
		double rainFall[][] = { { 7.0, 0.0, 0.0, 8.0, 0.0, 0.0 },
								{ 3.0, 0.0, 0.0, 0.0, 0.0, 14.0 } };

		try {
			// 2. Create stream to read data
//			DataOutputStream dos = new DataOutputStream(new FileOutputStream(targetStorage));
//			Writer writer = new Writer(new FileOutputStream(targetStorage));
			
			Writer writer;
			
			writer = new BufferedWriter(new OutputStreamWriter(
				     new FileOutputStream(targetStorage)));
			
			// for-loop for data in array
			
			for (int i = 0; i < stationId.length; i++) {
				
//				dos.writeInt(stationId.length);
//				dos.writeByte(stationId[i]);
				writer.write(stationId[i]);
//				writer.new
				writer.write(stationName[i]);
				writer.write(districtName[i]);
				
				for (int j = 0; j < date.length; j++) {
					
					writer.write(date[j]);
//					writer.write(rainFall[i][j]);

					// 4. Flush for each writing
					writer.flush();
				}
			}
			
			// 5. Close stream
			writer.close();

		} catch (IOException e) {
			
			e.printStackTrace();
		}  

		// Indicate end of program - Could be succcessful
		System.out.println("End of program.");
	}
}
