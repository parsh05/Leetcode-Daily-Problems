class Solution {
    public int getLucky(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
           int num =  s.charAt(i) - 'a' + 1 ;
            sb.append(Integer.toString(num) );
        }
        int sum = 0;
        for(int i = 0; i < sb.length(); i++){
            sum += sb.charAt(i) - '0';
        }

        k--;
        while( k-- > 0 ){
            int num = 0;
            while( sum > 0){
                num += sum % 10;
                sum /= 10;
            }
            sum = num;
        }
        return sum;
    }
}