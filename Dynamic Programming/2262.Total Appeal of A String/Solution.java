class Solution {
    public long appealSum(String s) {
        long ans = 0, cnt = 0;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); i++) {
            cnt += i - last[s.charAt(i) - 'a'];
            ans += cnt;
            last[s.charAt(i) - 'a'] = i;
        }
        return ans;
    }
}