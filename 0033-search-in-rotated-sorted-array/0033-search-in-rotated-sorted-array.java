class Solution {
    public int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        int ans = -1;
        while( l <= h ){
            int mid = ( h - l )/2 + l;
            if( target == nums[mid] ) return mid;
            if( nums[l] <= nums[mid] ){  // for left sorted
                if( target >= nums[l] && target <= nums[mid] ) h = mid - 1;
                else l = mid + 1; 
            } else{
                if( target >= nums[mid] && target <= nums[h] ) l = mid + 1; 
                else  h = mid - 1;
            }
        }
        return -1;
    }
}