class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int count = 0;
        for(int i = 1; i < nums1.length; i++){
            if(nums1[i] <= nums1[i-1] || nums2[i] <= nums2[i-1]){
                count++;
                int temp = nums1[i];
                nums1[i] = nums2[i];
                nums2[i] = temp;
            }
        }
        return count;
    }
}