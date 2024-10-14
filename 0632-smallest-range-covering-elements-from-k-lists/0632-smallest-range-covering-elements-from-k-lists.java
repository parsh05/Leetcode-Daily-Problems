class Solution {
    public int[] smallestRange(List<List<Integer>> arr) {
        PriorityQueue<Triplets> pq = new PriorityQueue<>();
        int k = arr.size();
         int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < k; i++){
            pq.add(new Triplets(arr.get(i).get(0), i, 0));

            max = Math.max(arr.get(i).get(0), max);
        }
       
        int min_range = Integer.MAX_VALUE;
        int[] ans = new int[2];
        while(pq.size() == k){
            Triplets t = pq.poll();
            int ele_idx = t.ele_idx, list_idx = t.list_idx;
            min = t.ele;
            int range = max - min;
            if(range < min_range){
                min_range = range;
                ans[0] = min;
                ans[1] = max;
            }

            //
            if(ele_idx + 1 < arr.get(list_idx).size()){
                pq.add(new Triplets(arr.get(list_idx).get(1 + ele_idx), list_idx,1 + ele_idx));
                max = Math.max(arr.get(list_idx).get(1 + ele_idx), max);;
            }
        }
        return ans;
    }
}
class Triplets implements Comparable<Triplets>{
    int ele;
    int list_idx;
    int ele_idx;
    Triplets(int ele, int list_idx, int ele_idx){
        this.ele = ele;
        this.list_idx = list_idx;
        this.ele_idx = ele_idx;
    }
    @Override
    public int compareTo(Triplets t){
        return this.ele - t.ele;
    }
}