public class RotateLL {

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


   public static Node rotateRight(Node head,int k)
   {
        if(head == null || k == 0) return head;
        Node temp = head;
        int count = 0;
        while(temp.next!=null)
        {
            count++;
            temp = temp.next;
        }
        count++;
        if(k%count==0) return head;
        k = k % count;
        temp.next = head;
        Node prev = null;
        for(int i=0;i<count-k+1;i++)
        {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        head = temp;
        return head;
   }



    public static void main(String[] args) {
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        printLL();
        rotateRight(head, 3);
        printLL();

    }

}
