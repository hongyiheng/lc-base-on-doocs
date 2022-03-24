class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int cur = 1;
        while (ans.size() < n) {
            while (cur <= n) {
                ans.add(cur);
                cur *= 10;
            }
            while (cur % 10 == 9 || cur > n) {
                cur /= 10;
            }
            cur++;
        }
        return ans;
    }
}