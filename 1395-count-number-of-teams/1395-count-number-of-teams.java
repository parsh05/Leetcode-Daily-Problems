// Time Complexity = O(2*length_Of_Array^2 + length_of_Array);

// Space Complexity = O(N);


class Solution {
    public int numTeams(int[] rating) {

        int answer =0;
        answer = helper(rating); // helper function calculating the number of increasing sequence of length 3.


        // reversal of array for calculating decreasing sequence of length 3.
        for(int i=0;i<rating.length/2;i++){

            int temp = rating[i];
            rating[i] = rating[rating.length-i-1];
            rating[rating.length-i-1]=temp;
        }

        answer+=helper(rating);

        return answer;
   
        
    }


    // helper function
    int helper(int[] rating){

         int[] dp = new int[rating.length];
        // Arrays.fill(dp,1);

        int answer = 0;

        for(int i=1;i<rating.length;i++){
            for(int j=0;j<i;j++){
                if(rating[j]<rating[i]){

                    answer+=dp[j];
                    dp[i]++;
                }
            }
        }
       
        // System.out.println(Arrays.toString(dp));
        return answer;
    }
}