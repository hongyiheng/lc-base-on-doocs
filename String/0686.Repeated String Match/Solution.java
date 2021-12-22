class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder cur = new StringBuilder();
        int ans = 0;
        while (cur.length() < b.length()) {
            ans++;
            cur.append(a);
        }
        if (cur.toString().contains(b)) {
            return ans;
        }
        ans++;
        cur.append(a);
        if (cur.toString().contains(b)) {
            return ans;
        }
        return -1;
    }
}