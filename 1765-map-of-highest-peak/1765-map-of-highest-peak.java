class Solution {
    int[][] dir = {{0,1}, {0, -1}, {1, 0}, {-1,0}};
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length, m = isWater[0].length;
        int[][] height = new int[n][m];
        for(int[] row : height) Arrays.fill(row, -1);
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
               if(isWater[i][j] == 1) {
                q.add(new int[]{i, j});
                height[i][j] = 0;
               }
            }
        }
       

        while(q.size() > 0){
            int[] top = q.poll();
            int r = top[0], c = top[1];

            for(int i = 0; i < 4; i++){
                int newR = r + dir[i][0], newC = c + dir[i][1];
                if(newR < 0 || newR >= n || newC < 0 || newC >= m || height[newR][newC] >= 0) continue;
                height[newR][newC] = 1 + height[r][c];
                q.add(new int[]{newR, newC});
            }
        }
        return height;
    }
}