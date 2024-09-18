class Solution {
   public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        int idx = 0;
        for(int num : nums) arr[idx++] = Integer.toString(num);
        Arrays.sort(arr, (s1, s2)->  {
          return  (s2 + s1).compareTo(s1 + s2);
        });
        
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            ans.append(arr[i]);
        }
        String s = ans.toString();
        if(Integer.parseInt(s) == 0 ) return "0";
        return s;
    }
}