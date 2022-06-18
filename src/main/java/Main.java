import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static final String PATH1 = "C:\\Users\\SA_komp\\Desktop\\Java\\numbers.txt";
    public static final String PATH2 = "C:\\Users\\SA_komp\\Desktop\\Java\\words.txt";
    public static final String PATH_TXT = "C:\\Users\\SA_komp\\Desktop\\Java\\file.txt";
    public static final String PATH_JSON = "C:\\Users\\SA_komp\\Desktop\\Java\\user.json";
    public static void main(String[] args) {
        ValidNumber.PrintValidNumbers(PATH1);
        WordsCounter.CountWords(PATH2);
        TxtJson.fromTxtToJson(PATH_TXT, PATH_JSON);
    }
}
