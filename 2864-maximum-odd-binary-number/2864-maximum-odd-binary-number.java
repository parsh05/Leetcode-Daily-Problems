class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] c = s.toCharArray();
        int ones = 0;
        for (char value : c) {
            if (value == '1') {
                ones++;
            }
        }
        int zeros = c.length - ones;    
        StringBuilder answer = new StringBuilder();       
        for (int i = 0; i < ones - 1; i++) {
            answer.append("1");
        }       
        for (int i = 0; i < zeros; i++) {
            answer.append("0");
        }
        answer.append("1");
        return answer.toString();
    }
}