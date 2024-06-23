class Solution {
    public int findPeakElement(int[] arr) {
        int low = 0, high = arr.length - 1;
        while( low <= high ){
            int mid = low + ( high - low )/2;
            int prev = (mid > 0)?  arr[mid - 1] : Integer.MIN_VALUE;
            int next = (mid < arr.length - 1 )? arr[mid + 1] : Integer.MIN_VALUE;
            
            if( arr[mid] >= prev && arr[mid] >= next ) return mid;
            else if( arr[mid] > next ) high = mid - 1;
            else  low = mid + 1;
        }
        return low;
    }
}