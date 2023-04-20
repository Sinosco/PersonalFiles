import java.util.Scanner;

public class Main{
    static Scanner input = new Scanner(System.in);
	public static void main(String[] args){

        Ludu game = createGameSettings();
	}

    public static Ludu createGameSettings(){
        String userInput;
        while(true){
            System.out.println("Standard or Custom ludu rules?");
            userInput = input.nextLine();
            if(userInput.toLowerCase().equals("stardard"))
                return new Ludu();
            else if(userInput.toLowerCase().equals("custom"))
                return new Ludu(customGameSettingsPrompts());

            else System.out.println("Please make sure you enter either \"Standard\" or \"Custom\"");
        }
    }
    
    public static int[] customGameSettingsPrompts(){
        int[] settings = new int[8];
        System.out.println("Enter an integer value for each input or \"Standard\"");

        String userInput = "";
        while(!userInput.equals("EXITWHILELOOP")){
            System.out.println("How many dice would you like to play with?");
            userInput = input.nextLine();
            if(userInput.toLowerCase().equals("standard")|| isNumber(userInput) && Integer.parseInt(userInput)>0){
                settings[0] = userInput.toLowerCase().equals("standard") ? 2 : Integer.parseInt(userInput);
                userInput = "EXITWHILELOOP";
            }
            else System.out.println("Please enter a valid integer value or \"Standard\"");
        }        
        userInput = "";
        while(!userInput.equals("EXITWHILELOOP")){
            System.out.println("What is the lowest integer value for your dice?");
            userInput = input.nextLine();
            if(userInput.toLowerCase().equals("standard")|| isNumber(userInput) && Integer.parseInt(userInput)>0){
                settings[1] = userInput.toLowerCase().equals("standard") ? 1 : Integer.parseInt(userInput);
                userInput = "EXITWHILELOOP";
            }
            else System.out.println("Please enter a valid integer value or \"Standard\"");
        }
        userInput = "";
        while(!userInput.equals("EXITWHILELOOP")){
            System.out.println("What is the highest integer value for your dice?");
            userInput = input.nextLine();
            if(userInput.toLowerCase().equals("standard")|| isNumber(userInput) && Integer.parseInt(userInput)>=settings[1]){
                settings[2] = userInput.toLowerCase().equals("standard") ? (int)(Math.random()*6)+settings[1] : Integer.parseInt(userInput);
                userInput = "EXITWHILELOOP";
            }
            else System.out.println("Please enter a valid integer value or \"Standard\"");
        }
        userInput = "";
        while(!userInput.equals("EXITWHILELOOP")){
            System.out.println("How long do you want the board to be?");
            userInput = input.nextLine();
            if(userInput.toLowerCase().equals("standard") || isNumber(userInput) && Integer.parseInt(userInput)>0){
                settings[3] = userInput.toLowerCase().equals("standard") ? 72 : Integer.parseInt(userInput); //STANDARD MAY HAVE TO CHANGE
                userInput = "EXITWHILELOOP";
            }
            else System.out.println("Please enter a valid integer value or \"Standard\"");
        }
        userInput = "";
        while(!userInput.equals("EXITWHILELOOP")){
            System.out.println("How many people are playing? (standard is 4)");
            userInput = input.nextLine();
            if(userInput.toLowerCase().equals("standard")|| isNumber(userInput) && Integer.parseInt(userInput)>0){
                settings[4] = userInput.toLowerCase().equals("standard") ? 4 : Integer.parseInt(userInput);
                userInput = "EXITWHILELOOP";
            }
            else System.out.println("Please enter a valid integer value or \"Standard\"");
        }
        userInput = "";
        while(!userInput.equals("EXITWHILELOOP")){
            System.out.println("How many pieces will each person get?");
            userInput = input.nextLine();
            if(userInput.toLowerCase().equals("standard")|| isNumber(userInput) && Integer.parseInt(userInput)>0){
                settings[5] = userInput.toLowerCase().equals("standard") ? 4 : Integer.parseInt(userInput);
                userInput = "EXITWHILELOOP";
            }
            else System.out.println("Please enter a valid integer value or \"Standard\"");
        }
        userInput = "";
        while(!userInput.equals("EXITWHILELOOP")){
            System.out.println("What is the special number?");
            userInput = input.nextLine();
            if(userInput.toLowerCase().equals("standard")|| isNumber(userInput) && Integer.parseInt(userInput)>settings[1] && Integer.parseInt(userInput)<=settings[2]){
                settings[6] = userInput.toLowerCase().equals("standard") ? (int)Math.random()*(settings[2]-settings[1])+settings[1] : Integer.parseInt(userInput);
                userInput = "EXITWHILELOOP";
            }
            else System.out.println("Please enter a valid integer value or \"Standard\"");
        }
        userInput = "";
        while(!userInput.equals("EXITWHILELOOP")){
            System.out.println("How many strikes will you allow?");
            userInput = input.nextLine();
            if(userInput.toLowerCase().equals("standard")|| isNumber(userInput) && Integer.parseInt(userInput)>1){
                settings[7] = userInput.toLowerCase().equals("standard") ? 3 : Integer.parseInt(userInput);
                userInput = "EXITWHILELOOP";
            }
            else System.out.println("Please enter a valid integer value or \"Standard\"");
        }
        userInput = "";
        return settings;
    }
    
    public static boolean isNumber(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

