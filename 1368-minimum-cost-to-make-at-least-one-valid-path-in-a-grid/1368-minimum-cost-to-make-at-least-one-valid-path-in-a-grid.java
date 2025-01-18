import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    private static final int[][] dir = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} }; // Directions for movement

    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // PriorityQueue to store {row, col, cost}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0, 0, 0}); // Start with the top-left cell

        // Distance array initialized to a high value
        int[][] d = new int[n][m];
        for (int[] row : d) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        d[0][0] = 0; // Distance to the starting cell is 0

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], cost = curr[2];

            // If we have already found a shorter path to this cell, skip
            if (cost > d[r][c]) continue;

            // Explore all 4 directions
            for (int k = 0; k < 4; k++) {
                int nR = r + dir[k][0];
                int nC = c + dir[k][1];

                // Check bounds
                if (nR < 0 || nC < 0 || nR >= n || nC >= m) continue;

                // Calculate the weight of moving to the next cell
                int wt = (k + 1 == grid[r][c]) ? 0 : 1;

                // Relaxation step
                if (d[r][c] + wt < d[nR][nC]) {
                    d[nR][nC] = d[r][c] + wt;
                    pq.offer(new int[]{nR, nC, d[nR][nC]});
                }
            }
        }

        return d[n - 1][m - 1]; // Return the minimum cost to reach the bottom-right cell
    }
}
