import java.util.Queue;

// import javax.swing.tree.TreeNode;

import java.util.LinkedList;
public class BinarySearchTrees {

    public static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int d)  //Here Node acts as a Constructor
        {
            data = d;
            left = null;
            right = null;
        }
    }
    public static Node root;


    public static void LevelOrderTraversal()
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node temp = q.remove();
            System.out.print(temp.data+" ");           // OP: 10 8 13 5 9 11 15 4 6 12 14 17
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
        }
    }


    public static void LevelWiseLOT()
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty())
        {
            Node temp = q.remove();
            if(temp == null)
            {
                if(q.isEmpty()) break;
                else
                {
                    System.out.println();
                    q.add(null);
                }
            }
            else
            {
                System.out.print(temp.data+" ");           //                   1
                if(temp.left!=null) q.add(temp.left);      //                   2 3
                if(temp.right!=null) q.add(temp.right);    //                   4 5 6 7
            }
        }
    }


    public static void InOrderTraversal(Node root)
    {
        if(root==null) return;
        InOrderTraversal(root.left);
        System.out.println(root.data);        //  4 5 6 8 9 10 11 12 13 14 15 17
        InOrderTraversal(root.right);
    }


    public static void PreOrderTraversal(Node root)      //Follows ---> ROOT,LEFT,RIGHT   
    {
        if(root==null) return;          /* Push right child first and then left child onto the stack to maintain preorder traversal */
        System.out.println(root.data);           // 10 8 5 4 6 9 13 11 12 15 14 17 
        PreOrderTraversal(root.left);
        PreOrderTraversal(root.right);
    }


    public static void PostOrderTraversal(Node root)          //Follows ---> LEFT,RIGHT,ROOT
    {
        if(root==null) return;
        PostOrderTraversal(root.left);
        PostOrderTraversal(root.right);
        System.out.println(root.data);            //  4 6 5 9 8 12 11 14 17 15 13 10
    }


    /*  https://leetcode.com/problems/search-in-a-binary-search-tree/description/    */

    // public TreeNode searchBST(TreeNode root, int val) {
    //    if(root==null) return null;
    //    if(root.val==val) return root;
    //    if(val<root.val) return searchBST(root.left, val);
    //    else return searchBST(root.right, val);
    // }

    public static boolean Search(Node root, int ele)
    {
        if(root == null) return false;
        if(root.data == ele) return true;
        if(ele < root.data) return Search(root.left, ele);
        return Search(root.right, ele);
    }


    /*  https://leetcode.com/problems/insert-into-a-binary-search-tree/  */

    public static Node insertIntoBST(Node root, int val) {
        if(root==null)
        {
          Node newNode = new Node(val);
          return newNode;
        }
        if(val<root.data) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);
        return root;
      }

    
    /*  https://leetcode.com/problems/delete-node-in-a-bst/  */

    public static Node deleteNode(Node root, int key) {
        if(key<root.data) return deleteNode(root.left, key);
        else if(key>root.data) return deleteNode(root.right, key);
        else
        {
            if(root.left==null && root.right==null) return null;
            else if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
        }
        return root;
    }


    /*  https://leetcode.com/problems/validate-binary-search-tree/description/   */

    public static boolean function(Node root, long min, long max) {
        if (root == null) return true;
        if (root.data <= min || root.data >= max) return false;
        return function(root.left, min, root.data) && function(root.right, root.data, max);
    }
    public static boolean isValidBST(Node root) {
        return function(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }



    public static void main(String[] args) {
        root = new Node(10);                                  //                 10
        root.left = new Node(8);                              //            8          13
        root.right = new Node(13);                            //         5    9     11     15
        root.left.left = new Node(5);                         //       4  6          12  14  17
        root.left.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(15);
        root.left.left.left = new Node(4);
        root.left.left.right = new Node(6);
        root.right.left.right = new Node(12);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(17);

        // LevelOrderTraversal();

        // LevelWiseLOT();

        // InOrderTraversal(root);

        // PreOrderTraversal(root);

        // PostOrderTraversal(root);

        // System.out.println(Search(root, 4));

        // insertIntoBST(root, 365);

        
    }
}
