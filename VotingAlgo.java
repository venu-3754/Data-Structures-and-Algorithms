import java.util.*;

public class VotingAlgo {
    public static int BooyereMoresAlgo(int[] a,int n){
        int votes = 0;
        int maj = -1;
        for(int i=0;i<n;i++){
            if(votes==0){
                maj = a[i];
                votes = 1;
            }
            else{
                if(maj==a[i])  votes++;
                else votes--;
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(a[i]==maj) count++;
        }
        if(count>n/2)  return maj;
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
         

        BooyereMoresAlgo(a,n);
        sc.close();
    }
    
}
