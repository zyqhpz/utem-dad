package week5.lab.greeting.server.serverside;

public class SentenceProcessor {

	private int size = 65535;
	private String sentence;
	private int vowels;
	private int consonants;
	private int punctuation;

	public SentenceProcessor(byte[] byteData) {
		this.sentence = new String(byteData);
		processSentence();
	}

	public String getSentence() {
		return sentence;
	}

	public int getVowels() {
		return vowels;
	}

	public int getConsonants() {
		return consonants;
	}

	public int getPunctuation() {
		return punctuation;
	}

	/**
	 * This method convert value into an array of byte
	 * 
	 * @param length
	 * @return
	 */
	public byte[] convertToByteArray(int value) {

		byte[] outData = new byte[size];

		String stringValue = Integer.valueOf(value).toString();

		outData = stringValue.getBytes();

		return outData;
	}

	/**
	 * This method count the number of characters in a sentence
	 * 
	 * @return
	 */
	public int countCharacters() {

		int index = 0;
		char currentChar = sentence.charAt(index);
		while (currentChar != '\0') {

			currentChar = sentence.charAt(index++);
		}

		return index - 1;
	}

	/**
	 * This method process the sentence and count the number of vowels, consonants
	 * and punctuation
	 * regardless of case
	 * 
	 */
	public void processSentence() {

		vowels = 0;
		consonants = 0;
		punctuation = 0;

		sentence = sentence.toLowerCase();
		for (int i = 0; i < sentence.length(); ++i) {
			char ch = sentence.charAt(i);

			// check if character is any of a, e, i, o, u
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				++vowels;
			}

			// check if character is in between a to z
			else if ((ch >= 'a' && ch <= 'z')) {
				++consonants;
			}

			// check if character is any of the punctuation
			else if (ch == '.' || ch == ',' || ch == '!' || ch == '?') {
				++punctuation;
			}
		}
	}
}
