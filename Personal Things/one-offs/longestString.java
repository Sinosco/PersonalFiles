public class longestString {
    public String str;

    public longestString(String str){
        this.str = str;
    }

    public String longe(){
        if(str.length()<=1){
            return str;
        }
        String result = "";
        String curLongest = "";
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)==str.charAt(i+1))
                curLongest+=str.substring(i,i+1);
            else{
                curLongest+=str.substring(i,i+1);
                result = curLongest.length()>=result.length() ? curLongest : result;
                curLongest = "";
            }
        }
        if(str.charAt(str.length()-1)==str.charAt(str.length()-2)) curLongest += curLongest.substring(0,1);
        return result.length()>curLongest.length() ? result : curLongest;
    }

    public String longe2(){
        int finIndex1=0; int finIndex2=1; int tempIndex1; int tempIndex2;
        if(str.length()<=1) return str;
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                tempIndex1 = i;
                for(int j=i+1;j<str.length();j++){
                    if(str.charAt(j)!=str.charAt(tempIndex1)){
                        tempIndex2 = j;
                        if(tempIndex2-tempIndex1>=finIndex2-finIndex1){
                            finIndex1 = tempIndex1;
                            finIndex2 = tempIndex2;
                        }
                        i=j;
                        break;
                    }
                }
            }
        }
        return str.substring(finIndex1, finIndex2);
    }
}
