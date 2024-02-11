import java.util.*;
public class LinkedList {
    static class Node{
        int data;
        Node next;
        Node(int d){  //here node is a constructor
            data = d;
            next = null;
        }
    }
    public static Node head;
    public static void printLL(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    public static void countNodes(){
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        System.out.println(count);
    }
    public static void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
    public static void deleteFirst(){
        head = head.next; 
    }
    public static void deleteLast(){
        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next=null;
    }
    public static boolean search(int data){
        Node temp = head;
        while(temp!=null){
            if(temp.data == data) return true;
            temp = temp.next;
        }
        return false;
    }
    public static void addAtGivenPos(int data, int target){
        if(target<0){
            System.out.println("the given target is below 0");
            return;
        }
        if(target == 0 ){
            addFirst(data);
        }
        else{
            int count = 0;
            Node temp = head;
            while(count!=target-1){
                count++;
                temp = temp.next;
            }
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
        }

    }
    public static void deleteAtGivenPos(int target){
        if(target<0){
            System.out.println("the given target is below 0");
            return;
        }
        if(target == 0 ){
            deleteFirst();
            return;
        }
            int count = 0;
            Node temp = head;
            while(count!=target-1){
                count++;
                temp = temp.next;
            }
            temp.next = temp.next.next;
    }


    

    public static boolean isPalindrome()
    {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null;
        Node curr = slow;
        Node next;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node temp = head;
        while(temp!=null && prev!=null)
        {
            if(temp.data!=prev.data) return false;
            temp = temp.next;
            prev = prev.next;
        }
        return true;
    }


    public static void main(String[] args) {
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next=head.next;
        // printLL();
        // addFirst(100);
        // addLast(100);
        // printLL();
        // System.out.println(head.data );

        

    }
}