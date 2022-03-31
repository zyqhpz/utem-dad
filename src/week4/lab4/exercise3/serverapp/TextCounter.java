package week4.lab4.exercise3.serverapp;

/**
 * This class represents the controller of the server side application.
 * It receive the request from the client and process the request.
 * receieve text from the client and count the number of words in the text.
 * 
 * @author haziqhapiz
 *
 */

public class TextCounter {
	public int countWords(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isWhitespace(text.charAt(i))) {
                count++;
            }
        }
        return count + 1;
    }
}
