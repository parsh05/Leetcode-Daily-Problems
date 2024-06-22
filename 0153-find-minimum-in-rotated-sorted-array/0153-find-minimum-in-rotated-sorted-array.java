class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, h = n - 1;
        while ( l <= h ){
            int mid = l + ( h - l )/2;
            int prev = ( mid - 1 + n) % n;
            int next = ( mid + 1 ) %n;
            if( nums[mid] <= nums[prev] && nums[mid] <= nums[next] ) return nums[mid];
            if( nums[l] <= nums[mid] ){ // left is sorted
               if( nums[mid] >= nums[h] ) l = mid + 1;
               else h = mid - 1;
            } else{
                if( nums[l] >= nums[h] ) h = mid - 1;
               else l = mid + 1;
            }
        }
        return -1;
    }
}