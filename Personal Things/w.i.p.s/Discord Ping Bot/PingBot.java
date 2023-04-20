public class PingBot{
    public static void main(String[] args){
        Methods test = new Methods(5, 5);
        System.out.println(test);
        Methods test2 = new Methods(5.0, 5.9, 7);
        System.out.println(test2);
        Methods test3 = new Methods(5, 5.0, 6);
        System.out.println(test3);
    }
}
