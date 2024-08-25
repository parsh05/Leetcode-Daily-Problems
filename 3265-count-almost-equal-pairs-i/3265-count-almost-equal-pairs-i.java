class Solution {
    int ans = 0;

    public int countPairs(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                solve(nums[i], nums[j]);
            }
        }
        return ans;
    }

    private void solve(int n1, int n2) {
        int bigNo = Math.max(n1, n2);
        int smallNo = Math.min(n1, n2);

        if (bigNo == smallNo) {
            ans++;
            return;
        }

        String bigNum = Integer.toString(bigNo);
        int m = bigNum.length();

        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                int swappedNo = swap(new StringBuilder(bigNum), i, j);
                if (swappedNo == smallNo) {
                    ans++;
                }
            }
        }
    }

    private int swap(StringBuilder sb, int i, int j) {
        char ith_idx_char = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, ith_idx_char);
        return Integer.parseInt(sb.toString());
    }
}