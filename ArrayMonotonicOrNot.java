import java.util.Scanner;


/*    https://www.hackerrank.com/contests/dsa-3-1/challenges/is-it-monotonic/problem     */
/* SOLUTION  */
public class ArrayMonotonicOrNot {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k=0;k<t;k++)
        {
            int n = sc.nextInt();
            int [] a = new int[n];
            int b=1;
            int c=1;
            for(int i=0;i<n;i++)
            {
                a[i] = sc.nextInt();
            }
            for(int j=1;j<n;j++)
            {
                if(a[j]>a[j-1])
                {
                    b=0;
                }
                else if(a[j]<a[j-1])
                {
                    c=0;
                }
            }
            int tot = b|c;
            if(tot==1) System.out.println("Yes");
            else System.out.println("No");
        }
        sc.close();
    }
}
