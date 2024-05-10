import java.util.*;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int n = arr.length;

        // Initialize the priority queue with all the fractions
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pq.add(new Pair(arr[i], arr[j]));
            }
        }

        // Remove k - 1 smallest fractions from the priority queue
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }

        // Return the k-th smallest fraction
        Pair result = pq.poll();
        return new int[]{result.num, result.den};
    }
}

class Pair implements Comparable<Pair> {
    int num;
    int den;

    Pair(int num, int den) {
        this.num = num;
        this.den = den;
    }

    @Override
    public int compareTo(Pair p) {
        double fraction1 = (double) this.num / this.den;
        double fraction2 = (double) p.num / p.den;
        return Double.compare(fraction1, fraction2);
    }
}
