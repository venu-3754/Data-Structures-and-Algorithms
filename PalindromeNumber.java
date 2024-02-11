import java.util.Scanner;
public class PalindromeNumber {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = n;
        int reversednum = 0;
        while(n!=0){
            int b = n % 10;
            reversednum = reversednum * 10 + b;
            n /= 10;
        }
        if(temp==reversednum) System.out.println("It is a Palindrome");
        else System.out.println("Its not a Palindrome");
        sc.close();
    }
    
}