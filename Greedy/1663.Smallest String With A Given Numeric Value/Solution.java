class Solution {
    public String getSmallestString(int n, int k) {
        int[] s = new int[n];
        Arrays.fill(s, 1);
        k -= n;
        int idx = n - 1;
        while (k > 0) {
            s[idx] += Math.min(25, k);
            idx--;
            k -= 25;
        }
        List<String> ans = new ArrayList<>();
        for (int v : s) {
            ans.add(String.valueOf((char)(v + 'a' - 1)));
        }
        return String.join("", ans);
    }
}