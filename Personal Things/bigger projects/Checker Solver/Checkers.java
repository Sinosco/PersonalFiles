import java.util.ArrayList;
import java.util.HashMap;

public class Checkers{
    private boolean isKing;
    private int coords1;
    private int coords2;
    private String color;
    private static ArrayList<Checkers> tempPotMovesList = new ArrayList<>();

    //constructor taking in the numeric coordinates and the color or side of the piece
    public Checkers(int coords1, int coords2, String color){
        this.coords1 = coords1;
        this.coords2 = coords2;
        this.color = color;
        isKing = false;
    }

    public Checkers(){
        coords1 = -1;
        coords2 = -1;
        color = "literally impossible piece";
        isKing = false;
    }

    //getter setter methods because useful
    public int getCoords1(){ return coords1; }
    public void setCoords1(int c){ coords1 = c; }
    
    public int getCoords2(){ return coords2; }
    public void setCoords2(int c){ coords2 = c; }

    public boolean getIsKing(){ return isKing; }
    public void setIsKing(boolean b){ isKing = b; }

    public String getColor(){ return color; }
    public void setColor(String c){ color = c;}

    //returns what color to display on the board. Only used for terminal visuals.
    public String getColorDisplay(){ 
        String blackSquare = "  ";
        String whiteSquare = "  ";
        String opponentPiece = "X ";
        String playerPiece = "O ";
        if(color.equals("Opponent")) return opponentPiece;
        if(color.equals("Player")) return playerPiece;
        if(coords1%2==0 && coords2%2==0 || coords1%2==1 && coords2%2==1) return blackSquare;
        return whiteSquare;
    }

    @Override
    public String toString(){
        return color.toUpperCase() + "[" + toGrid(coords1, false) + toGrid(coords2, true) + "]";
    }

    /*
     * takes in an INTEGER coordinate and converts it to its alphabetical equivalence. 
     * Opposite of convertCoordToNum();
     */
    public String toGrid(int coord, boolean isUpperCase){
        String upperAlpha = "ABCDEFGH";
        String lowerAlpha = "abcdefghi";
        return isUpperCase ? upperAlpha.substring(coord, coord+1) : lowerAlpha.substring(coord, coord+1);
    }

    //Initializes the entire board with pieces
    public static Checkers[][] initializeCheckersBoard(){
        Checkers[][] board = new Checkers[8][8];
        for(int i=1;i<8;i+=2)board[0][i] = new Checkers(0, i, "Opponent");
        for(int i=0;i<8;i+=2) board[1][i] = new Checkers(1,i,"Opponent");
        for(int i=1;i<8;i+=2)board[2][i] = new Checkers(2, i, "Opponent");

        for(int i=0;i<8;i+=2) board[5][i] = new Checkers(5,i,"Player");
        for(int i=1;i<8;i+=2)board[6][i] = new Checkers(6, i, "Player");
        for(int i=0;i<8;i+=2) board[7][i] = new Checkers(7,i,"Player");
    
        for(int c=0;c<8;c++){
            for(int i=0;i<8;i++){
                if(board[c][i]==null) board[c][i] = new Checkers(c, i, "empty");
            }
        }

        return board;
    }

    /*
     * Finds all possible moves for all 3 game types: King, opp, and player
     * For kings, they can see in all directions regardless of side.
     * Opponent pieces can only look down while player pieces can only look up
     * 
     * For all 3 types it should add empty diagonal spaces as well as pieces that can be taken
     * and chain reaction takes (ie taking more than 1 piece in a turn)
     */
    public static void findPossibleMoves(Checkers[][] board, Checkers piece){
        int pos1 = piece.getCoords1();
        int pos2 = piece.getCoords2();

        int top = pos1-1;
        int bottom = pos1+1;
        int left = pos2-1;
        int right = pos2+1;

        Checkers targetPiece;
        if(piece.getIsKing()){
            if(top>=0 && left>=0){
                targetPiece = board[top][left];
                if(targetPiece.getColor().equals("empty")) 
                    tempPotMovesList.add(targetPiece);
                else if(canTakePiece(board, piece, targetPiece)){
                    targetPiece = board[top-1][left-1];
                    tempPotMovesList.add(targetPiece);
                    findPossibleMoves(board, targetPiece);
                }
            }

            else if(top>=0 && right<8){
                targetPiece = board[top][right];
                if(targetPiece.getColor().equals("empty"))
                    tempPotMovesList.add(targetPiece);
                else if(canTakePiece(board, piece, targetPiece)){
                    targetPiece = board[top-1][right+1];
                    tempPotMovesList.add(targetPiece);
                    findPossibleMoves(board, targetPiece);
                }
            }    

            else if(bottom<8 && left>=0){
                targetPiece = board[bottom][left];
                if(targetPiece.getColor().equals("empty"))
                    tempPotMovesList.add(targetPiece);
                else if(canTakePiece(board, piece, targetPiece)){
                    targetPiece = board[bottom+1][left-1];
                    tempPotMovesList.add(targetPiece);
                    findPossibleMoves(board, targetPiece);
                }
            }    

            else if(bottom<8 && right<8){
                targetPiece = board[bottom][right];
                if(targetPiece.getColor().equals("empty"))
                    tempPotMovesList.add(targetPiece);
                else if(canTakePiece(board, piece, targetPiece)){
                    targetPiece = board[bottom+1][right+1];
                    tempPotMovesList.add(targetPiece);
                    findPossibleMoves(board, targetPiece);
                }
            }
        }

        else if(piece.getColor().equals("X")){
            if(bottom<8 && left>=0){
                targetPiece = board[bottom][left];
                if(targetPiece.getColor().equals("empty"))
                    tempPotMovesList.add(targetPiece);
                else if(canTakePiece(board, piece, targetPiece)){
                    targetPiece = board[bottom+1][left-1];
                    tempPotMovesList.add(targetPiece);
                    findPossibleMoves(board, targetPiece);
                }
            }
            else if(bottom<8 && right<8){
                targetPiece = board[bottom][right];
                if(targetPiece.getColor().equals("empty"))
                    tempPotMovesList.add(targetPiece);
                else if(canTakePiece(board, piece, targetPiece)){
                    targetPiece = board[bottom+1][right+1];
                    tempPotMovesList.add(targetPiece);
                    findPossibleMoves(board, targetPiece);
                }
            }        
        }

        else{
            if(top>=0 && left>=0){
                targetPiece = board[top][left];
                if(targetPiece.getColor().equals("empty")) 
                    tempPotMovesList.add(targetPiece);
                else if(canTakePiece(board, piece, targetPiece)){
                    targetPiece = board[top-1][left-1];
                    tempPotMovesList.add(targetPiece);
                    findPossibleMoves(board, targetPiece);
                }
            }

            else if(top>=0 && right<8){
                targetPiece = board[top][right];
                if(targetPiece.getColor().equals("empty"))
                    tempPotMovesList.add(targetPiece);
                else if(canTakePiece(board, piece, targetPiece)){
                    targetPiece = board[top-1][right+1];
                    tempPotMovesList.add(targetPiece);
                    findPossibleMoves(board, targetPiece);
                }
            }    
        }

    }

    public static void findPossibleTakes(Checkers[][] board, Checkers piece){
        int pos1 = piece.getCoords1();
        int pos2 = piece.getCoords2();

        int top = pos1-1;
        int bottom = pos1+1;
        int left = pos2-1;
        int right = pos2+1;

        Checkers targetPiece;
        if(piece.getIsKing()){
            if(top>=0 && left>=0){
                targetPiece = board[top][left];
                if(canTakePiece(board, piece, targetPiece)) 
                    tempPotMovesList.add(targetPiece);
                else if(canTakePiece(board, piece, targetPiece)){
                    targetPiece = board[top-1][left-1];
                    tempPotMovesList.add(targetPiece);
                    findPossibleMoves(board, targetPiece);
                }
            }

            else if(top>=0 && right<8){
                targetPiece = board[top][right];
                if(targetPiece.getColor().equals("empty"))
                    tempPotMovesList.add(targetPiece);
                else if(canTakePiece(board, piece, targetPiece)){
                    targetPiece = board[top-1][right+1];
                    tempPotMovesList.add(targetPiece);
                    findPossibleMoves(board, targetPiece);
                }
            }    

            else if(bottom<8 && left>=0){
                targetPiece = board[bottom][left];
                if(targetPiece.getColor().equals("empty"))
                    tempPotMovesList.add(targetPiece);
                else if(canTakePiece(board, piece, targetPiece)){
                    targetPiece = board[bottom+1][left-1];
                    tempPotMovesList.add(targetPiece);
                    findPossibleMoves(board, targetPiece);
                }
            }    

            else if(bottom<8 && right<8){
                targetPiece = board[bottom][right];
                if(targetPiece.getColor().equals("empty"))
                    tempPotMovesList.add(targetPiece);
                else if(canTakePiece(board, piece, targetPiece)){
                    targetPiece = board[bottom+1][right+1];
                    tempPotMovesList.add(targetPiece);
                    findPossibleMoves(board, targetPiece);
                }
            }
        }

        else if(piece.getColor().equals("X")){
            if(bottom<8 && left>=0){
                targetPiece = board[bottom][left];
                if(targetPiece.getColor().equals("empty"))
                    tempPotMovesList.add(targetPiece);
                else if(canTakePiece(board, piece, targetPiece)){
                    targetPiece = board[bottom+1][left-1];
                    tempPotMovesList.add(targetPiece);
                    findPossibleMoves(board, targetPiece);
                }
            }
            else if(bottom<8 && right<8){
                targetPiece = board[bottom][right];
                if(targetPiece.getColor().equals("empty"))
                    tempPotMovesList.add(targetPiece);
                else if(canTakePiece(board, piece, targetPiece)){
                    targetPiece = board[bottom+1][right+1];
                    tempPotMovesList.add(targetPiece);
                    findPossibleMoves(board, targetPiece);
                }
            }        
        }

        else{
            if(top>=0 && left>=0){
                targetPiece = board[top][left];
                if(targetPiece.getColor().equals("empty")) 
                    tempPotMovesList.add(targetPiece);
                else if(canTakePiece(board, piece, targetPiece)){
                    targetPiece = board[top-1][left-1];
                    tempPotMovesList.add(targetPiece);
                    findPossibleMoves(board, targetPiece);
                }
            }

            else if(top>=0 && right<8){
                targetPiece = board[top][right];
                if(targetPiece.getColor().equals("empty"))
                    tempPotMovesList.add(targetPiece);
                else if(canTakePiece(board, piece, targetPiece)){
                    targetPiece = board[top-1][right+1];
                    tempPotMovesList.add(targetPiece);
                    findPossibleMoves(board, targetPiece);
                }
            }    
        }

    }


    public static boolean canTakePiece(Checkers[][] board, Checkers piece, Checkers target){
        if(target.getColor().equals(piece.getColor())) return false;
        
        int curPiecePos1 = piece.getCoords1();
        int curPiecePos2 = piece.getCoords2();
        int tarPiecePos1 = target.getCoords1();
        int tarPiecePos2 = target.getCoords2();

        int colDiff = tarPiecePos2 - curPiecePos2;
        int rowDiff = tarPiecePos1 - curPiecePos1;

        //For each direction, check if the next space over is empty, thus being able to be taken.
        //top left
        if(colDiff<0 && rowDiff<0 && tarPiecePos1-1>=0 && tarPiecePos2-1>=0){
            return board[tarPiecePos1-1][tarPiecePos1-1].getColor().equals("empty") ? true : false;
        }
        //top right
        if(colDiff>0 && rowDiff<0 && tarPiecePos1+1<8 && tarPiecePos2-1>=0){
            return board[tarPiecePos1+1][tarPiecePos1-1].getColor().equals("empty") ? true : false;
        }
        //bottom left
        if(colDiff<0 && rowDiff>0 && tarPiecePos1-1>=0 && tarPiecePos2+1<8){
            return board[tarPiecePos1-1][tarPiecePos1+1].getColor().equals("empty") ? true : false;
        }
        //bottom right
        if(colDiff>0 && rowDiff>0 && tarPiecePos1+1<8 && tarPiecePos2+1<8){
            return board[tarPiecePos1+1][tarPiecePos1+1].getColor().equals("empty") ? true : false;
        }
        return false;
    }

    public static HashMap<Checkers, ArrayList<Checkers>> initializePossibleMovesList(Checkers[][] board){
        HashMap<Checkers,ArrayList<Checkers>> list = new HashMap<>();
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board.length;col++){
                Checkers curPiece = board[row][col];
                if(!curPiece.getColor().equals("empty"))
                    findPossibleMoves(board, curPiece);
                    // System.out.println(tempPotMovesList);
                    list.put(curPiece, tempPotMovesList);
                    tempPotMovesList.clear();
            }
        }
        return list;
    }
    
    public static Checkers[] convertArrayListToList(ArrayList<Checkers> list){
        Checkers[] result = new Checkers[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

}
..








