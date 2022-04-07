package week4.lab4.exercise5.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * This class represent the server to receive a text from user
 * and send back the translated text to the user
 * 
 * @author haziqhapiz
 *
 */

public class ServerTranslationApp {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;

		try {
			int portNo = 4229;
			serverSocket = new ServerSocket(portNo);

			TranslationApp translationApp = new TranslationApp();

			// String text1 = "Good Afternoon.";
			System.out.println("Waiting for request");

			while (true) {
				Socket clientSocket = serverSocket.accept();

				// retrieve text and selected language from client
				DataInputStream dis = new DataInputStream(
						clientSocket.getInputStream());
				String text = dis.readUTF();
				int language = dis.readInt();

				// translate text
				String translatedText = translationApp.translateText(
						text, language);

				// create log
				String log = "Text get from client: " + text + " | Translated: "
						+ translatedText;

				System.out.println(log);

				// send translated text to client
				DataOutputStream dos = new DataOutputStream(
						clientSocket.getOutputStream());
				dos.writeUTF(translatedText);

				dis.close();
				dos.close();

				clientSocket.close();
			}
		} catch (IOException e) {

			if (serverSocket != null) {
				serverSocket.close();
			}

			e.printStackTrace();
		}
	}
}
