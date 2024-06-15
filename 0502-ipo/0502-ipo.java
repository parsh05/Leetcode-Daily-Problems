class Pair implements Comparable<Pair>{
    int profit;
    int capital;
    Pair( int profit, int capital ){
        this.profit = profit;
        this.capital = capital;
    }
    @Override
    public int compareTo(Pair p){
        if(this.capital == p.capital )return p.profit- this.profit;
        return this.capital - p.capital;
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Pair[] project = new Pair[n];
        for( int i = 0; i < n; i++ ) 
            project[i] = new Pair( profits[i], capital[i]);
        
        int i = 0;
        Arrays.sort( project );
        while( k > 0 && i < n ){
            if( project[i].capital > w )i++;
            else {
                w += project[i].profit;
                k--;
                i++;
            }
        }
        return w;

    }
}
