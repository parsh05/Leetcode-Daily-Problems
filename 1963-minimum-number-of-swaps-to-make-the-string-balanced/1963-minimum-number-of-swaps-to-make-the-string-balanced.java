class Solution {
    public int minSwaps(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        // dq.add(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ']'){
                if(dq.size() > 0 && dq.peekLast() == '[') dq.pollLast();
                else dq.addLast(']');
            } else if(ch == '[') dq.addLast('[');
        }
        int count = 0;
        while (dq.size() > 1){
            count++;
            dq.pollFirst();
            dq.pollLast();
            dq.pollFirst();
            dq.pollLast();
        }
        return count + dq.size();
    }
}