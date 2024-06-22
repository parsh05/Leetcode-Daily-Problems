class Solution {
    private int getPivotIndex(int[] nums){
        // return index of the minimum element in given unsorted array
       int n = nums.length;
        int l = 0, h = n - 1;
        while ( l <= h ){
            int mid = l + ( h - l )/2;
            int prev = ( mid - 1 + n) % n;
            int next = ( mid + 1 ) %n;
            if( nums[mid] <= nums[prev] && nums[mid] <= nums[next] ) return mid;
            if( nums[l] <= nums[mid] ){ // left is sorted
               if( nums[mid] >= nums[h] ) l = mid + 1;
               else h = mid - 1;
            } else{
                if( nums[l] >= nums[mid] ) h = mid - 1;
               else l = mid + 1;
            }
        }
        return 0;
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        int targetIdx = -1;
        int pivotIdx = getPivotIndex( nums );
        if( target == nums[pivotIdx ]) return pivotIdx;
        int start = 0, end = n - 1;
        if( target <= nums[n-1] && target >= nums[pivotIdx] ){
            start = pivotIdx;
            end = n - 1;
        }else{
            start = 0;
            end = pivotIdx - 1;
        }
        // binary search of target
        while( start <= end ){
            int mid = start + ( end - start ) / 2;
            if(nums[mid] == target ) return targetIdx = -1;
            else if( nums[mid] < target ) start = mid + 1;
            else end = mid - 1;
        }
        return targetIdx;
    }
}