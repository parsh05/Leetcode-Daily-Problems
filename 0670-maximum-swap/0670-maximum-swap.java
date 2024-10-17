class Solution {
    public int maximumSwap(int num) {
        // Convert the number into an array of digits
        char[] arr = Integer.toString(num).toCharArray();
        int n = arr.length;

        // Track the last occurrence of each digit (0-9)
        int[] last = new int[10];
        for (int i = 0; i < n; i++) {
            last[arr[i] - '0'] = i;  // Store the index of the last occurrence
        }

        // Traverse the number's digits
        for (int i = 0; i < n; i++) {
            // For each digit, check if a larger digit occurs later
            for (int d = 9; d > arr[i] - '0'; d--) {
                if (last[d] > i) {
                    // Swap the current digit with the larger one found later
                    char temp = arr[i];
                    arr[i] = arr[last[d]];
                    arr[last[d]] = temp;
                    // After one swap, return the new number
                    return Integer.parseInt(new String(arr));
                }
            }
        }

        // If no swap was made, return the original number
        return num;
    }
}
