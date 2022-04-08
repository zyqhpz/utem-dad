package week5.lab.greeting.client;

public class Sentence {

    private String sentence;

    Sentence() {
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public void getSentenceInput() {
        System.out.println("Enter a sentence: ");
        sentence = System.console().readLine();

        setSentence(sentence);
    }
}
