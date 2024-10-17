import java.util.PriorityQueue;

class Solution {
    public int maximumSwap(int num) {
        // Convert the number into an array of digits
        String numStr = Integer.toString(num);
        int[] arr = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            arr[i] = numStr.charAt(i) - '0'; // Convert each character to integer
        }

        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if(arr[a] == arr[b] ) return a - b;
            return arr[b] - arr[a];
        });
        for (int i = 0; i < n; i++) pq.add(i);

        for (int i = 0; i < n; i++) {
            if (arr[i] != arr[pq.peek()]) {
                // Swap and break
                int temp_idx = pq.poll();
                int temp = arr[temp_idx];
                arr[temp_idx] = arr[i];
                arr[i] = temp;
                break;
            } else {
                pq.poll();
            }
        }

        // Create number from the modified integer array
        int number = 0;
        for (int dig : arr) {
            number = number * 10 + dig;
        }
        return number;
    }
}
