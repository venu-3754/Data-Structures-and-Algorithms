
/* To find whether given two strings are Anagram Or Not? */
/*  https://www.geeksforgeeks.org/problems/anagram-1587115620/1   */

import java.util.HashMap;

public class AnagramStrings {

    /* 1st Type Solution */
    public static boolean isAnagram1(String a,String b)
    {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i=0;i<a.length();i++)
        {
            map1.put(a.charAt(i), map1.getOrDefault(a.charAt(i),0)+1);
        }
        for(int i=0;i<b.length();i++)
        {
            map2.put(b.charAt(i), map2.getOrDefault(b.charAt(i),0)+1);
        }
        return map1.equals(map2);
    }


    /* 2nd Type Solution */
    public static boolean isAnagram2(String a,String b)
    {
        if(a.length()!=b.length()) return false;
        HashMap<Character,Integer> map1 = new HashMap<>();
        for(int i=0;i<a.length();i++)
        {
            map1.put(a.charAt(i), map1.getOrDefault(a.charAt(i),0)+1);
        }
        for(int i=0;i<b.length();i++)
        {
            if(map1.containsKey(b.charAt(i))) map1.put(b.charAt(i),map1.get(b.charAt(i))-1);
        }
        for(char c: map1.keySet())
        {
            if(map1.get(c)!=0) return false;
        }
        return true;
    }

    /* 3rd Type Solution */
    public static boolean isAnagram3(String a,String b)
    {
        char[] arr = new char[100];
        if(a.length()!=b.length()) return false;
        for(int i=0;i<a.length();i++)
        {
            arr[a.charAt(i)-97]++;
        }
        for(int i=0;i<b.length();i++)
        {
            arr[b.charAt(i)-97]--;
        }
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0) return false;
        }
        return true;
    }




    /*  COUNTING ANAGRAMS IN A GIVEN STRING */
    /* LOGIC  */
    
    HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<pat.length();i++){
            map.put(pat.charAt(i),map.getOrDefault(pat.charAt(i),0)+1);
        }
        int count = map.size();
        int left = 0;
        int right = 0;
        int ans = 0;
        while(right<txt.length()){
            char c1 = txt.charAt(right);
            if(map.containsKey(c1)){
                map.put(c1,map.get(c1)-1);
                if(map.get(c1)==0) count--;
            }
            if(right-left+1==pat.length()){
                if(count==0) ans++;
                char c2 = txt.charAt(left);
                if(map.containsKey(c2)){
                    map.put(c2,map.get(c2)+1);
                    if(map.get(c2)==1) count++;
                }
                left++;
            }
            right++;
        }
        return ans;
}
