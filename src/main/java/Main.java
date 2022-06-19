public class Main {
    public static void main(String[] args) {
        ValidNumber.PrintValidNumbers("numbers.txt");
        WordsCounter.CountWords("words.txt");
        TxtJson.fromTxtToJson("file.txt", "user.json");
    }
}
