package week4.lab4.exercise5.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/*
 * This class represent the window for the client side TCP application.
 * It receive an input from user
 * send the input to server to be translate
 * retrieve the translated text from user to be display to user
 * 
 * @author haziqhapiz
 *
 */

public class ClientTranslationApp {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 4229);

            // get text from user that want to be translated
            String text = chooseText();

            // get language from user selection
            int language = chooseLanguage();

            // write text to socket output stream to send to server
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(text);
            dos.writeInt(language);

            // read translated text from server
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String translatedText = dis.readUTF();
            System.out.println("\nTranslated text: " + translatedText);

            // Close everything
            dis.close();
            dos.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // choose language for text to be translate into
    private static int chooseLanguage() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose language: ");
        System.out.println("1. Bahasa Malaysia");
        System.out.println("2. Arabic");
        System.out.println("3. Korean");
        System.out.print(">> ");

        int language = scanner.nextInt();

        return language;
    }

    // choose which text to be translate
    private static String chooseText() {
        System.out.println("Choose text to translate:- ");
        System.out.println("1. Good morning");
        System.out.println("2. Good night");
        System.out.println("3. How are you?");
        System.out.println("4. Thank you");
        System.out.println("5. Goodbye");
        System.out.println("6. What's up?");
        System.out.print(">> ");

        Scanner scanner = new Scanner(System.in);

        String text = "";
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // System.out.println("Good morning");
                text = "Good morning";
                break;
            case 2:
                // System.out.println("Good night");
                text = "Good night";
                break;
            case 3:
                // System.out.println("How are you?");
                text = "How are you?";
                break;
            case 4:
                // System.out.println("Thank you");
                text = "Thank you";
                break;
            case 5:
                // System.out.println("Goodbye");
                text = "Goodbye";
                break;
            case 6:
                // System.out.println("What's up?");
                text = "What's up?";
                break;
            default:
                // System.out.println("Invalid choice");
                break;
        }

        return text;
    }
}
