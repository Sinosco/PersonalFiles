
import java.util.*;

public class trashFile{
    public static void main(String[] args){

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for(int i=1;i<=10;i++){
            list2.add(i);
        }
        for(int i=0;i<list2.size();i++){
            if(list2.get(i)==3 || list2.get(i)==4)
                list2.remove(i);
            System.out.println(list2);
        }
        System.out.println(list2);
    }
}

















