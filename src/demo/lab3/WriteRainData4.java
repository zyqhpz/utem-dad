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
		int stationId[][] = {
				{ 2320005, 2421003 },
				{ 2324033, 2125002 },
				{ 2222033, 2222003 } };
		String stationName[][] = {
				{ "Ladang Sg. Bharu", "Simpang Ampat" },
				{ "Hospital Jasin", "Telok Rimba" },
				{ "Batu Hampar", "Klebang Besar" } };
		String districtName[] = { "Alor Gajah", "Jasin", "Melaka Tengah" };
		String date[] = { "20/03/2022", "21/03/2022", "22/03/2022", "23/04/2022", "24/04/2022", "25/04/2022" };

		double rainData1[] = { 0.0, 15.0, 0.0, 0.0, 28.0, 0.0 }; // Ladang Sg. Bharu
		double rainData2[] = { 0.0, 0.0, 0.0, 14.0, 4.0, 0.0 }; // Simpang Ampat

		double rainData3[] = { 0.0, 16.0, 0.0, 0.0, 6.0, 0.0 }; // Hospital Jasin
		double rainData4[] = { 0.0, 25.0, 0.0, 0.0, 1.0, 0.0 }; // Telok Rimba

		double rainData5[] = { 0.0, 17.0, 0.0, 0.0, 0.0, 0.0 }; // Batu Hampar
		double rainData6[] = { 0.0, 4.0, 0.0, 0.0, 0.0, 0.0 }; // Klebang Besar

		double[][][] rainFall = { { rainData1, rainData2 }, { rainData3, rainData4 }, { rainData5, rainData6 } };

		try {
			// 2. Create stream to read data
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(targetStorage));

			// for-loop for data in array
			for (int i = 0; i < stationId.length; i++) {

				for (int j = 0; j < stationId[i].length; j++) {

					// 3. Write data into stream
					dos.writeInt(stationId[i][j]);
					dos.writeUTF(stationName[i][j]);
					dos.writeUTF(districtName[i]);

					for (int k = 0; k < rainFall[i][j].length; k++) {

						dos.writeUTF(date[k]);
						dos.writeDouble(rainFall[i][j][k]);

						// 4. Flush for each writing
						dos.flush();
					}
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
