class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int mn = arr.length;
        int n = mat.length;
        int m = mat[0].length;
        int[][] ele = new int[mn+1][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int element = mat[i][j];
                ele[element - 1] = new int[]{i, j};
            }
        }

        int[] row = new int[n];
        Arrays.fill(row, m);
        int[] col = new int[m];
        Arrays.fill(col, n);

        for(int i = 0; i < mn; i++){
            int curr = arr[i]-1;
            int r = ele[curr][0];
            int c = ele[curr][1];
            row[r]--;
            col[c]--;

            if(row[r] == 0 || col[c] == 0) return i;
            // if(row[r] == 0) return r+1;
            // if(col[c] == 0) return c+1;
        }
        return mn;
    }
}