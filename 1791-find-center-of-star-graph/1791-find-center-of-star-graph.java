class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length ;
        int[] nbr = new int[n + 2];

        for(int[] edge : edges ){
            int src = edge[0] , dest = edge[1];
            nbr[src]++;
            nbr[dest]++;
        }
        int max = -1, centerNode = 0;
        for(int i = 0; i < nbr.length; i++){
            if( nbr[i] > max ){
                max = nbr[i];
                centerNode = i;
            }
        }
        return centerNode;
    }
}