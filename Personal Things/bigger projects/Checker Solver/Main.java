import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    static Scanner input = new Scanner(System.in);
    static Checkers[][] board = Checkers.initializeCheckersBoard();
    static HashMap<Checkers,ArrayList<Checkers>> potentialMoves = new HashMap<>();

    public static void main(String[] args) {
        potentialMoves = Checkers.initializePossibleMovesList(board);
        // System.out.println(potentialMoves);
        boolean playersTurn = true;
        String sidesTurn;
        
        while(!isGameOver()){
            displayBoard();
            sidesTurn = playersTurn ? "Player" : "Opponent";
            boolean madeMove = false;
            while(!madeMove){
                System.out.println(sidesTurn);
                boolean isValidPlay = true;
                Checkers curPiece = new Checkers(), targetPiece = new Checkers();
                String userInput;

                System.out.println("It is the " + sidesTurn + "'s turn, what piece would you like to move? Xx format");
                userInput = input.nextLine();
                char userCoord1 = userInput.charAt(0);
                char userCoord2 = userInput.charAt(1);

                /* Why tf did you think it was a good idea to make the coordinates start from the top left???
                 * Why is xCoord = the SECOND coord the user gives??
                 */
                if(isValidCoords(userCoord1) && isValidCoords(userCoord2)){
                    int xCoord = Character.isLowerCase(userCoord2) ? coordToNum(userCoord2) : coordToNum(userCoord1);
                    int yCoord = Character.isUpperCase(userCoord1) ? coordToNum(userCoord1) : coordToNum(userCoord2);
                    curPiece = board[xCoord][yCoord];
                }    
                else isValidPlay = false;

                System.out.println("isValidPlay: " + isValidPlay); //DEBUGGING
                if(isValidPlay && curPiece.getColor().equals(sidesTurn)){
                    System.out.println("Where would you like to move it? Xx format");
                    userInput = input.nextLine();
                    try{
                    char targetCoord1 = userInput.charAt(0);
                    char targetCoord2 = userInput.charAt(1);
                    if(isValidCoords(targetCoord1) && isValidCoords(targetCoord2)){
                        int txCoord = Character.isLowerCase(targetCoord2) ? coordToNum(targetCoord2) : coordToNum(targetCoord1);
                        int tyCoord = Character.isUpperCase(targetCoord1) ? coordToNum(targetCoord1) : coordToNum(targetCoord2);
                        targetPiece = board[txCoord][tyCoord];
                    }
                    else isValidPlay = false;
                    } catch (StringIndexOutOfBoundsException e){
                        isValidPlay = false;
                    }

                    // if(isValidPlay /*&& !potentialMoves.get(curPiece).contains(targetPiece)*/)
                    //     System.out.println("Invalid Move.");
                }
                else if(!isValidPlay){
                    System.out.println("Enter valid coordinates.");
                }
                else System.out.println("Please tamper with your own pieces!");

                if(isValidPlay /*&& potentialMoves.get(curPiece).contains(targetPiece)*/){
                    makeMove(curPiece, targetPiece);
                    madeMove = true;
                }
            }
            playersTurn = !playersTurn;
        }

        System.out.println("Game is over!");
    }

    public static void displayBoard(){
        String alphabet = "abcdefgh";
        for(int i=0;i<board.length;i++){
            System.out.print(alphabet.substring(i,i+1)+ " ");
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j].getColorDisplay());
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }

    // what the hell was this. Figure out if this is still useful
    // public static void printMap(Map<Checkers, ArrayList<Checkers>> map){
    //     for(Map.Entry<Checkers, ArrayList<Checkers>> key : map.entrySet()){
    //         System.out.println(key.getKey() + " : " key.getValue());
    //     }
    // }
    
    /* 
     * Checks to see if the game is over by counting how many player and opponent pieces are left
     * if either side has zero pieces left then the game is done
     */
    public static boolean isGameOver(){
        int playerCounter = 0;
        int oppCounter = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j].getColor().equals("Player"))
                    playerCounter++;
                if(board[i][j].getColor().equals("Opponent"))
                    oppCounter++;
            }
        }
        
        return playerCounter==0 || oppCounter==0;
    }

    // Takes in a SINGLE string coordinate and converts it into its numeric equivalance
    public static int coordToNum(char coord){
        String upAlpha = "ABCDEFGH";
        String lowAlpha = "abcdefgh";
        if(upAlpha.contains("" + coord)) return upAlpha.indexOf(coord);
        else if(lowAlpha.contains("" + coord)) return lowAlpha.indexOf(coord);
        else return -1;
    }

    // Checks if the coordinates the user puts in are valid or not
    public static boolean isValidCoords(char coord){
        String upAlpha = "ABCDEFGH";
        String lowAlpha = "abcdefgh";
        return upAlpha.contains("" + coord) || lowAlpha.contains("" + coord);
    }

    public static void makeMove(Checkers piece, Checkers target){
        int pPos1 = piece.getCoords1();
        int pPos2 = piece.getCoords2();
        int tPos1 = target.getCoords1();
        int tPos2 = target.getCoords2();

        board[tPos1][tPos2].setColor(piece.getColor());
        board[pPos1][pPos2].setColor("empty");
    }

    public static void makeMove(Checkers piece, Checkers target, Checkers sacrifice){
        int pPos1 = piece.getCoords1();
        int pPos2 = piece.getCoords2();
        int tPos1 = target.getCoords1();
        int tPos2 = target.getCoords2();
        int sPos1 = sacrifice.getCoords1();
        int sPos2 = sacrifice.getCoords2();

        board[tPos1][tPos2].setColor(piece.getColor());
        board[pPos1][pPos2].setColor("empty");
        board[sPos1][sPos2].setColor("empty");
        
    }
}
