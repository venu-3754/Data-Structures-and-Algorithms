import java.util.*;
public class ArrayLists {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);
        al.add(50);
        al.set(3, 365);
        System.out.println(al);
        al.remove(3);
        System.out.println(al);
        for(int i:al)
        {
            System.out.print(i+" ");
        }
        System.out.println(al.get(2));
        for(int j =0;j<al.size();j++)
        {
            System.out.println(al.get(j));
        }
    }
}
