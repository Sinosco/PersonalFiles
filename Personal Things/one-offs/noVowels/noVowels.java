import java.util.Scanner;

public class noVowels{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String userText = "";
        do{
            System.out.print("Enter the string you want to remove vowels from: ");
            userText = input.nextLine();

            String vowels = "aeiou";
            String noVowelText = "";
            int index = 0;
            while(index<userText.length()){
                //if the character at that index isn't a vowel, add it to the result, otherwise add nothing.
                noVowelText += vowels.indexOf(userText.charAt(index))<0 ? userText.substring(index, index+1) : "";
                index++;
            }

            System.out.println("Final result: " + noVowelText + "\n");
        } while(!(userText).toLowerCase().equals("exit"));
    }
}