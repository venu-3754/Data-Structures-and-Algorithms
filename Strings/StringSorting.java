package Strings;
import java.util.*;
public class StringSorting {

    public static void main(String[] args) {
        String s = "venu";
        char[] a = new char[s.length()];
        for(int i=0;i<s.length();i++)
        {
            a[i] = s.charAt(i);
        }
        Arrays.sort(a);
        for(int i=0;i<s.length();i++)
        {
            System.out.print(a[i]+" ");
        }
    }
}
