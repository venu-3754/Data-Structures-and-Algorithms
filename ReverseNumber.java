import java.util.*;
public class ReverseNumber {
    


    //Another way to reverse a number using RECURSION:

    //     public static void Fun(int n)
    // {
    //     if(n<10) System.out.print(n);
    //     else{
    //         System.out.print(n%10);
    //         Fun(n/10);
    //     }
    // }
    
    
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n<=9) System.out.print(n);
        for( ; n!=0 ; n/=10){
            System.out.print(n%10);
        }
        // Fun(n);
        sc.close();
    }
}
