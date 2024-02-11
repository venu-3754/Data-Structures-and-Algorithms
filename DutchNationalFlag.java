// import java.util.Scanner;

public class DutchNationalFlag {

    
    public static void PrintArray(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void Algo(int[] a)
    {
        int zero = 0;
        int one = 0;
        int two = 0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==0) zero++;
            else if(a[i]==1) one++;
            else two++;
        }
        int i = 0;
        while(zero!=0)
        {
            a[i++] = 0;
            zero--;
        }
        while(one!=0)
        {
            a[i++] = 1;
            one--;
        }
        while(two!=0)
        {
            a[i++] = 2;
            two--;
        }
    }


    public static void main(String[] args)
    {
        // Scanner sc = new Scanner(System.in);
        // int size = sc.nextInt();
        // int [] a = new int[size];
        // for(int i=0;i<size;i++){
        //     a[i] = sc.nextInt();
        // }

        int[] a = {0,1,2,1,2,0,1,2};
        PrintArray(a);
        Algo(a);
        System.out.println("After Sorting 0's and 1's");
        PrintArray(a);
    }
}
