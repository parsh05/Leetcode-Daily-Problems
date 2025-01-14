class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];

        HashSet<Integer> hs1 = new HashSet<>();
         HashSet<Integer> hs2 = new HashSet<>();
        for(int i = 0; i < n; i++){
 
            // if(A[i] == B[i]){
            //     if(i == 0) C[i] = 1;
            //     else C[i] = C[i-1] + 1;
            //     continue;
            // }

            // boolean presentInB = false, presentInA = false;

            hs1.add(A[i]);
            if(hs1.contains(B[i])){
                hs1.remove(B[i]);
                hs2.remove(B[i]);
            }
            
            hs2.add(B[i]);
            if(hs2.contains(A[i])){
                hs2.remove(A[i]);
                hs1.remove(A[i]);
            }
            C[i] = (i+1) - Math.min(hs1.size(), hs2.size());
        }
        return C;
    }
}