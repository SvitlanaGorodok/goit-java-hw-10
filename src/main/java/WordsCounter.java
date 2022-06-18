import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class WordsCounter {
    public static void CountWords(String path) {
        File file = new File(path);
        StringBuilder builder = new StringBuilder();
        isFileExist(file);

        try (
                BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while (line != null){
                builder.append(line).append(" ");
                line = reader.readLine();
            }
        } catch (IOException e){
            System.err.println(e.getMessage());
        }

        List<String> words = new LinkedList<String>(Arrays.asList(builder.toString().split(" ")));
        List<String> wordsToCount = words.stream()
                .filter(word -> !word.equals("") && !word.equals(" "))
                .distinct()
                .collect(Collectors.toList());
        wordsToCount = sortByCount((ArrayList<String>) wordsToCount, words);
        wordsToCount = wordsToCount.stream()
                .map(word -> {return word + " " + count(word, words);})
                .collect(Collectors.toList());
        for (String word : wordsToCount) {
            System.out.println(word);
        }

    }

    private static void isFileExist (File file){
        if (!file.exists()){
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e){
                System.err.println(e.getMessage());
            }
        }
    }

    private static int count(String word, List<String> line){
        int counter = 0;
        for (String wordToCheck : line) {
            if (wordToCheck.equals(word)){
                counter++;
            }
        }
        return counter;
    }

    private static List<String> sortByCount (ArrayList<String> words, List<String> line){
        int[] counts = new int[words.size()];
        int index = 0;
        boolean isReplaced = true;
        String temp;
        int tempCount;
        for (int i =0; i < words.size();i++) {
            counts[i] = count(words.get(i), line);
        }
        while (isReplaced){
            isReplaced = false;
            for (int i =0; i < words.size()-1;i++) {
                if(counts[i]<counts[i+1]){
                    tempCount = counts[i];
                    counts[i] = counts[i+1];
                    counts[i+1] = tempCount;
                    temp = words.get(i);
                    words.set(i,words.get(i+1));
                    words.set(i+1,temp);
                    isReplaced = true;
                }
            }
        }
        return words;
    }
}
