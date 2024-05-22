class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        permute ( nums, 0 , new ArrayList<Integer>());
        return ans;
    }
    private void permute(int[] arr, int start, List<Integer> path){
        ans.add(new ArrayList<>(path) );
       
        for ( int i = start ; i < arr.length; i++ ){
            path.add( arr[i] );
            permute(arr,i+1,path );
            path.remove( path.size() - 1 );
            // permute(arr,i+1,path );
        }
    }
}