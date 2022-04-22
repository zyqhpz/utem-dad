package week7.textApp;

public class TextExtractionTaskMultiThreadsApp {
    public static void main(String[] args) {

        // create runnable object
        Runnable task1 = new TextExtractionTask();
        Runnable task2 = new TextExtractionTask();
        Runnable task3 = new TextExtractionTask();

        // create thread object
        Thread textExtractor = new Thread(task1, "textExtractor");
        Thread textGenerator = new Thread(task2, "textGenerator");
        Thread textAnalyzer = new Thread(task3, "textAnalyzer");

        // start thread
        textExtractor.start();
        textGenerator.start();
        textAnalyzer.start();

    }
}
