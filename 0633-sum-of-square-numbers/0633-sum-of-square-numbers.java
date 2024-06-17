class Solution {
    private boolean isSquare( int l, int square, int h){
        while( l <= h){
            int mid = (h-l)/2 + l;
            if( square == mid * mid) return true;
            else if( square < mid * mid ) h = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
    public boolean judgeSquareSum(int c) {
        int sqrt_c = (int ) Math.sqrt(c);
        for(int i = 0; i <= sqrt_c ; i++ ){
            if( isSquare( i , c - i * i, sqrt_c) ) return true; 
        }
        return false;
    }
}