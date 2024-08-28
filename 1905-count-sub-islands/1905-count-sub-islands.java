class Solution {
    boolean subIsland = true;
    int row;
    int col;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        row = grid2.length;
        col = grid2[0].length;
        int count = numIslands(grid2 , grid1);
        return count;
    }


    // these are for counting Island

    public int numIslands(int[][] grid2  , int[][] grid1) {
       
        int[][] vis = new int[row][col];
        int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid2[i][j]==1 && vis[i][j] == 0 ) {
                
                    dfs(grid2,grid1,i,j,vis);
                    if(subIsland == true ){
                       count++; 
                    }
                    subIsland=true;
                }
            }
        }
        return count;
    }
    public void dfs(int[][]grid2 ,int[][]grid1, int i, int j, int[][] vis){
        if( vis[i][j] == 1  ) return;
       
        if(grid1[i][j] != 1 && grid2[i][j] == 1){
            subIsland = false;
            // vis[i][j] = 1;
            return;
        }
        vis[i][j] = 1;
        if( i > 0 && grid2[i-1][j] == 1)dfs(grid2 , grid1 ,i-1,j,vis);
        if( i < row - 1 && grid2[i+1][j] == 1)dfs(grid2,grid1,i+1,j,vis);
        if( j > 0 && grid2[i][j-1] == 1)dfs(grid2,grid1 , i,j-1,vis);
        if( j < col - 1 && grid2[i][j+1] == 1)dfs(grid2,grid1 , i,j+1,vis);
    }
}