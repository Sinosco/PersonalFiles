
public class SuddokuMethods {
    private char[][] userBoard;
    private final char[][] baseBoard = {
        {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'},
        {'a','-','-','-','-','-','-','-','-','-'},
        {'b','-','-','-','-','-','-','-','-','-'},
        {'c','-','-','-','-','-','-','-','-','-'},
        {'d','-','-','-','-','-','-','-','-','-'},
        {'e','-','-','-','-','-','-','-','-','-'},
        {'f','-','-','-','-','-','-','-','-','-'},
        {'g','-','-','-','-','-','-','-','-','-'},
        {'h','-','-','-','-','-','-','-','-','-'},
        {'i','-','-','-','-','-','-','-','-','-'}};

    public SuddokuMethods(){
        userBoard = baseBoard;
    }

    public void setBoard(char[][] board){ // may not be properly working
        for(int i=1; i<userBoard.length;i++){
            for(int j=1; j<userBoard[i].length;j++){
                    userBoard[i][j] = board[i][j];
            }
        }
    }
    
    public char[][] getBoard(){
        return userBoard;
    }

    public void makeBoard(){
        for(int i=0;i<baseBoard.length;i++){
            if((i-1)%3==0)System.out.println();
            for(int j=0;j<baseBoard[i].length;j++){
                if((j-1)%3==0) System.out.print("  ");
                System.out.print(baseBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean checkRows(){ 
        for(int i=1; i<userBoard.length;i++){
            for(int j=1; j<userBoard[i].length;j++){
                for(int k=1; k<userBoard[j].length;k++){
                    if(j!=k && userBoard[i][j] != '-' && userBoard[i][j] == userBoard[i][k]) return false;
                }
            }
        }
        return true;
    }

    public boolean checkColumns(){ 
        for(int i=1; i<userBoard.length;i++){
            for(int j=1; j<userBoard[i].length;j++){
                for(int k=1; k<userBoard[j].length;k++){
                    if(j!=k && userBoard[j][i] != '-' && userBoard[j][i] == userBoard[k][i]) return false;
                }
            }
        }
        return true;
    }

    public boolean checkGrids(){
        for(int grid=1; grid<10; grid++){
            for(int intRowPos=1;intRowPos<=3;intRowPos++){
                for(int curColPos=1; curColPos<=3;curColPos++){
                    
                }
            }
        }
        return true;
    }

    public boolean checkBoard(){
        return this.checkRows() && this.checkColumns();
    }
    
    public void userMove(String userInput){
        int[] coords = stringToChar(userInput);
        userBoard[coords[0]][coords[1]] = userInput.charAt(2);
    }

    //specify in Main that the coords are valid.
    public static int[] stringToChar(String coords){
        char userRow = coords.charAt(0);
        char userColumn = coords.charAt(1);
        int[] result = {userRow-96, userColumn-64};
        return result;
    }

    public void removeNum(String userInput){

    }


    //Required:
        // Recognizing invalid grids
        // Creating inital valid numbers on the board
        // deleting numbers if the inital board is invalid
        // Optional: Algorithm to solve the sudoku board
}
/*
    A B C   D E F   G H I 

a   1 2 3   4 5 6   7 8 9
b   2 - -   - - -   - - -
c   3 - -   - - -   - - -

d   4 - -   - - -   - - -
e   5 - -   - - -   - - -
f   6 - -   - - -   - - -

g   7 - -   - - -   - - -
h   8 - -   - - -   - - -
i   9 - -   - - -   - - -

 */