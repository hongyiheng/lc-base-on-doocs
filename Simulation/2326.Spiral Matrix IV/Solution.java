/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        for (int[] row : ans) {
            Arrays.fill(row, -1);
        }
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        int cur = 0;
        while (head != null) {
            if (x < 0 || x >= m || y < 0 || y >= n || ans[x][y] != -1) {
                x -= dirs[cur][0];
                y -= dirs[cur][1];
                cur = cur + 1 == 4 ? 0 : cur + 1;
                x += dirs[cur][0];
                y += dirs[cur][1];
            } else {
                ans[x][y] = head.val;
                head = head.next;
                x += dirs[cur][0];
                y += dirs[cur][1];
            }
        }
        return ans;
    }
}