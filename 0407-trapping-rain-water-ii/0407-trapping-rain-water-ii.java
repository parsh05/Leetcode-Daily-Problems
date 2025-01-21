class Solution {
    int[] frontNge(int[][] heightMap, int j){
        int n = heightMap.length ;
        int maxIdx = n-1;
        int[] res = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = n-1; i >= 0; i-- ){
            max = Math.max(max, heightMap[i][j]);
            res[i] = max;
        }
        return res;
    }

    int[] frontPge(int[][] heightMap, int j){
        int n = heightMap.length ;
        int[] res = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++ ){
            max = Math.max(max, heightMap[i][j]);
            res[i] = max;
        }
        return res;
    }

    int[] sideNge(int[][] heightMap, int i){
        int m = heightMap[0].length ;
        int[] res = new int[m];
        int max = Integer.MIN_VALUE;
        for(int j = m-1; j >= 0; j-- ){
            max = Math.max(max, heightMap[i][j]);
            res[j] = max;
        }
        return res;
    }
    int[] sidePge(int[][] heightMap, int i){
        int m = heightMap[0].length ;
        int[] res = new int[m];
        int max = Integer.MIN_VALUE;
        for(int j = 0; j < m; j++ ){
            max = Math.max(max, heightMap[i][j]);
            res[j] = max;
        }
        return res;
    }
    public int trapRainWater(int[][] heightMap) {
        
        int water = 0;
        int n = heightMap.length, m = heightMap[0].length;

        int[][] left = new int[n][m];
        int[][] right = new int[n][m];
        for(int i = 0; i < n; i++){
            left[i] = sidePge(heightMap, i);
            right[i] = sidePge(heightMap, i);
        }

        int[][] front = new int[m][n];
        int[][] back = new int[m][n];
        for(int j = 0; j < m; j++){
            front[j] = frontNge(heightMap, j);
            back[j] = frontPge(heightMap, j);
        }
        

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int[] nge = new int[4];
                nge[0] = left[i][j];//left
                nge[1] = right[i][j];//right
                nge[2] = front[j][i];//front
                nge[3] = back[j][i];//back

                int min = Integer.MAX_VALUE;
                for(int k = 0; k < 4; k++){
                    min = Math.min(min, nge[k]);
                }


                water += min-heightMap[i][j];
            }
        }
        return water;
    }
}