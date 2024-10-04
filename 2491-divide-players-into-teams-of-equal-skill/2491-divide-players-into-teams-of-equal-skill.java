class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        if(n%2 == 1) return -1;
        long sum = 0;
        for(int num : skill) sum += num;
        if(sum % (n/2) != 0 ) return -1;
        long targetSum = sum / (n/2);
        int[] count_target = new int[(int)targetSum + 1];
        for(int num : skill){
            if(num > targetSum ) return -1;
            count_target[num]++;
        }
        long ans = 0;
        for(int i = 0; i < n; i++){
            int num = skill[i];
            
            if(count_target[(int)(targetSum - num)] > 0){
                count_target[(int)(targetSum - num)]--;
                ans += (num * ((int)(targetSum-num)));
            } else return -1;
        }
        return ans/2;
    }
}