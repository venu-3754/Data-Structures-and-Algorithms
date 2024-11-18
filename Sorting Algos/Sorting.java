// import java.util.*;
public class Sorting {
    public static void PrintArray(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void BubbleSort(int[] a){
        int count = 0;
        for(int i=0;i<a.length-1;i++){
            if(a[i]<a[i+1]){
                count++;
            }
        }
        if(count == a.length-1) return;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    
    public static void main(String[] args){
        int[] a = {50,40,30,20,10};
        PrintArray(a);
        BubbleSort(a);  /*We can use  Array.sort(a)  function also */
        PrintArray(a);
    }
    
}
