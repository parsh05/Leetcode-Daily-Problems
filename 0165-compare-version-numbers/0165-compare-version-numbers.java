class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int i=0 , j = 0;
        while( i < s1.length && j < s2.length ){
            int n1 = Integer.parseInt(s1[i] );
            int n2 = Integer.parseInt(s2[j]);
            if(n1 > n2) return 1;
            else if(n1 < n2 ) return -1;

            i++;
            j++;
        }
        while(i<s1.length){
             int n1 = Integer.parseInt(s1[i] );
             if(n1 != 0) return 1;
             i++;
        }
        while(j<s2.length){
             int n2 = Integer.parseInt(s2[j] );
             if(n2 != 0) return -1;
             j++;
        }
        return 0;
    }
}