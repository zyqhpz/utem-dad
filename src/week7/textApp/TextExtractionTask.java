package week7.textApp;

import java.util.ArrayList;
import java.util.List;

public class TextExtractionTask implements Runnable {

    private String text;
    private List<String> words;

    // public TextExtractionTask(String text, List<String> words) {
    // this.text = text;
    // this.words = words;
    // }

    public TextExtractionTask() {
        this.text = "The List component presents the user with a scrolling list of text items. The list can be set up so that the user can choose either one item or multiple items.";
        this.words = getWords(this.text);
    }

    // task 2. extract every word from the text
    public ArrayList<String> getWords(String text) {
        String[] words = text.split(" ");
        ArrayList<String> wordsList = new ArrayList<String>();
        for (String word : words) {
            wordsList.add(word);
        }

        return wordsList;
    }

    // randomize the order of the words in the word list
    public List<String> getRandomWords() {
        List<String> randomWords = new ArrayList<String>();
        while (words.size() > 0) {
            int index = (int) (Math.random() * words.size());
            randomWords.add(words.get(index));
            words.remove(index);
        }
        return randomWords;
    }

    // task 3. text generator from the list of words and in random order
    public String getRandomText() {
        List<String> words = getRandomWords();
        StringBuilder text = new StringBuilder();
        for (String word : words) {
            text.append(word + " ");
        }
        return text.toString();
    }

    // task 4. extract the text from the randomized text at a random length
    public String getExtractedText() {
        String extractedText = "";
        int randomLength = (int) (Math.random() * text.length());
        for (int i = 0; i < randomLength; i++) {
            extractedText += text.charAt(i);
        }

        return extractedText;
    }

    @Override
    public void run() {

        Thread currentThread = Thread.currentThread();

        System.out.println("--- " + currentThread.getName() + " starts ---");

        String randomText = "";
        String extractedText = "";

        if (currentThread.getName().contains("Generator")) {
            randomText = getRandomText();
        } else if (currentThread.getName().contains("Extractor")) {
            extractedText = getExtractedText();
        }

        System.out.println("--- " + currentThread.getName() + " ends ---");

        System.out.println(currentThread.getName() + " - Random text: " + randomText);
        System.out.println(currentThread.getName() + " - Extracted text: " + extractedText);

    }

}
