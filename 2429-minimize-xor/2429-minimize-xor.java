class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBitX = setBits(num2);
        int setBitN1 = setBits(num1);
        int y = (~num1);

        int res = 0;

        if(setBitX > setBitN1){
            int diffBit = setBitX - setBitN1;
            // count contrib. only by 1's present
            int rmsb = 1;
            
            for(int i = 0; diffBit > 0 && i < 32; i++){
                if((rmsb & y) != 0){
                    diffBit--;
                    res += rmsb;
                }
                rmsb *= 2;
            }
        } else{
            int diffBit = setBitN1 - setBitX;
            // count contrib. only by 0's present
            int rmsb = 1;
            for(int i = 0; diffBit > 0 && i < 32; i++){
                if((rmsb & y) == 0){
                    diffBit--;
                    res += rmsb;
                }
                rmsb *= 2;
            }
        }

        int x = (res ^ num1);
        return x;
    }
    int setBits(int num){
        int count = 0;
        while(num > 0){
            int rmsb = num & (-num);
            count++;
            num -= rmsb;
        }
        return count;
    }
}