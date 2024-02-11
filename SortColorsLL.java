public class SortColorsLL {

    static class Node{
        int data;
        Node next;
        Node(int d)  //here Node is a constructor
        {
            data = d;
            next = null;
        }
    }
    public static Node head;

    public static void printLL()
    {
        Node temp1 = head;
        while(temp1 != null){
            System.out.print(temp1.data+"->");
            temp1 = temp1.next;
        }
        System.out.println("null");
    }



    public static Node Sort()
    {
        Node zerohead = new Node(-1);
        Node onehead = new Node(-1);
        Node twohead = new Node(-1);
        Node zero = zerohead;
        Node one = onehead;
        Node two = twohead;
        Node temp = head;
        while(temp!=null)
        {
            if(temp.data == 0)
            {
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.data == 1)
            {
                one.next = temp;
                one = one.next;
            }
            else
            {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        two.next = null;
        if(onehead.next == null){
            zero.next = twohead.next;
        }
        else{
            zero.next = onehead.next;
        }
        one.next = twohead.next;
        return zerohead.next;
    }


    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        printLL();
        Sort();
        printLL();
    }


}
