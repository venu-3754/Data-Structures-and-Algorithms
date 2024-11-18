package LeetCode;
import java.util.LinkedList;
import java.util.Queue;

    /*  https://leetcode.com/problems/number-of-islands/     */

public class IslandProblem {
    class Solution {
    static class Pair {
        int r;
        int c;
        Pair(int i, int j) {
            r = i;
            c = j;
        }
    }

    public int bfs(char[][] grid, boolean[][] visited, int r, int c, int m, int n) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        visited[r][c] = true;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int row = p.r;
            int col = p.c;
            int[] dr = { -1, 1, 0, 0 };
            int[] dc = { 0, 0, -1, 1 };
            for (int i = 0; i < 4; i++) {
                int rrow = row + dr[i];
                int ccol = col + dc[i];
                if (rrow >= 0 && rrow < m && ccol >= 0 && ccol < n && !visited[rrow][ccol] && grid[rrow][ccol] == '1') {
                    visited[rrow][ccol] = true;
                    q.add(new Pair(rrow, ccol));
                }
            }
        }
        return 1;
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(grid, visited, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }
}
}
