class Solution {
    public int minMoves2(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        // its a median Question
        int m = n/2;
        int minMoves = 0;
        for(int num : arr)  minMoves += Math.abs(arr[m] - num);

        return minMoves;
    }
}