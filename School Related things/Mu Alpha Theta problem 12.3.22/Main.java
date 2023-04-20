import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many iterations to go through: ");
        int max = input.nextInt();
        int counter = 0;
        double[] maxValue = new double[8];

        while(counter<max){
            ArrayList<Double> variables = new ArrayList<Double>();
            while(variables.size()<8){
                double num = (double)(int)(Math.random()*10);
                boolean containsNum = false;
                for(int i=0;i<variables.size();i++){
                    if(variables.get(i)==num){
                        containsNum = true;
                    }
                }
                if(!containsNum) variables.add(num);
            }

            
            double fEquation = (variables.get(0)*10 + variables.get(1))/(variables.get(2)-variables.get(3));
            double sEquation = variables.get(4)+variables.get(5)*variables.get(6); 
            if(fEquation == sEquation && fEquation>maxValue[7]){
                for(int i=0;i<7;i++){
                    maxValue[i] = variables.get(i);
                } 
                maxValue[7] = fEquation;
            }
            counter++;
        }

        for(int i=0; i<7; i++) System.out.print(maxValue[i] + ", ");
        System.out.println("\nHighest possible value is: " + maxValue[7]);
    }
}