import java.util.*;
public class UndirectedGraph {
    //Function to detect cycle in an undirected graph

    public boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited,int i, int parent)
    {
        int temp=0;
        visited[temp] = true;
        for(int j=0;i<graph.get(temp).size();j++)
        {
            if(!visited[graph.get(temp).get(j)])
            {
                if(dfs(graph, visited),graph.get(temp).get(j),temp==true)
                {
                    return true;
                }
            }
            else if(graph.get(temp).get(j)!=parent)
            {
                return true;
            }
        }
        return false;
    }
    public static boolean isCyclic(int V, ArrayList<Integer> adj)
    {
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                if(dfs(adj,visited, i,-1 )==true) return true;
            }
        }
        return false;
    }
}
