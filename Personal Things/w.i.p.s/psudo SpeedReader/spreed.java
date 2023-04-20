
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Timer;

public class spreed{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Timer("timer");

        System.out.println("Enter the text you'd like to spreed");
        String text = input.nextLine();
        ArrayList<String> words = convertToWords(text);
        System.out.println("Enter your desired wpm");
        int wpm = input.nextInt();
        for(int i=0;i<words.size();i++){
            System.out.println(words.get(i));
            TimeUnit.SECONDS.sleep(wpm/60);
        }
    }

    private static void Timer(String string) {
    }

    public static ArrayList<String> convertToWords(String text){
        ArrayList<String> result = new ArrayList<String>();
        int index = 0;
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)==' '){
                result.add(text.substring(index, i));
                index = i++;
            }
        }

        return result;
    }
}
