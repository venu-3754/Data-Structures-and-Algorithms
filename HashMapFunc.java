import java.util.*;
public class HashMapFunc {
    public static void PrintArray(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void HashMapImplementation(int[] a){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }
        for(int i: map.keySet()){
            System.out.println(i+" "+map.get(i));
        }
    }


    public static void main(String[] args) {
        int[] a = {1,0,0,2,1,0,2,1,0};  // 0-->4  1-->3  2-->2
        HashMapImplementation(a);
    }
}
