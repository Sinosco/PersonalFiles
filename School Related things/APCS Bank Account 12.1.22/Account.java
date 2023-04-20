import java.text.NumberFormat;

public class Account{
    private double balance;
    private String name;
    private long acctNum;

    public Account (double initBal, String owner, long number){
        balance = initBal;
        name = owner;
        acctNum = number;
    }

    public void withdraw(double amount){
        if(balance>=amount)
            balance -= amount;
        else
            System.out.println("Insufficient funds");    
    }

    public void deposit(double amount){
        balance += amount;
    }

    public double getBalance(){
        return balance;
    }

    public String toString(){
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return name + "\t" + acctNum + "\t" + fmt.format(balance);
    }

    public double chargeFee(){
        balance -=10;
        return balance;
    }

    public void changeName(String newName){
        name = newName;
    }
}