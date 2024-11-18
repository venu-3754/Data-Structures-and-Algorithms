
import java.util.*;

public class Recursion{

    public static void Sum(int start, int end, int sum)
    {
        if(start>end)
        {
            System.out.println(sum);
            return;
        }
        Sum(start+1, end, sum + start);
    }


    public static void Factorial(int n, int fact)
    {
        if(n == 0)
        {
            System.out.println(fact);
            return;
        }
        Factorial(n-1, fact+n);
    }


    public static int Factorial1(int n)
    {
        if(n == 0) return 1;
        return Factorial1(n-1)*n;
    }


    public static int Fibonacci(int n)
    {
        if(n<=1) return n;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }


    public static void MoveXToEnd(String s, int i, String newStr, int count)
    {
        if(i == s.length())
        {
            for(int j=0;j<count;j++) newStr += "x";
            System.out.println(newStr);
            return;
        }
        if(s.charAt(i) == 'x') MoveXToEnd(s, i+1, newStr, count+1);
        else MoveXToEnd(s, i+1, newStr+s.charAt(i), count);
    }


    public static void FirstLastOccurance(String s,int i, char target, int first, int last)
    {
        if(i == s.length())
        {
            System.out.println(first+ " "+ last);
            return;
        }
        if(s.charAt(i) == target)
        {

        }
    }



    public static boolean[] map = new boolean[26];
    public static void RemoveDuplicates(String s, int i, String newString)
    {
        if(i == s.length())
        {
            System.out.println(newString);
            return;
        }
        if(map[s.charAt(i)-97] == false)
        {
            map[s.charAt(i)-97] = true;
            RemoveDuplicates(s, i+1, newString+s.charAt(i));
        }
        else RemoveDuplicates(s, i+1, newString);
    }



    public static void PrintSubSequences(String s,int i,String newStr)
    {
        if(i == s.length())
        {
            System.out.print(newStr+" ");
            return;
        }
        PrintSubSequences(s, i+1, newStr);
        PrintSubSequences(s, i+1, newStr+s.charAt(i));
    }


    public static void PermutationsOnString(String s, String per)
    {
        if(s.length() ==0 )
        {
            System.out.println(per);
            return;
        }
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            String newString = s.substring(0, i)+s.substring(i+1);
            PermutationsOnString(newString, per+c);
        }
    }


    public static void PermutationsOnArray(int[] a, ArrayList<Integer> al, boolean[] b)
    {
        if(al.size() == a.length)
        {
            System.out.println(al);
            return;
        }
        for(int i=0;i<a.length;i++)
        {
            if(b[i] == false)
            {
                b[i] = true;
                al.add(a[i]);
                PermutationsOnArray(a, al, b);
                al.remove(al.size()-1);
                b[i] = false;
            }
        }
    }



    public static void main(String[] args)
    {

        // Sum(1, 5, 0);
        // Factorial(5, 1);/
        // System.out.println(Factorial1(5));
        // System.out.println(Fibonacci(5));

        // RemoveDuplicates("aaaabbcdeccefggghhihj", 1, "");
        // MoveXToEnd("vxexxnxxxxxxxxuxxxgoxxxpaxl", 0, "", 0);
        // PrintSubSequences("abcd", 0, "");

        // PermutationsOnString("abc", "");




        /* This is for Permutations on Arrays */
        // int[] a = {1, 2, 3};
        // boolean[] b = new boolean[a.length];
        // ArrayList<Integer> al = new ArrayList<>();
        // PermutationsOnArray(a, al, b);
        /* Till here */

    }

}