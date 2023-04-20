import java.util.*;

public class speedReader {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the text you would like to spreed: " );
        String text = input.nextLine();
        System.out.println("\nEnter the speed at which you would like to read");
        int speed = input.nextInt();
        String[] words = listToArr(sumWords(text));

        for(int i=0;i<words.length;i++){
            System.out.println(words[i]);
            try{
                Thread.sleep((int)60000/speed);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

    }

    public static ArrayList<String> sumWords(String text){
        ArrayList<String> result = new ArrayList<String>();
        int spaceIndex = 0;
        for(int i=0;i<text.length();i++){
            char curLet = text.charAt(i);
            if(curLet == ' ' || curLet =='.' || curLet == '!' || curLet == '?'){
                result.add(text.substring(spaceIndex,i));
                spaceIndex = (curLet == ' ') ? i+1 : i+2;
            }
        }
        return result;
    }

    public static String[] listToArr(ArrayList<String> arrList){
        String[] result = new String[arrList.size()];
        for(int i=0;i<result.length;i++){
            result[i] = arrList.get(i);
        }
        return result;
    }

}
