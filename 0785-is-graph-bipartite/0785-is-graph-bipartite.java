class Solution {
    private boolean ans(int[][] graph, int[] vis, int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = 0; // mark is visited
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int v : graph[curr]){
                if(vis[v] == -1){  // if nbr is graph
                    q.add(v);
                    vis[v] = 1 - vis[curr];
                }else{
                    if(vis[v] == vis[curr]) return false;
                }
            }
        }
        return true;
    }


    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Queue<Integer> q = new LinkedList<>();
        int[] vis = new int[n];
        Arrays.fill(vis, -1);

        for(int i = 0; i < n; i++){
            if(ans(graph, vis, i) == false) return false;
        }
         return true;
    }
}