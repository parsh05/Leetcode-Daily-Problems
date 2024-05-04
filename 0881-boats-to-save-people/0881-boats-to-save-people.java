class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int i=0 , j=people.length - 1;
        while(i <= j){
            if(people[j] > limit ){
                j--;
                continue;
            }
            if(people[i] + people[j] > limit) {
                ans++;
                j--;
            } else {
                ans++;
                i++;
                j--;
            }

        }
        
        return ans;
    }
}