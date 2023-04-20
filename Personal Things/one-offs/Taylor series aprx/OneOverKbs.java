public class OneOverKbs {
    public static void main(String[] args){
        System.out.println("Starting...");

        double sum = 0;
        for(long i=(long)(Long.MAX_VALUE*0.9);i<Long.MAX_VALUE;i++){
            sum += 1.0/i;
            
        }

        System.out.println(sum);
    }
}
