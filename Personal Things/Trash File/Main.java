import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int counter = 100;
        while(true){
          Scanner input = new Scanner(System.in);
          int n = input.nextInt();
          int originalNum = n;
          while(n>0 || counter>0){
            n%=10;
            if(n!=0 && originalNum%n != 0) System.out.println(false);
            n = originalNum/10;
            System.out.println(n + "\t\t\t" + (n>0) + "\t\t\t" + counter + "\t\t\t" + (counter>0));
            counter--;
          }
          System.out.println(true);
      }
    }
}

