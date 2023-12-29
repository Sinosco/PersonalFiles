import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
 
//chatgpt made me change the name from HashSetThingy sadge
public class HashSetUtil {
    public static HashSet<String> importWordList(String filePath) {
        HashSet<String> wordList = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String word;
            while ((word = reader.readLine()) != null) {
                if(word.length()>=6) wordList.add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordList;
    }
}
