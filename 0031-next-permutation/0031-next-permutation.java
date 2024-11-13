class Solution {
    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int idx = -1;

        // Step 1: Find the breakpoint
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            // Reverse the entire array when no breakpoint is found
            reverse(arr, 0, n - 1);
            return;
        }

        // Step 2: Find the smallest number greater than arr[idx] to swap with
        for (int i = n - 1; i > idx; i--) {
            if (arr[i] > arr[idx]) {
                // Swap
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                break;
            }
        }

        // Step 3: Reverse the subarray from idx + 1 to end
        reverse(arr, idx + 1, n - 1);
    }

    void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
