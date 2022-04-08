package week5.lab.greeting.client;

import java.util.Scanner;

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
        System.out.print("Enter a sentence: ");
        Scanner sc = new Scanner(System.in); // Create a Scanner object

        sentence = sc.nextLine(); // Read user input
    }
}
