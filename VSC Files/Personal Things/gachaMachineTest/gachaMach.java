import java.util.*;

public class gachaMach{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter how many rolls you'd like to play: ");
        int userRolls = input.nextInt();
        String[] userRewards = new String[userRolls];

        for(int i=0;i<userRolls;i++){
            int outcome = (int)(Math.random()*100+1);
            if      (outcome<=5)    userRewards[i] = "legendary";
            else if (outcome<=15)   userRewards[i] = "epic";
            else if (outcome<=40)   userRewards[i] = "rare";
            else                    userRewards[i] = "common";
        }   //Common:60%  Rare:25%  Epic:10%  Legendary:5%
        printRolls(userRewards);
    }

    public static void printRolls(String[] userDrops){
        for(int i=0;i<userDrops.length;i++){
            System.out.print(userDrops[i] + ", ");
        }
        System.out.print(".");
    }
}
