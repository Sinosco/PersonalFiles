import java.util.*;

// derivative, power, and denomonial factorial are all the same degree of power.
// e = 2.71828
public class taylorSeries{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int max = 1;
        while(max>0){
        System.out.print("Enter how accurate you want your approximation to be of e^x(0-65): ");
        max = input.nextInt();
        System.out.print("Enter the x value of e^x you would like to approximate: ");
        int userXvalue = input.nextInt();
        double result = 0;

        for(int i=0;i<=max;i++){
            result += Math.pow(userXvalue, i) / factorial(i);
        }
        System.out.println("My approximation of e^x at x-value: " + userXvalue + " is " + result);}
    }

    public static long factorial(int x){
        long result = 1;
        for(int i=1;i<=x;i++)
            result *= i;
        return result;
    }

    public static String derivative(String trigFunc){
        return "place holder text just to get rid of this stupid red underline";
    }
    public static String derivative(String variable, int power){
        return "another placeholder text I manually typed out because I hate red underlined text";
    }
}