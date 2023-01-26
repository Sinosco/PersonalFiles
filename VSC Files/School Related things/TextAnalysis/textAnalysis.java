import java.util.*;

public class textAnalysis{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Copy paste your text here: ");
        String userText = input.nextLine();

        // Sentences, words, number of long words, number of long sentences, avg sentence length, avg word length?, quotes, length of quotes, average time to read that text
        // arraylist of words in the paragraph, sort them, then count how many words pop up again and by how many.
        int sentenceCount = 0;
        int wordCount = 0;
        ArrayList<Integer> sentenceLengths = new ArrayList<Integer>();

        //use Character.isLetter(); function
        for(int i=1;i<userText.length();i++){
            char curLetter = userText.charAt(i);
            if((curLetter == '.' || curLetter == '!' || curLetter == '?') && Character.isLetter(userText.charAt(i-1))){
                sentenceCount++;
                wordCount++;
            }
            else if(!Character.isLetter(curLetter) && Character.isLetter(userText.charAt(i-1))) wordCount++;
        }

        System.out.println("\nNumber of Sentences: " + sentenceCount);
        System.out.println("Number of words: " + wordCount);
        // System.out.println("Average Length of Sentences: "); // Sum all values in sentenceLengths<> and divide by length of arrayList
    }

    public void isWord(String potential){
        int wordLength = 0;
        for(int i=0;i<potential.length();i++){
            if(potential.charAt(i) == ' '){
                for(int j=i;j<potential.length();j++){
                    if(potential.charAt(j)!=' ') wordLength++;
                }
            }
        }
    }

    //may be better to take the strings and split it up into words.
    // The big brown fox. => ["The", "big", "brown", "fox."]
    public ArrayList<String> convertToArrayList(String text){
        ArrayList<String> result = new ArrayList<String>();
        int prevWordIndex = 0;

        for(int i=1;i<text.length();i++){
            char curLetter = text.charAt(i);
            if((curLetter == '.' || curLetter == '!' || curLetter == '?') && text.charAt(i-1)!='.'){
                result.add(text.substring(prevWordIndex, i));
                prevWordIndex = i+2;
            }
            else if(curLetter == ' ' && Character.isLetter(text.charAt(i-1))){
                result.add(text.substring(prevWordIndex, i));
                prevWordIndex = i+2;
            }

        }
        return result;
    }

    public void printArrayList(ArrayList<String> array){
        for(int i=0;i<array.size();i++){
            if(i!=array.size()-1)System.out.print(array.get(i) + " : ");
        }
        System.out.println(array.get(array.size()-1) + ".");
    }
}

// Texual anomalies
// ...
// !!
// 