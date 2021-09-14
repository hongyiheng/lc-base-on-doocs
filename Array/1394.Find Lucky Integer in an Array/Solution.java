class Solution {
    public int findLucky(int[] arr) {
        int[] counter = new int[501];
        for (int num : arr) {
            counter[num]++;
        }
        int ans = -1;
        for (int i = 1; i < counter.length; i++) {
            if (i == counter[i] && ans < i) {
                ans = i;
            }
        }
        return ans;
    }
}