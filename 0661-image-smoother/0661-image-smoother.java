class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n = img.length,m = img[0].length;
        int[][] res = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int sum = 0, count = 0;
                for(int di = -1; di <= 1; di++){
                    for(int dj = -1; dj <= 1; dj++){
                        int newRow = i + di, newCol = j + dj;
                        if(newRow < 0 || newRow >= n|| newCol < 0 || newCol >= m) continue;
                        sum += img[newRow][newCol];
                        count++;
                    }
                }
                res[i][j] = sum/count;
            }
        }
        return res;
    }
}