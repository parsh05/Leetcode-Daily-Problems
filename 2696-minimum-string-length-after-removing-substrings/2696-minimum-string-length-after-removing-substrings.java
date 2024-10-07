class Solution {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        int length = s.length();
        while (s.contains("AB") || s.contains("CD") ) {
            length -= 2;
            int startIdx = s.indexOf("AB");
            if(startIdx == -1) startIdx = s.indexOf("CD");
            s = s.substring(0, startIdx) + s.substring(startIdx + 2);
        }
        
        return length;
    }
}