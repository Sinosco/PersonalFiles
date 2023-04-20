import java.util.*;

public class passwordGenerator{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("\n" + generatePassword(8) + "\n");
        while(true){
            try{
                System.out.println("How long do you want your password to be?");
                int passwordLength = input.nextInt();
                System.out.println("How many passwords would you like to print?");
                int amountOfPasswords = input.nextInt();
                System.out.println("\n");
                for(int i=0;i<amountOfPasswords;i++){
                    if(i%2==0){ System.out.print(generatePassword(passwordLength) + "\t\t");}
                    else{ System.out.println(generatePassword(passwordLength));}
                }
            } catch (NumberFormatException e){
                System.out.println("Enter valid positive integer values.\n");
            }
            System.out.println();
        }
    }
    static String makeNumber(){
        return Integer.toString((int)(Math.random()*10));
    }

    static String makeSymbol(){
        String symbolsAvailable = "!@#$%&?";
        int randomSymbol = (int)(Math.random()*7);
        return "" + symbolsAvailable.charAt(randomSymbol);
    }

    static String makeLetter(){
        String lettersAvailable = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        int randomSymbol = (int)(Math.random()*lettersAvailable.length());
        return "" + lettersAvailable.charAt(randomSymbol);
    }

    static String generatePassword(int passwordLength){
        String resultPassword = "";
        for(int i=0;i<passwordLength;i++){
            int letterType = (int)(Math.random()*3+1);
            switch(letterType){
                case 1:
                    resultPassword += makeNumber();
                    break;
                case 2:
                    resultPassword += makeSymbol();
                    break;
                case 3:
                    resultPassword += makeLetter();
                    break;
            }
        }
        return resultPassword;
    }
}

// randomly decide between letter, number, or symbol
// Number is easy to randly decide
// Letter and symbol can likely be accessed with an ascii conversion from int.
