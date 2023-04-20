import java.util.*;
/* happy numbers are defined as when the digits of a  number
 * squared eventually add together to become 1. Sad numbers are when
 * it cannot equal 1 and just repeats a pattern.
 * Ex: 2: 2^2=4 , 4^2 = 16 , 1^2 + 6^2 = 37 , 3^2 + 7^2 = 58 , 5^2 + 8^2 = 89 , 8^2 + 9^2 = 145 , 1^2 + 4^2 + 5^2 = 42 , 4^2 + 2^2 = 20 , 2^2 + 0^2 = 4. 
 *     We have already done 4^2, therefore this is an endlessly repeating pattern.
 * Ex2: 13: 1^2 + 3^2 = 10 , 1^2 + 0^2 = 1
 */

public class Main{
    static ArrayList<Integer> numOutcomes = new ArrayList<Integer>();
    static ArrayList<Integer> possibleHappyNumbers = new ArrayList<Integer>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        String userChoice = "";
        while(!userChoice.equals("finished"))
        {
            System.out.println("\nNormal Mode, Normal Mode With Work, All Happy Numbers, or exit?");
            userChoice = input.nextLine();
            if(userChoice.toLowerCase().equals("normal mode") || userChoice.equals("1")){
                originalMainNumCheckerUserInput();
            }
            else if(userChoice.toLowerCase().equals("normal mode with work") || userChoice.equals("2")){
                MainNumCheckerUserInputWithWork();
            }
            else if(userChoice.toLowerCase().equals("all happy numbers") || userChoice.equals("3")){
                findAllHappyNumbersInRange();
            }
            else if(userChoice.toLowerCase().equals("exit")){
                userChoice = "finished";
            }
        }
        
    }

    static int sumNums(int x){
        int result = 0;
        while(x!=0){
            result += Math.pow(x%10, 2);
            x /= 10;
        }
        return result;
    }

    static boolean isNotRepeated(int sum){
        for(int i=0;i<numOutcomes.size();i++){
            if(numOutcomes.get(i) == sum)
                return false;
        }
        return true;
    }

    static void numCheckerMethod(String userGivenNum){
        boolean numberRepetition = false;
        int userNum = Integer.parseInt(userGivenNum);
        int curNum = userNum;
        while(!numberRepetition){
            numOutcomes.add(curNum);
            curNum = sumNums(curNum);
            if(curNum==1){
                System.out.println(userNum + " is a happy number!\n");
                numberRepetition = true;
            }

            if(!isNotRepeated(curNum) && !numberRepetition){
                System.out.println(userNum + " is a sad number :(\n");
                numberRepetition = true;
            }
        }
        numOutcomes.clear();
    }

    static void numCheckerNoInput(int originalNumber){
        boolean numberRepetition = false;
        int curNum = originalNumber;
        while(!numberRepetition){
            numOutcomes.add(curNum);
            curNum = sumNums(curNum);
            if(curNum==1){
                possibleHappyNumbers.add(originalNumber);
                numberRepetition = true;
            }

            if(!isNotRepeated(curNum) && !numberRepetition){
                numberRepetition = true;
            }
        }
        numOutcomes.clear();
    }

    static void originalMainNumCheckerUserInput(){
        boolean isActive = true;

        while(isActive){
            String userInput = "";
            while(!userInput.equals("exit")){
                System.out.print("Enter the number you wish to test, type \"exit\" to exit program: ");
                userInput = input.nextLine();
                try {
                    int intValue = Integer.parseInt(userInput);
                    break;
                } catch (NumberFormatException e){
                    isActive = true; //throwaway line just to make sure this catch method works (idk how this works)
                }
            }
            if(userInput.toLowerCase().equals("exit")) break;

            numCheckerMethod(userInput);
        }
    }

    static void findAllHappyNumbersInRange(){
        boolean userConfirmation = false;
        int maxRange = 0;
        while(!userConfirmation){
            System.out.print("Enter the maximum range you'd like to go to: ");
            int userRange = input.nextInt();
            if(userRange>7038){
                System.out.println("A range that high will not display all happy numbers, only the last ~1000 that exist. Type yes to continue, no to redo your number");
                String userChoice = input.nextLine();
                if(input.nextLine().toLowerCase().equals("yes")){
                    userConfirmation = true;
                    maxRange = userRange;
                }
            }
            else{
                userConfirmation = true;
                maxRange = userRange;
            }
        }

        for(int i=0;i<=maxRange;i++){
            numCheckerNoInput(i);
        }

        for(int i=0;i<possibleHappyNumbers.size();i++){
            System.out.println(possibleHappyNumbers.get(i));
        }

        // This code segment was used to find how many number can fit on the terminal page
        // int num=0;
        // while(possibleHappyNumbers.size()<1018){
        //     numCheckerNoInput(num);
        //     num++;
        // }
        // for(int i=0;i<possibleHappyNumbers.size();i++){
        //     System.out.println(possibleHappyNumbers.get(i));
        // }
    }

    static void MainNumCheckerUserInputWithWork(){
        boolean isActive = true;

        while(isActive){
            String userInput = "";
            while(!userInput.equals("exit")){
                System.out.print("Enter the number you wish to test, type \"exit\" to exit program: ");
                userInput = input.nextLine();
                try {
                    int intValue = Integer.parseInt(userInput);
                    break;
                } catch (NumberFormatException e){
                    isActive = true; //throwaway line just to make sure this catch method works (idk how this works)
                }
            }
            if(userInput.toLowerCase().equals("exit")) break;

            numCheckerMethodWithWork(userInput);
        }
    }

    static void numCheckerMethodWithWork(String userGivenNum){
        boolean numberRepetition = false;
        int userNum = Integer.parseInt(userGivenNum);
        int curNum = userNum;
        while(!numberRepetition){
            numOutcomes.add(curNum);
            System.out.print(sumDigitsWork(curNum) + " | ");
            curNum = sumNums(curNum);
            if(curNum==1){
                System.out.println("\n" + userNum + " is a happy number!\n");
                numberRepetition = true;
            }

            if(!isNotRepeated(curNum) && !numberRepetition){
                System.out.println("\n" + userNum + " is a sad number :(\n");
                numberRepetition = true;
            }
        }
        numOutcomes.clear();
    }

    static String sumDigitsWork(int x){
        String result = "";
        int temp = x;
        int xLength = 0;
        while(temp>0){
            temp/=10;
            xLength++;
        }
        temp = x;
        for(int i=xLength;i>0;i--){
            int powerOfTen = (int)Math.pow(10,i-1);
            if(i==xLength)
                result += temp/powerOfTen + "^2 + ";
            else
                result += temp/powerOfTen%10 + "^2 + ";
            temp = x;
        }
        return result.substring(0, result.length()-2) + "= " + sumNums(x);
    }
}