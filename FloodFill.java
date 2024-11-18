import java.util.Queue;
import java.util.LinkedList;

    /*  https://leetcode.com/problems/flood-fill/    */

public class FloodFill {
    class Pair {
    int r;
    int c;
    Pair(int _r, int _c) {
        r = _r;
        c = _c;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int originalColor = image[sr][sc];
        if (originalColor == newColor) // No need to perform flood-fill if newColor is the same as originalColor
            return image;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        image[sr][sc] = newColor; // Marking the starting pixel as visited immediately
        
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int srCurrent = p.r;
            int scCurrent = p.c;
            
            // Check neighboring pixels
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                int r = srCurrent + dir[0];
                int c = scCurrent + dir[1];
                
                // Check if neighboring pixel is within image bounds and has the same color
                if (r >= 0 && r < m && c >= 0 && c < n && image[r][c] == originalColor) {
                    q.add(new Pair(r, c));
                    image[r][c] = newColor; // Mark neighboring pixel as visited
                }
            }
        }
        
        return image;
    }
}
}
