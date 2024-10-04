class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        if(n%2 == 1) return -1;
        long targetSum = 0;
        for(int num : skill) targetSum += num;
        targetSum /= (n/2);
        int i = 0, j = n-1;
        long ans = 0;
        while(i < j){
            if(skill[i]+ skill[j] != targetSum) return -1;
             ans += (skill[i] * skill[j]);
             i++;
             j--;
        }
        return ans;
    }
}