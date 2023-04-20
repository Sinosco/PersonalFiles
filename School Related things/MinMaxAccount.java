public class MinMaxAccount extends BankingAccount
{
    private int min;
    private int max;

    public MinMaxAccount(Startup s){
        super(s);
        min = getBalance();
        max = getBalance();
    }

    public void debit(Debit d){
        super.debit(d);
        updateStats();
    }

    public void credit(Credit c){
        super.credit(c);
        updateStats();
    }

    public void updateStats(){
        min = getBalance()<min ? getBalance() : min;
        max = getBalance()>max ? getBalance() : max;
    }

    public int getMin(){
        return min;
    }
    public int getMax(){
        return max;
    }
}