import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        SuddokuMethods game = new SuddokuMethods();
        SuddokuMethods validBoard = new SuddokuMethods();

        while(true){
            game.makeBoard();
            System.out.println("Enter the coordinates you'd like to play on and value you'd like to play (Ex: eF6): ");
            String coords = input.nextLine();
            game.userMove(coords);

            if(game.checkBoard())
                validBoard.setBoard(game.getBoard());
            else{
                game.setBoard(validBoard.getBoard());
                System.out.println("\n**There is an error on your board! Please identify and fix it!");
            }
        }
    }

}
