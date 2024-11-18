package StacksProblems;

import java.util.*;
public class StacksUsingAL {
    
    static class StacksUsingArrayLists
    {
        ArrayList<Integer> al = new ArrayList<>();

        public boolean isEmpty()
        {
            if(al.size()==0) return true;
            return false;
        }

        public void push(int d)
        {
            al.add(d);
        }

        public int pop()
        {
            if(isEmpty()) return -1;
            return al.remove(al.size()-1);
        }

        public int peek()
        {
            if(isEmpty()) return -1;
            return al.get(al.size()-1);
        }

        public int size()
        {
            return al.size();
        }
    }
}
