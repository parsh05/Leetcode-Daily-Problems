class Solution {

    

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        ArrayList<Integer>[] revGraph = new ArrayList[N];
        for(int i = 0; i < N; i++){
            revGraph[i] = new ArrayList<>();
        }

        int[] indegree = new int[N];

        for(int u = 0; u < graph.length; u++){
            for(int v : graph[u]){
                revGraph[v].add(u);
                indegree[u]++;
            }
        }


        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            if(indegree[i] == 0) q.add(i);
        }
        
        List<Integer> ans = new LinkedList<>();
        
        while(q.size() > 0){
            int top = q.poll();
            ans.add(top);
            for(int nbr : revGraph[top]){
                indegree[nbr]--;
                if(indegree[nbr] == 0) {
                    q.add(nbr);
                    
                }
            }
        }
        
        Collections.sort(ans);
        return ans;
    }
}