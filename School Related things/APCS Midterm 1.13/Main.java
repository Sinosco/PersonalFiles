// Shaikh Ahmed
// 1/13/2023
// Scenario 3
    // Explain how a programmer might get around the concept that arrays once declared and instantiated are rigid regarding size.
    // 1. Create a runner file that instantiates an array of a certain size
    // 2. Populate the array with data using a "for loop"
    // 3. Formulate a strategy on how you would allow the client to keep adding entries to the array even after it was filled with data.
    // 4. Code the strategy and then test to see if it is effective.

//A programmar can work around the issue of array ridigity by making a new array that is the desired n-length long, looping through the original array and copying
//it into the secondary array, then adding whatever values you please in the second array. An easier more practical method would be using an arraylist but we're
//pretending like those don't exist for now.

//I have completed this lab without assistance.

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //Instantiates an array of the user's choice and fills it from 1 to the length of the array (postulates 1 and 2 satisfied)
        //Try-catch functions are used to prevent mistakes in input. I have used this function before for a different project.
        int[] userArray;
        int originalArrayLength = 0;
        while(true){
            System.out.print("Enter the initial size of your array: ");
            try{
                originalArrayLength = Integer.parseInt(input.nextLine());   //if the user input cannot be parsed into an int then it forces them to reenter a value.
                userArray = new int[originalArrayLength];
                for(int i=1;i<=originalArrayLength;i++){userArray[i-1] = i;}
                break;
            } catch (NumberFormatException e){ 
                System.out.println("Please enter a valid integer value.");
            } catch(NegativeArraySizeException e){
                System.out.println("Please print a valid integer value.");
            }
        }
        printArray(userArray);
        System.out.println();
        

        //This code segment is meant to ask the user if they wish for the console to repeat request prompts, array changes, or array lengths.
        int userSettings = 0;
        boolean printRequestPrompt = false;
        boolean arrayDisplaySetting = false;
        boolean displayArrayLength = false;
        while(userSettings!=3){
            userSettings = 0;
            System.out.print("Continuously be asked to enter a number/exit program? Y/N: ");
                String choice1 = input.nextLine();
                if(choice1.toLowerCase().equals("y")){
                    printRequestPrompt = true;
                    userSettings++;
                }
                else if(choice1.toLowerCase().equals("n")) userSettings++;
            System.out.print("Continuously display the new array when making changes? Y/N: ");
                String choice2 = input.nextLine();
                if(choice2.toLowerCase().equals("y")){
                    arrayDisplaySetting = true;
                    userSettings++;
                }
                else if(choice2.toLowerCase().equals("n")) userSettings++;
            System.out.print("Display the length of the array after every change? Y/N: ");
                String choice3 = input.nextLine();
                if(choice3.toLowerCase().equals("y")){
                    displayArrayLength = true;
                    userSettings++;
                }
                else if(choice3.toLowerCase().equals("n")) userSettings++;
            if(userSettings!=3) System.out.println("Please enter valid commands.");
        }
        System.out.println("Settings adjusted.\n");


        //This code segment is meant to continuously ask the user for numbers they wish to add to the preexisting array until they type "exit".
        boolean firstIteration = true;
        System.out.print("Enter a number to add to the array or \"exit\" to exit program: ");
        String userInput = "";
        while(!userInput.toLowerCase().equals("exit")){
            if(!firstIteration && printRequestPrompt) System.out.print("Enter a number to add to the array or \"exit\" to exit program: ");
            userInput = input.nextLine();
            try {
                userArray = addToArray(userArray, Integer.parseInt(userInput));
                if(arrayDisplaySetting)printArray(userArray);
                if(displayArrayLength) System.out.println("Array Length: " + userArray.length);
            } catch (NumberFormatException e){      //if the value they enter is neither an integer or "exit", restart the loop.
                if(!userInput.toLowerCase().equals("exit"))System.out.println("Please enter a valid command.");
            } 
            if(firstIteration) firstIteration = false;
        }
        //If displayed array is the same array but with added numbers, postulate 4 is satisfied.
        System.out.print("\nFinal array: ");
        printArray(userArray);
        System.out.println("Final array length: " + userArray.length);
        System.out.println("You increased your array by " + (userArray.length-originalArrayLength) + " places.");
    }

    
    /*  This method will create a new array with the user's num added to the original array.
     *  Satisfies postulate 3.
     *  @param  Preexisting array
     *  @param  number to be added to that array
     *  @return Array with that desired number added
     */
    static int[] addToArray(int[] arr, int newNum){
        int[] result = new int[arr.length + 1];
        for(int i=0;i<arr.length;i++){
            result[i] = arr[i];
        }
        result[result.length-1] = newNum;
        return result;
    }

    /*
     * This method cycles through every index of an array and prints it in the console.
     * @param array who's value we wish to print
     */
    static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1) System.out.println(arr[i] + ".");
            else System.out.print(arr[i] + ", ");
        }
    }
}