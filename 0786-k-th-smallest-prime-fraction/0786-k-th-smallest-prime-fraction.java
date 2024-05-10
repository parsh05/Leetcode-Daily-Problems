import java.util.*;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;

        // Initialize the priority queue with fractions having smallest denominator
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < n - 1; i++) {
            for(int j = n - 1; j >=n-k && i!=j ;j--){
                pq.add(new Pair(arr[i],arr[j]));
                if(pq.size()>k)pq.poll();
            }
        }

        // Pop k-1 smallest fractions from the priority queue
        
        // Return the k-th smallest fraction
        Pair result = pq.poll();
        return new int[]{result.num, result.den};
    }
}

class Pair implements Comparable<Pair>  {
    int num; // numerator index
    int den; // denominator index

    Pair(int num, int den) {
        this.num = num;
        this.den = den;
    }
    @Override
    public int compareTo(Pair p) {
        double fraction1 = (double) this.num / this.den;
        double fraction2 = (double) p.num / p.den;
        return Double.compare(fraction2, fraction1);
    }
}
