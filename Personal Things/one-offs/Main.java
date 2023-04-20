import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String userInput;
        do{
            System.out.println("Enter your String or \"exit\"");
            userInput = input.nextLine();
            longestString bruh = new longestString(userInput);
            System.out.println(bruh.longe2());     
        } while(!userInput.toLowerCase().equals("exit"));
    }
}