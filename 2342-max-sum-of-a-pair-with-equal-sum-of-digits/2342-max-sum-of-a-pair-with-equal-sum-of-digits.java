class Solution {
    public int maximumSum(int[] nums) {
        int maxSum = -1;
        HashMap<Integer, Integer> digMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int digitSum = countSumOfDigits(nums[i]);
            
            if(!digMap.containsKey(digitSum)){
                digMap.put(digitSum, nums[i]);
            }else{
                int currPairSum = nums[i] + digMap.get(digitSum);
                maxSum = Math.max(maxSum, currPairSum);

                digMap.put(digitSum, Math.max(nums[i], digMap.get(digitSum)));
            }
        }
        return maxSum;
    }

    int countSumOfDigits(int num){
        int digSum = 0;
        while(num > 0){
            digSum += num % 10;
            num /= 10;
        }
        return digSum;
    }
}