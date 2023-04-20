import java.text.NumberFormat;
public class ManageAccounts {
    public static void main(String[] args){
        String str = "AxyzBB";
        int prevCount = 0;
        int postCount = 0;
        boolean pastX = false;
        boolean pastZ = false;
        int midStartIndex = str.length()%2==1 ? str.length()/2-1 : str.length()/2-2;
        boolean containsxyz = false;
      
        for(int i=0;i<str.length();i++){
          if(i<str.length()-2 && str.substring(i,i+3).equals("xyz")) containsxyz = true;
          if(str.substring(i,i+1).equals("x") && i==midStartIndex) pastX = true;
          if(pastX && pastZ) postCount++;
          if(str.substring(i,i+1).equals("z") && i>midStartIndex) pastZ = true;
          if(!pastX) prevCount++;
        }
        System.out.println(midStartIndex);
        System.out.println(pastX);
        System.out.println(prevCount + " " + postCount);

        System.out.println(containsxyz && Math.abs(postCount-prevCount)<=1);
        
      
        /*Account acct1, acct2;
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        acct1 = new Account(1000, "Sally", 1111);
        acct2 = new Account(500, "Joe", 1112);

        double joesBalance = acct2.getBalance();
        System.out.println("Joe's balance is: " + fmt.format(joesBalance));

        acct1.withdraw(50);
        double sallysBalance = acct1.getBalance();
        System.out.println("Sally's balance is: " + "$" + fmt.format(sallysBalance));

        acct1.chargeFee();
        acct2.chargeFee();

        acct2.changeName("Joseph");

        System.out.println(acct1);
        System.out.println(acct2);
        */
    }
}
