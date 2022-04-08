package week5.lab.greeting.server.serverside;

public class SentenceProcessor {

	private int size = 65535;

	private String sentence;

	public SentenceProcessor(byte[] byteData) {

		this.sentence = new String(byteData);
	}

	public String getSentence() {

		return sentence;
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
	 * This method count the number of vowels in a sentence
	 * 
	 * @return
	 */
	public int countVowels() {

		int index = 0;
		char currentChar = sentence.charAt(index);
		int vowelCount = 0;
		while (currentChar != '\0') {

			if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i'
					|| currentChar == 'o' || currentChar == 'u') {

				vowelCount++;
			}

			currentChar = sentence.charAt(index++);
		}

		return vowelCount;

	}

	/**
	 * This method count the number of consonants in a sentence
	 * 
	 * @return
	 */
	public int countConsonants() {

		int index = 0;
		char currentChar = sentence.charAt(index);
		int consonantCount = 0;
		while (currentChar != '\0') {

			if (currentChar != 'a' && currentChar != 'e' && currentChar != 'i'
					&& currentChar != 'o' && currentChar != 'u') {

				consonantCount++;
			}

			currentChar = sentence.charAt(index++);
		}

		return consonantCount;

	}

	/**
	 * This method count the number of punctuation in a sentence
	 * 
	 * @return
	 */
	public int countPunctuations() {

		int index = 0;
		char currentChar = sentence.charAt(index);
		int punctuationCount = 0;
		while (currentChar != '\0') {

			if (currentChar == '.' || currentChar == ',' || currentChar == '!'
					|| currentChar == '?') {

				punctuationCount++;
			}

			currentChar = sentence.charAt(index++);
		}

		return punctuationCount;

	}

}
