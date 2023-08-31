import java.util.Scanner;

public class SpitOutChange{
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        double itemCost = Integer.MAX_VALUE, moneyFed = Integer.MIN_VALUE;

        //Makes sure the user inputs valid prices that can be manipulated
        while(moneyFed<itemCost){
            try{
                System.out.println("Enter the price of the item you are buying in xx.xx format.");
                itemCost = input.nextInt();
                System.out.println("Enter the amount of money you are paying in xx.xx format.");
                moneyFed = input.nextInt();
            } catch(NumberFormatException e){
                System.out.println("Please enter a valid integer number in format xx.xx, for example, 2.35.");
            }
            
            if(moneyFed<itemCost) System.out.println("Broke ahh can't afford a drink.");

            if(!Double.toString(moneyFed).contains(".") || !Double.toString(itemCost).contains(".")){
                itemCost = Integer.MAX_VALUE;
                moneyFed = Integer.MIN_VALUE;
                System.out.println("Please input numbers in the format of xx.xx, example: 2.52");
            }
        }
        

        int change = (int)((moneyFed-itemCost) * 100);
        int dollars, quarters, dimes, nickels, pennies;
        
        dollars = change/100;
        change %= 100;
        quarters = change/25;
        change %= 25;
        dimes = change/10;
        change %= 10;
        nickels = change/5;
        change %= 5;
        pennies = change;

        //Prints out the details of your change.
        System.out.println("Your change is " + change + ", you will be given " + dollars + " dollar(s), " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, and " + pennies + " pennies.");
    }
}