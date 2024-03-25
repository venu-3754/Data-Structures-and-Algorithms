import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Stacks {


    public static int precedence(char c)
    {
        switch(c)
        {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }



    public static String infixToPostfix(String s)
    {
        Deque<Character> st = new ArrayDeque<>();
        String result = "";
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) result += c;
            else if(c=='(') st.push(c);
            else if(c==')')
            {
                while(!st.isEmpty() && st.peek()!='(')
                {
                    result += st.pop();
                }
                st.pop();
            }
            else
            {
                while(!st.isEmpty() && precedence(c)<=precedence(st.peek()))
                {
                    result += st.pop();
                }
                st.push(c);
            }
            System.out.println(st+"    "+result);
        }
        while(!st.isEmpty())
        {
            if(st.peek()=='(') return "Invalid Expression";
            result += st.pop();
        }
        return result;
    }



    public static String reverse(String s)
    {
        String result = "";
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)=='(') result += ')';
            else if(s.charAt(i)==')') result += '(';
            else result += s.charAt(i);
        }
        return result;
    } 



    public static String nearlyInfixToPostfix(String s)
    {
        Deque<Character> st = new ArrayDeque<>();
        String result = "";
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) result += c;
            else if(c=='(') st.push(c);
            else if(c==')')
            {
                while(!st.isEmpty() && st.peek()!='(')
                {
                    result += st.pop();
                }
                st.pop();
            }
            else
            {
                while(!st.isEmpty() && precedence(c)<precedence(st.peek()))
                {                 //changed  only <= to < symbol  
                    result += st.pop();
                }
                st.push(c);
            }
            System.out.println(st+"    "+result);
        }
        while(!st.isEmpty())
        {
            if(st.peek()=='(') return "Invalid Expression";
            result += st.pop();
        }
        return result;
    }



    public static String infixToPrefix(String s)
    {
        String rev = reverse(s);
        System.out.println(rev);
        String postRev = nearlyInfixToPostfix(rev);
        System.out.println(postRev);
        String revPostRev = reverse(postRev);
        return revPostRev;
    }



    public static String prefixToInfix(String s)
    {
        Stack<String> st = new Stack<>();
        for(int i=s.length()-1;i>=0;i--)
        {
            char c = s.charAt(i);
            if((c>='a' && c<='z') || (c>='A' && c<='Z')) st.push(c+"");
            // if(Character.isLetterOrDigit(c)) st.push(c+"");     This can also be used instead of above condition
            else
            {
                String op1 = st.pop();
                String op2 = st.pop();
                st.push("("+op1+c+op2+")");
            }
        }
        return st.pop();
    }



    public static String prefixToPostfix(String s)
    {
        Stack<String> st = new Stack<>();
        for(int i=s.length()-1;i>=0;i--)
        {
            char c = s.charAt(i);
            if((c>='a' && c<='z') || (c>='A' && c<='Z')) st.push(c+"");
            // if(Character.isLetterOrDigit(c)) st.push(c+"");     This can also be used instead of above condition
            else
            {
                String op1 = st.pop();
                String op2 = st.pop();
                st.push(op1+op2+c);
            }
        }
        return st.pop();
    }



    public static String postfixToInfix(String s)
    {
        Stack<String> st = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            // if((c>='a' && c<='z') || (c>='A' && c<='Z')) st.push(c+"");    Instead of this use below statement for accuratae results...
            if(Character.isLetterOrDigit(c)) st.push(c+"");
            else
            {
                String op1 = st.pop();
                String op2 = st.pop();
                st.push("("+op2+c+op1+")");
            }
        }
        return st.pop();
    }



    public static String postfixToPrefix(String s)
    {
        Stack<String> st = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if((c>='a' && c<='z') || (c>='A' && c<='Z')) st.push(c+"");
            else
            {
                String op1 = st.pop();
                String op2 = st.pop();
                st.push(c+op2+op1);
            }
        }
        return st.pop();
    }




    public static void main(String[] args) {
        
        // System.out.println(precedence('+'));
        // System.out.println(precedence('-'));
        // System.out.println(precedence('*'));
        // System.out.println(precedence('/'));
        // System.out.println(precedence('^'));
        
        // System.out.println(infixToPostfix("a*b*+c+4+d/fgh"));

        // System.out.println(postfixToInfix("23+5*"));

        // System.out.println(infixToPrefix("A*B+C/D"));

        // System.out.println(prefixToInfix("+AB"));

        // System.out.println(prefixToPostfix("+AB"));

        // System.out.println(postfixToPrefix("ab+"));
        
    }
}
