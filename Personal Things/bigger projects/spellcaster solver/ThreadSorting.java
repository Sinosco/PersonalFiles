/*
 * OUT OF USE, NO LONGER USEFUL
 * 
 * ORIGINALLY MEANT TO SPEED UP HOW FAST WE CAN CHECK THE ENTIRE LIST OF 
 * DICTIONARY BY GOING FROM BACK TO MID AND END TO MID AT THE SAME TIME.
 * REPLACED BY TRIE DATA STRUCTURE
 */


import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class ThreadSorting extends Thread{
    static HashSet<String> dictionary = HashSetUtil.importWordList("dictionary.txt");
    int begIndex, endIndex;
    String word;
    // private volatile static boolean containsWord = false;
    boolean containsWord = false;

    public ThreadSorting(int begIndex, int endIndex, String word){
        this.begIndex = begIndex;
        this.endIndex = endIndex;
        this.word = word;
    }

    @Override
    public void run(){
        List<String> list = new ArrayList<>(dictionary);
        for(int i=begIndex;i<endIndex;i++){
            // if(containsWord) break;
            if(list.get(i).indexOf(word)>=0){
                containsWord = true;
                break;
            }
        }
    }

    public boolean containsWord(){ 
        return containsWord; }
}
