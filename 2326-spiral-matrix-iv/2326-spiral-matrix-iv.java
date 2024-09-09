/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] arr = new int[m][n];
        int up = 0, left = 0, right = n - 1, down = m - 1;

        while (up <= down && left <= right) {
            // go to right
            for (int i = left; i <= right; i++) {
                if (head == null)
                    arr[up][i] = -1;
                else {
                    arr[up][i] = head.val;
                    head = head.next;
                }
            }
            up++;
            if(up > down ) break;
            // go to down
            for (int i = up; i <= down; i++) {
                if (head == null)
                    arr[i][right] = -1;
                else {
                    arr[i][right] = head.val;
                    head = head.next;
                }
            }
            right--;
            if(left > right) break;
            // go to Left
            for (int i = right; i >= left; i--) {
                if (head == null)
                    arr[down][i] = -1;
                else {
                    arr[down][i] = head.val;
                    head = head.next;
                }
            }
            down--;
             if(up > down ) break;
            // go up
            for (int i = down; i >= up; i--) {
                if (head == null)
                    arr[i][left] = -1;
                else {
                    arr[i][left] = head.val;
                    head = head.next;
                }
            }
            left++;
            if(left > right) break;
        }

        return arr;
    }

}