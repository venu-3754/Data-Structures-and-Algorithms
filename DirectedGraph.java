import java.util.*;
public class DirectedGraph{

    public static void addEdge(ArrayList<ArrayList<Integer>> graph,int u, int v, int direction)
    {
        System.out.println(graph);
    }

    public static void printGraph(ArrayList<ArrayList<Integer>> graph){
        System.out.println(graph);
    }

    public static void bfs(ArrayList<ArrayList<Integer>> graph,int n)
    {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty())
        {
            int ele = q.remove();
            System.out.print(ele+" ");
            for(int i=0;i<graph.get(ele).size();i++)
            {
                if(!visited[graph.get(ele).get(i)])
                {
                    q.add(graph.get(ele).get(i));
                    visited[graph.get(ele).get(i)] = true;
                }
            }
        }
    }


    /*  https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1  */

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> graph) {
        // Code here
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty())
        {
            int ele = q.remove();
            ans.add(ele);
            for(int i=0;i<graph.get(ele).size();i++)
            {
                if(!visited[graph.get(ele).get(i)])
                {
                    q.add(graph.get(ele).get(i));
                    visited[graph.get(ele).get(i)] = true;
                }
            }
        }
        return ans;
    }



    /*  https://www.geeksforgeeks.org/problems/number-of-provinces/1     */   // GEEKS FOR GEEKS

    static void bfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            int temp = q.remove();
            for (int i = 0; i < graph.get(temp - 1).size(); i++) {
                if (graph.get(temp - 1).get(i) == 1 && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.add(i + 1);
                }
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V + 1];
        int count = 0;
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                bfs(adj, visited, i);
                count++;
            }
        }
        return count;
    }

    /*  https://leetcode.com/problems/number-of-provinces/   */      //  LEETCODE

    public static void bfs(int[][] isConnected, boolean[] visited, int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            int temp = q.remove();
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[temp - 1][i] == 1 && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.add(i + 1);
                }
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length + 1];
        int count = 0;
        for (int i = 1; i <= isConnected.length; i++) {
            if (!visited[i]) {
                bfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }


    





    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = sc.nextInt();
        int e = sc.nextInt();
        for(int i=0; i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<e; i++) {
            int u =  sc.nextInt();
            int v =  sc.nextInt();
            addEdge(graph, u, v, 1);
        }
        printGraph(graph);





        sc.close();
    }
}
