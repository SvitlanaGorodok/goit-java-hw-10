import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ValidNumber {

    public static void PrintValidNumbers (String path){
        File file = new File(path);
        isFileExist(file);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while (line != null){
                if (isValid(line)){
                    System.out.println(line);
                }
                line = reader.readLine();
            }
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    private static boolean isValid(String telNumber){
        return telNumber.matches("[(](\\d{3})[)][ ](\\d{3})-(\\d{4})")
                || telNumber.matches("(\\d{3})-(\\d{3})-(\\d{4})");
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
}
