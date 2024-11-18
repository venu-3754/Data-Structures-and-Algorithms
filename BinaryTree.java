import java.util.*;
public class BinaryTree {
    
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
            System.out.print(temp.data+" ");           // OP: 1 2 3 4 5 6 7
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
        System.out.println(root.data);        //  4 2 5 1 6 3 7
        InOrderTraversal(root.right);
    }


    public static void PreOrderTraversal(Node root)      //Follows ---> ROOT,LEFT,RIGHT   
    {
        if(root==null) return;          /* Push right child first and then left child onto the stack to maintain preorder traversal */
        System.out.println(root.data);           // 1 2 4 5 3 6 7
        PreOrderTraversal(root.left);
        PreOrderTraversal(root.right);
    }


    public static void PostOrderTraversal(Node root)          //Follows ---> LEFT,RIGHT,ROOT
    {
        if(root==null) return;
        PostOrderTraversal(root.left);
        PostOrderTraversal(root.right);
        System.out.println(root.data);            // 4 5 2 6 7 3 1 
    }



    /*  https://leetcode.com/problems/count-complete-tree-nodes/         */

    public static int CountNodes(Node root)
    {
        if(root==null) return 0;
        return CountNodes(root.left)+CountNodes(root.right)+1;
    }


    public static int CountNodes2(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        int count = 0;
        q.add(root);
        while(!q.isEmpty())
        {
            Node temp = q.remove();
            count++;
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
        }
        return count;
    }



    /*      https://www.geeksforgeeks.org/problems/sum-of-binary-tree/1      */

    public static int SumOfBinaryTreeNodes(Node root)
    {
        if(root == null) return 0;
        return(SumOfBinaryTreeNodes(root.left)+SumOfBinaryTreeNodes(root.right)+root.data);
    }



    /*      https://leetcode.com/problems/maximum-depth-of-binary-tree/      */

    public static int MaxDepthOfBT(Node root) {
        if(root == null) return 0;
        int LeftDepth = MaxDepthOfBT(root.left);
        int RightDepth = MaxDepthOfBT(root.right);
        return Math.max(LeftDepth, RightDepth)+1;
    }


    /*      USING ITERATION WAY   Performing all preorder,postorderinorder traversals below    */

    /*      https://leetcode.com/problems/binary-tree-preorder-traversal/        */

    public static List<Integer> preOrderTraversal(Node root)
    {
        List<Integer> ans = new ArrayList<>();
        if(root == null ) return ans;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty())
        {
            Node temp = st.pop();
            ans.add(temp.data);
            if(temp.right!=null) st.push(temp.right);
            if(temp.left!=null) st.push(temp.left);
        }
        return ans;
    }


    /*      https://leetcode.com/problems/binary-tree-postorder-traversal/       */

    public static List<Integer> postorderTraversal(Node root)
    {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty())
        {
            Node temp = st1.pop();
            st2.push(temp);
            if(temp.left!=null) st1.push(temp.left);
            if(temp.right!=null) st1.push(temp.right);
        }
        while(!st2.isEmpty())
        {
            ans.add(st2.pop().data);
        }
        return ans;
    }




    public static boolean IsIdentical(Node root,Node subroot)
    {
        if(root==null && subroot==null) return true;
        if(root==null || subroot==null || root.data!=subroot.data) return false;
        if(!IsIdentical(root.left, subroot)) return false;
        if(!IsIdentical(root.right, subroot)) return false;
        return true;
    }
    public boolean IsSubtree(Node root,Node subroot)
    {
        if(root == null) return false;
        if(root.data == subroot.data)
        {
            if(IsIdentical(root,subroot)) return true;
        }
        return IsSubtree(root.left, subroot) || IsSubtree(root.right, subroot);
    }



    /*      https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/       */

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root==null || root==p || root==q) return root;
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }



    /*  https://www.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1   */

    public static Node lowestCommonAncestor(Node root, int p, int q)
    {
        if(root==null || root.data==p || root.data==q) return root;
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }
    public static int distBtwRootToNode(Node root, int a) {
        if(root==null) return -1;
        if(root.data==a) return 0;
        int ld = distBtwRootToNode(root.left, a);
        int rd = distBtwRootToNode(root.right, a);
        if(ld==-1 && rd==-1) return -1;
        else if(ld==-1) return rd+1;
        return ld+1;
    }
    public static int findDist(Node root, int a, int b)
    {
        Node lca = lowestCommonAncestor(root, a, b);
        int ld = distBtwRootToNode(lca, a);
        int rd = distBtwRootToNode(lca, b);
        return ld+rd;
    }



    /*  https://www.geeksforgeeks.org/problems/transform-to-sum-tree/1   */

    public static int solve(Node root){
        if(root==null) return 0;
        int leftSum = solve(root.left);
        int rightSum = solve(root.right);
        int data = root.data;
        int left = root.left==null ?0: root.left.data;
        int right = root.right==null ?0:root.right.data;
        root.data = leftSum+rightSum+left+right;
        return data;
    }
    public static void toSumTree(Node root){
        solve(root);
    }



    /*      https://leetcode.com/problems/diameter-of-binary-tree/description/       */

    public static int height(int[] di, Node root)
    {
        if(root==null) return 0;
        int left = height(di, root.left);
        int right = height(di, root.right);
        di[0] = Math.max(di[0], left+right);
        return 1+Math.max(left, right);
    }
    public static int diameterOfBinaryTree(Node root)
    {
        int[] di = new int[1];
        height(di, root);
        return di[0];
    }


    /*  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/ */



    






    public static void main(String[] args)
    {
        root = new Node(1);                                  //              1
        root.left = new Node(2);                             //           2      3
        root.right = new Node(3);                            //         4   5  6   7
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        // LevelOrderTraversal();

        // LevelWiseLOT();

        // InOrderTraversal(root);

        // PreOrderTraversal(root);

        // PostOrderTraversal(root);

        // System.out.println(CountNodes(root));
        // System.out.println(CountNodes2(root));

        // System.out.println(SumOfBinaryTreeNodes(root));

        // System.out.println(MaxDepthOfBT(root));


        /*     USING ITERATION    */
        // System.out.println(preOrderTraversal(root));
        // System.out.println(postorderTraversal(root));

        // lowestCommonAncestor(root, root.left, root.right);

        // System.out.println(findDist(root, 1, 4));

        // System.out.println(toSumTree(root));

        // System.out.println(diameterOfBinaryTree(root));

    }

}
