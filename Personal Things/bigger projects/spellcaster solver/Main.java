import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;

public class Main{
    static Scanner input = new Scanner(System.in);
    static String[][] board;
    static boolean[][] states = new boolean[5][5];
    static Map<Coordinates, ArrayList<Coordinates>> masterMap = new HashMap<Coordinates, ArrayList<Coordinates>>();
    static HashSet<String> dictionary = HashSetUtil.importWordList("dictionary.txt"); 
    static ArrayList<String> foundWords = new ArrayList<String>();
    static Trie structure = initializeTrie(dictionary);
    public static void main(String[] args){
        String userInput = "";
        HashSet<String> replacement = dictionary;

        while(!userInput.toLowerCase().equals("exit")){
            dictionary = replacement;
            board = initializeBoard();
            long startTime = System.currentTimeMillis();
            displayBoard(board);
            initializeHashMap();
            discoverWords();
            sortWordList(foundWords);
            System.out.println(foundWords + "\n");
            long endTime = System.currentTimeMillis();
            System.out.println("Time: " + (endTime-startTime));
            System.out.println("find words with swaps enabled?");
            userInput = input.nextLine();
            if(userInput.equals("yes")){
                
                System.out.println("Swapped words list: " + sortWordList(discoverSwapWords(foundWords)) + "\n");
            }
            foundWords.clear();
            masterMap.clear();
        }
        
    }

    public static String[][] initializeBoard(){
        System.out.println("Enter all the characters: ");
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String text = "";
        String conditionalStatement = "";

        while(!conditionalStatement.equals("EXITWHILELOOP")){
            text = input.nextLine().toUpperCase();
            for(int i=0;i<text.length();i++){
                if(alphabet.indexOf(text.substring(i,i+1))<0){
                    System.out.println("Please enter valid characters.");
                    break;
                }
                if(text.length()<25){
                    System.out.println("Please enter 25 characters");
                    break;
                }
                if(i==text.length()-1) conditionalStatement="EXITWHILELOOP";
            }
        }
        return convertStringToGrid(text.toUpperCase());
    } 
    public static String[][] convertStringToGrid(String text){
        String[][] result = new String[5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                result[i][j] = text.substring(i*5+j, i*5+j+1);
            }
        }
        return result;
    }

    public static void displayBoard(String[][] grid){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * as the name implies, it creates a hashmap given the grid of letters. It stores every
     * cell or block in the grid as a key and every adjacent block in an arraylist. They are 
     * all stored as Coordinate objects with contains their grid index values and their string
     * value.
     */
    public static void initializeHashMap(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                ArrayList<Coordinates> adjacents = new ArrayList<>();
                for(int ii=i-1;ii<i+2;ii++){
                    for(int jj=j-1;jj<j+2;jj++){
                        if(ii>=0 && ii<5 && jj>=0 && jj<5 && !(i==ii && j==jj))
                            adjacents.add(new Coordinates(ii,jj,board));
                    }
                }
                masterMap.put(new Coordinates(i,j, board), adjacents);
            }
        }
    }

    /**
     * Sorts the foundWords arraylist in terms of longest to shortest and allegedly
     * highest lexigraphical value word to lowest.
     * @param list
     */
    public static ArrayList<String> sortWordList(ArrayList<String> list){
        for(int i=0;i<list.size();i++){
            int j=i-1;
            while(j>=0 && list.get(j).length()<list.get(j+1).length()){
                list.add(j, list.remove(j+1));
                j--;
            }
        }
        for(int i=1;i<list.size();i++){
            int j=i-1;
            while(j>=0 && list.get(j).compareTo(list.get(j+1))<0 && list.get(j+1).length()==list.get(j).length()){
                list.add(j, list.remove(j+1));
                j--;
            }
        }
        return list;
    }

    /**
     * Checks to see if that beginning of word exists in a Trie data structure, or
     * more basically exists in the dictionary.
     * @param test
     * @return 
     */
    public static boolean wordBeginningExist(String test){
        return structure.search(test);

    }

    //The foundations of misery 5/13/11:15
    /**
     * Cycles through every word and performs the recursive function iterationHell().
     * Before it performs it it sets the block's state value to true to prevent reusing
     * the first letter. Resets it after method is complete.
     */
    public static void discoverWords(){
        for(Coordinates set : masterMap.keySet()){
            states[set.getCoords1()][set.getCoords2()] = true;
            ArrayList<Coordinates> adjacents = masterMap.get(set); //cgpt code
            iterationHell(adjacents, set.getValueCoords());
            states[set.getCoords1()][set.getCoords2()] = false;
        }
    }

    /**
     * recursively goes through the hashmap masterMap and adds every word found in 
     * dictionary. If a word is not found in the dictionary and it's prefix does not
     * exist then cancel that recursion and try again with the previous block.
     * 
     */
    public static void iterationHell(ArrayList<Coordinates> list, String word){
        if(dictionary.contains(word)){
            System.out.println("Found a word!" + word + "\n");
            foundWords.add(word);
            System.out.println("\t" + foundWords);
            dictionary.remove(word);
        }
        if(!wordBeginningExist(word)) return;

        for(Coordinates coords : list){
            boolean state = states[coords.getCoords1()][coords.getCoords2()];
            if(!state){
                states[coords.getCoords1()][coords.getCoords2()]=true;
                iterationHell(masterMap.get(coords), word+coords.getValueCoords());
                states[coords.getCoords1()][coords.getCoords2()]=false;
            }
        }
    }

    public static Trie initializeTrie(HashSet<String> dict){
        Trie result = new Trie();
        for(String word : dict){
            result.insert(word);
        }
        return result;
    }

    public static ArrayList<String> discoverSwapWords(ArrayList<String> wordList){
        ArrayList<String> result = new ArrayList<>();
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(String word : wordList){
            for(int index=0;index<word.length();index++){
                for(int alphabet=0; alphabet<26; alphabet++){
                    String newWord = word.substring(0, index) + letters.substring(alphabet, alphabet+1) + word.substring(index+1);
                    if(dictionary.contains(newWord)){
                        result.add(newWord + "[" + index +"]");
                    }
                }
            }
        }
        return result;
    }

}

/*
 * Code graveyard
 * 
 * WordBeginningExists multithreading code:
 *      int points = dictionary.size()/4; //4 can be any number of threads n
        ThreadSorting[] list = new ThreadSorting[4];
        for(int i=0;i<4;i++){
            ThreadSorting thread = new ThreadSorting(points*i, points*(i+1), test);
            thread.start();
            list[i] = thread;
        }
        
        for(int i=0;i<4;i++){
            list[i].join();
            if(list[i].containsWord()) return true;
        }
        return false;
 */