import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TxtJson {
    public static void fromTxtToJson(String pathTxt, String pathJson){
        List<User> usersList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(pathTxt))){
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null){
                if (!line.isEmpty()){
                    User user = new User();
                    String[] userFields = line.split(" ");
                    user.setName(userFields[0]);
                    user.setAge(Integer.parseInt(userFields[1]));
                    usersList.add(user);
                    line = reader.readLine();
                }
            }
        } catch (IOException e){
            System.err.println(e.getMessage());
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(pathJson))) {
            Gson gson = new Gson();
                out.write(gson.toJson(usersList));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
