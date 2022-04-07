package week4.lab4.exercise5.server;

/*
 * This class represent a controller to translate the text from user
 * 
 * @author haziqhapiz
 *
 */

public class TranslationApp {

    // translate text
    public String translateText(String text, int language) {
        String translatedText = "";

        // Bahasa Malaysia
        if (language == 1) {
            switch (text) {
                case "Good morning":
                    translatedText = "Selamat pagi";
                    break;
                case "Good night":
                    translatedText = "Selamat malam";
                    break;
                case "How are you?":
                    translatedText = "Apa khabar?";
                    break;
                case "Thank you":
                    translatedText = "Terima kasih";
                    break;
                case "Goodbye":
                    translatedText = "Selamat tinggal";
                    break;
                case "What's up?":
                    translatedText = "Ada apa?";
                    break;
            }
        }

        // Arabic
        if (language == 2) {
            switch (text) {
                case "Good morning":
                    translatedText = "صباح الخير";
                    break;
                case "Good night":
                    translatedText = "طاب مساؤك";
                    break;
                case "How are you?":
                    translatedText = "كيف حالك؟";
                    break;
                case "Thank you":
                    translatedText = "شكرا لك";
                    break;
                case "Goodbye":
                    translatedText = "مع السلامة";
                    break;
                case "What's up?":
                    translatedText = "ما أخبارك؟";
                    break;
            }
        }

        // Korean
        if (language == 3) {
            switch (text) {
                case "Good morning":
                    translatedText = "좋은 아침";
                    break;
                case "Good night":
                    translatedText = "안녕히 주무세요";
                    break;
                case "How are you?":
                    translatedText = "어떻게 지내세요?";
                    break;
                case "Thank you":
                    translatedText = "감사합니다";
                    break;
                case "Goodbye":
                    translatedText = "안녕";
                    break;
                case "What's up?":
                    translatedText = "뭐야?";
                    break;
            }
        }

        return translatedText;
    }
}
