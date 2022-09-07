class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        int[] l = new int[n], r = new int[n];
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            l[i] = mp.getOrDefault(s.charAt(i), -1);
            mp.put(s.charAt(i), i);
        }
        mp.clear();
        for (int i = n - 1; i > -1; i--) {
            r[i] = mp.getOrDefault(s.charAt(i), n);
            mp.put(s.charAt(i), i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = l[i], b = r[i];
            ans += (i - a) * (b - i);
        }
        return ans;
    }
}