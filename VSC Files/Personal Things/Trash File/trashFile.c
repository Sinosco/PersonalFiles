
int trashFile(){
    int sum = 0;
    printf("Starting...");
    for(int i=1;i<9223372036854775807;i++){
        float prevSum = sum;
        sum += 1.0/i;
        if(sum<prevSum) printf("We went over the limit whoops, that happened at i=" + i);
        if(i%1000000000==0) printf(sum + "\tat i = " + (i/1000000000) + " E10^9\t" + (9223372036854775807-i) + " away from our limit");
    }
    printf(sum);
    return 0;
}


// import java.util.*;

// public class trashFile{
//     public static void main(String[] args){


//         // System.out.println("Starting...");
//         // System.out.println("Max long value: " + Long.MAX_VALUE);
//         // double sum = 0;
//         // for(long i=1;i<Long.MAX_VALUE;i++){
//         //     double prevSum = sum;
//         //     sum += 1.0/i;
//         //     if(sum<prevSum) System.out.println("We went over the limit whoops, that happened at i=" + i);
//         //     if(i%1000000000==0) System.out.println(sum + "\tat i = " + (i/1000000000) + " E10^9\t" + (Long.MAX_VALUE-i) + " away from our limit");
//         // }

//         // System.out.println(sum);
//     }
// }