public class Methods {
    private int a;
    private int b;
    private double doubA;
    private double doubB;
    private double doubC;

    public Methods(int a, int b){
        this.a = a;
        this.b = b;
    }
    public Methods(double a, double b, double c){
        doubA = a;
        doubB = b;
        doubC = c;
    }
    public String toString(){
        return " integer a: " + a + " integer b: " + b + " double doubA: " + doubA + " double doubB: " + doubB + " double doubC: " + doubC;
    }

    public void voidMethodTest(){
        a = 0;
    }

}
